package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> getOrdersList(@Param("addUserId") Integer addUserId);

    int addOrder(Order order);

}
