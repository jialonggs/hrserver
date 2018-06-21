package org.sang.service;

import org.sang.bean.OrderFlow;
import org.sang.mapper.OrderFlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderFlowService {

    @Autowired
    OrderFlowMapper orderFlowMapper;

    public OrderFlow getByOrderId(Long orderId){
        return orderFlowMapper.getByOrderId(orderId);
    }
}
