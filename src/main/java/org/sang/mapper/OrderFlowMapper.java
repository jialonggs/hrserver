package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.OrderFlow;

public interface OrderFlowMapper {

    int addOrderFlow(OrderFlow orderFlow);

    OrderFlow getByOrderId(@Param("orderId") Long orderId);

    int updateOrderFlow(@Param("orderFlow") OrderFlow orderFlow);
}
