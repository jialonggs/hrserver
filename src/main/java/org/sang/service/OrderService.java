package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.*;
import org.sang.bean.requestEntity.AddFuKuanRequest;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.FaMoOrder;
import org.sang.bean.responseEntity.OrderInfoResp;
import org.sang.mapper.*;
import org.sang.utils.DoubleUtil;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    MouldInfoMapper mouldInfoMapper;

    @Autowired
    UserOrderMapper userOrderMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    HrMapper hrMapper;



    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<FaMoOrder> getOrdersList(PageInfoEntity pageInfoEntity, Integer addUserId) {
       // List<Role> roles = hrMapper.getRolesByHrId(addUserId);

        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<FaMoOrder> list = orderMapper.getOrderAndProject(addUserId);
        PageInfo page = new PageInfo(list);
        PageBean<FaMoOrder> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    /**
     * 分页查询车间新的订单
     * @param pageInfoEntity
     * @return
     */
    public PageBean<Order> getPlantOrdersList(PageInfoEntity pageInfoEntity, Long userId, Integer plantStatus) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<Order> list = orderMapper.getPlantOrdersList(userId, plantStatus);
        PageInfo page = new PageInfo(list);
        PageBean<Order> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    /**
     * 分页查询车间新的订单
     * @param pageInfoEntity
     * @return
     */
    public PageBean<Order> getWaitStorageOrder1(PageInfoEntity pageInfoEntity, Integer storageStatus) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<Order> list = orderMapper.getStroageOrdersList1(storageStatus);
        PageInfo page = new PageInfo(list);
        PageBean<Order> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    public PageBean<Order> getWaitStorageOrder(PageInfoEntity pageInfoEntity, Integer liuChengStatus, Integer jingFengStatus, Integer storageStatus) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<Order> list = orderMapper.getStroageOrdersList(liuChengStatus, jingFengStatus, storageStatus);
        PageInfo page = new PageInfo(list);
        PageBean<Order> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    /**
     * 分页查询未提交工艺卡列表
     * @param pageInfoEntity
     * @return
     */
    public PageBean<Order> getOrdersUnAddedTech(PageInfoEntity pageInfoEntity,Boolean techId) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<Order> list = orderMapper.getOrdersUnAddTech(techId);
        PageInfo page = new PageInfo(list);
        PageBean<Order> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    public Long getMaxOrderID(){
       Long id =  orderMapper.getMaxOrderID();
       return id == null ? 0 : id;
    }

    /**
     *添加订单基础信息
     * @param order
     * @return
     */
    public Long addOrder(Order order) {
        orderMapper.addOrder(order);
        return order.getId();
    }

    public void orderSelectMould(Long[] mouldIds, Long uid, Long orderId) {
//        Map<String,Object> map = new HashMap<>();
//        List<MouldInfo> list = new ArrayList<>();
        for (Long id : mouldIds){
//            MouldInfo mouldInfo = new MouldInfo();
//            mouldInfo.setId(id);
//            mouldInfo.setSelectId(uid);
//            mouldInfo.setOrderId(orderId);
//            mouldInfo.setDeleted(true);
//            mouldInfo.setUpdateTime(new Date());
            mouldInfoMapper.updateMouldInfoBySelected(id, uid, orderId);
            // list.add(mouldInfo);
        }
//        map.put("list", list);
//        mouldInfoMapper.updateMouldInfoBySelected(map);
    }


    @Transactional
    public OrderInfoResp getOrderInfoResp(Long orderId){
        return orderMapper.getOrderInfoResp(orderId);
    }


    public Order getOrderInfoById(Long orderId){
        return orderMapper.getOrderInfoById(orderId);
    }

    public Boolean updateBaseInfo(Order order){
        int i = orderMapper.updateOrderBaseInfo(order);
        if(i > 0){
            return true;
        }else{
            return false;
        }
    }


    @Transactional
    public Double liuZhuan(Order order, UserOrder userOrder){
        Double shengYu = userOrder.getShengYuArea();

        Double liuZhuanBiLi = shengYu / order.getWorkArea();
        liuZhuanBiLi = DoubleUtil.m2(liuZhuanBiLi);
        Double biLi = userOrder.getBiLi() - liuZhuanBiLi * 100;
        Double finalBiLi = liuZhuanBiLi*100 + order.getLiuZhuanBiLi();

        int i = orderMapper.liuZhuan(order.getId(), 1, shengYu+order.getLiuZhuanArea(), finalBiLi);
        int k = userOrderMapper.jieSuan(userOrder.getId(), 1,  biLi, liuZhuanBiLi * 100);

        if(i > 0 && k > 0){
            return liuZhuanBiLi * 100;
        }else{
            return -1.0;
        }
    }

    public int updateOrderNanDu(String nanDuDengJi, Long orderId){
        return orderMapper.updateOrderNanDu(nanDuDengJi, orderId);
    }



    public Boolean updateFuKuan(AddFuKuanRequest addFuKuanRequest){
        int i = orderMapper.addFuKuan(addFuKuanRequest);
        if(i > 0){
            return true;
        }else{
            return false;
        }
    }

    public List<Order> getNeedAlert(String beginDate){
        List<Order> list = orderMapper.getCheckOrder(beginDate);
        return list;
    }


}
