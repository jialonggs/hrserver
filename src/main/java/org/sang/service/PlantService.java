package org.sang.service;

import org.sang.bean.*;
import org.sang.mapper.OrderFlowMapper;
import org.sang.mapper.OrderMapper;
import org.sang.mapper.QualityOrderUserMapper;
import org.sang.mapper.UserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PlantService {
    @Autowired
    UserOrderMapper userOrderMapper;

    @Autowired
    QualityOrderUserMapper qualityOrderUserMapper;

    @Autowired
    OrderFlowMapper orderFlowMapper;

    @Autowired
    OrderMapper orderMapper;

    @Transactional
    public Boolean fenPei(Order order, List<UserOrder> ygas, List<QualityOrderUser> qualityUsers, OrderFlow orderFlow){
        int result = userOrderMapper.addUserOrder(ygas);
        int addQuality = qualityOrderUserMapper.addQualityOrderUsers(qualityUsers);
        int addFlow = orderFlowMapper.addOrderFlow(orderFlow);
        // 更新订单（面积）
        order.setPlantStatus(1);
        order.setLiuChengStatus(1);
        int orderUpdate = orderMapper.updateOrder(order);

        if(result > 0 && addQuality > 0 && addFlow > 0 && orderUpdate > 0) {
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    public Double liuZhuan(List<UserOrder> ygas, Order order){
        if(null == ygas){
            return -1.0;
        }
        Double itemBiLi = 0.0;
        for(UserOrder userOrder : ygas){
            itemBiLi = itemBiLi + userOrder.getBiLi();
        }
        Double finalBiLi = order.getLiuZhuanBiLi() - itemBiLi;
        Double liuZhuaArea =  order.getWorkArea() * finalBiLi / 100;

        Integer status = 1;
        if(finalBiLi <= 0){
            status = 0;
        }
        int result = userOrderMapper.addUserOrder(ygas);
        int i = orderMapper.liuZhuan(order.getId(),status, liuZhuaArea, finalBiLi);
        if(result > 0 ) {
            return itemBiLi;
        }else {
            return -1.0;
        }
    }
}
