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


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<QualityOrderResp> getQualityOrders(PageInfoEntity pageInfoEntity, Integer userId, Integer status) {
        if(null != userId){
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

    /**
     * 获取加工完成的列表
     * @param pageInfoEntity
     * @return
     */
    public PageBean<OverOrderResponse> getOverOrders(PageInfoEntity pageInfoEntity) {
            PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
            List<OverOrderResponse> list = orderMapper.getOverOrdersList(1,2);
            PageInfo page = new PageInfo(list);
            PageBean<OverOrderResponse> pageData = new PageBean<>();
            pageData.setItems(list);
            pageData.setPageInfo(page);
            return  pageData;
    }

    @Transactional
    public Boolean shenHe(Order order, OrderFlow orderFlow, List<UserOrder> userOrderList, List<OrderArgeLog> orderArgeLogs, Integer status){
        System.out.print("----------------------------------------");
        System.out.print(order.toString());
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
    public Boolean jingFengJieSuan(Order order, List<OrderArgeLog> orderArgeLogs, List<UserOrder> needAdd, List<UserOrder> newUserOrders){
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
        // 需要添加
        if(null != needAdd && !needAdd.isEmpty()){
            int result = userOrderMapper.addUserOrder(needAdd);
        }
        return true;
    }

}
