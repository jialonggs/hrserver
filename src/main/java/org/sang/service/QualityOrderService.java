package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.*;
import org.sang.bean.responseEntity.OverOrderResponse;
import org.sang.bean.responseEntity.QualityOrderResp;
import org.sang.mapper.*;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QualityOrderService {

    @Autowired
    QualityOrderUserMapper qualityOrderUserMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderFlowMapper orderFlowMapper;

    @Autowired
    UserOrderMapper userOrderMapper;

    @Autowired
    OrderArgeLogMapper orderArgeLogMapper;

    @Autowired
    ProjectMapper projectMapper;


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<QualityOrderResp> getQualityOrders(PageInfoEntity pageInfoEntity, Integer userId, Integer status) {
        if(null != userId && 3 != userId){
            PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
            List<QualityOrderResp> list = qualityOrderUserMapper.getQualityOrdersList(userId, status);
            PageInfo page = new PageInfo(list);
            PageBean<QualityOrderResp> pageData = new PageBean<>();
            pageData.setItems(list);
            pageData.setPageInfo(page);
            return  pageData;
        }else{
            PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
            List<QualityOrderResp> list = qualityOrderUserMapper.getQualityOrdersList(3, status);
            PageInfo page = new PageInfo(list);
            PageBean<QualityOrderResp> pageData = new PageBean<>();
            pageData.setItems(list);
            pageData.setPageInfo(page);
            return  pageData;
        }

    }


    public PageBean<QualityOrderResp> getQualityOrdersAll(PageInfoEntity pageInfoEntity, Integer userId, Integer status) {
            PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
            List<QualityOrderResp> list = qualityOrderUserMapper.getQualityOrdersList(3, status);
            PageInfo page = new PageInfo(list);
            PageBean<QualityOrderResp> pageData = new PageBean<>();
            pageData.setItems(list);
            pageData.setPageInfo(page);
            return  pageData;


    }

    /**
     * 获取加工完成的列表
     * @param pageInfoEntity
     * @return
     */
    public PageBean<OverOrderResponse> getOverOrders(PageInfoEntity pageInfoEntity) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());

        List<OverOrderResponse> list = orderMapper.getOverOrdersList(1,2, null, null);
        PageInfo page = new PageInfo(list);
        PageBean<OverOrderResponse> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    /**
     * 获取加工完成的列表
     * @param pageInfoEntity
     * @return
     */
    public PageBean<OverOrderResponse> getOverOrders1(PageInfoEntity pageInfoEntity, Long projectId, Long unitId, String orderName) {
            PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<Project> projects = new ArrayList<>();
        if(unitId != null){
            // 获取单位下的 projectId
            projects = projectMapper.getByUnitId(unitId);
        }
        if (projectId != null ) {
            Project project = projectMapper.getProjectById(projectId);
            projects.add(project);
        }
        if (projects.isEmpty()) {
            projects = null;
        }
            List<OverOrderResponse> list = orderMapper.getOverOrdersList(1,2, orderName, projects);
            PageInfo page = new PageInfo(list);
            PageBean<OverOrderResponse> pageData = new PageBean<>();
            pageData.setItems(list);
            pageData.setPageInfo(page);
            return  pageData;
    }

    @Transactional
    public Boolean shenHe(Order order, OrderFlow orderFlow, List<UserOrder> userOrderList, List<OrderArgeLog> orderArgeLogs, Integer status){
        int i =  orderMapper.updateOrder(order);
        int k = orderFlowMapper.updateOrderFlow(orderFlow);
        if(null != userOrderList && !userOrderList.isEmpty()){
            for (UserOrder userOrder : userOrderList){
                userOrderMapper.updateUserAage(userOrder);
            }
        }
        if(status.equals(1)){
            int j = qualityOrderUserMapper.updateStatus(status, order.getId());
            Order order1 = new Order();
            order1.setId(order.getId());
            order.setFinishTime(new Date());
            int o = orderMapper.updateOrder(order1);
        }
        if(null != orderArgeLogs && !orderArgeLogs.isEmpty()){
            int y = orderArgeLogMapper.insertLogs(orderArgeLogs);
        }
        if(i> 0 && k > 0){
            return true;
        }else{
            return false;
        }
    }


    @Transactional
    public Boolean toDefaultJingFeng(Order order, List<UserOrder> userOrderList, List<OrderArgeLog> orderArgeLogs, Integer status){
        order.setJingFengStatus(1);
        int i =  orderMapper.updateOrder(order);
        if(null != userOrderList && !userOrderList.isEmpty()){
            for (UserOrder userOrder : userOrderList){
                userOrderMapper.updateUserAage(userOrder);
            }
        }
       List<QualityOrderUser> qualityOrderUsers = qualityOrderUserMapper.getQualityOrders(order.getId());
        if(qualityOrderUsers !=null && qualityOrderUsers.isEmpty() ){
            for (QualityOrderUser qualityOrderUser : qualityOrderUsers) {
                if(qualityOrderUser.getStatus() == 0 && order.getLiuChengStatus() == 2 ){
                    qualityOrderUserMapper.updateStatus(1, order.getId());
                }
            }
        }
        int y = 0;
        if(null != orderArgeLogs && !orderArgeLogs.isEmpty()){
           y = orderArgeLogMapper.insertLogs(orderArgeLogs);
        }
        if(i> 0 && y>0){
            return true;
        }else{
            return false;
        }
    }

    @Transactional
    public Boolean jingFengJieSuan(Order order, List<OrderArgeLog> orderArgeLogs, List<UserOrder> needAdd,
                                   List<UserOrder> newUserOrders,List<UserOrder> delJingFeng){
        order.setFinishTime(new Date());
        int i =  orderMapper.updateOrder(order);
        if(null != orderArgeLogs && !orderArgeLogs.isEmpty()){
            int y = orderArgeLogMapper.insertLogs(orderArgeLogs);
        }

        // 需要更新
        if(null != newUserOrders && !newUserOrders.isEmpty()){
            for (UserOrder userOrder : newUserOrders){
                int k = userOrderMapper.updateUserOrder(userOrder);
            }
        }
        // 需要清除无需精封
        if(null != delJingFeng && !delJingFeng.isEmpty()){
            for (UserOrder userOrder : delJingFeng){
                int k = userOrderMapper.delJingFeng(userOrder);
            }
        }
        // 需要添加
        if(null != needAdd && !needAdd.isEmpty()){
            int result = userOrderMapper.addUserOrder(needAdd);
        }
        List<QualityOrderUser> qualityOrderUsers = qualityOrderUserMapper.getQualityOrders(order.getId());
        if(qualityOrderUsers !=null && qualityOrderUsers.isEmpty() ){
            for (QualityOrderUser qualityOrderUser : qualityOrderUsers) {
                if(qualityOrderUser.getStatus() == 0 && order.getLiuChengStatus() == 2 ){
                    qualityOrderUserMapper.updateStatus(1, order.getId());
                }
            }
        }
        return true;
    }


    public QualityOrderUser checkUserOrderAuth(Long userId, Long orderId){
        QualityOrderUser qu = qualityOrderUserMapper.checkOrderAuth(userId, orderId);
        return qu;
    }

}
