package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.UserOrder;
import org.sang.bean.responseEntity.UserOrderCountResp;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserOrderMapper {

    int addUserOrder(@Param("userOrders") List<UserOrder> userOrders);

    List<UserOrder> getUserOrderByOrderId(@Param("orderId") Long orderId, @Param("status") Integer status);

    List<UserOrder> getByOrderId(@Param("id") Long orderId);

    int updateUserAage(@Param("userOrder") UserOrder userOrder);

    List<UserOrder> getByTime(@Param("startTime") String startTime);

    List<UserOrder> getLastTime(@Param("startTime") String  startTime, @Param("status") Integer status);

    int jieSuan(@Param("id") Long id, @Param("status") Integer status, @Param("biLi") Double biLi, @Param("liuZhuanBiLi") Double liuZhuanBiLi);

    int updateUserOrder(@Param("userOrder") UserOrder userOrder);

    int delJingFeng(@Param("userOrder") UserOrder userOrder);

    List<UserOrderCountResp> getCountUserOrder(@Param("userId") Integer userId, @Param("startTime") String startTime,  @Param("endTime") String endTime);

    UserOrder checkOrderAuth(@Param("userId") Long userId, @Param("orderId") Long orderId);

    int delByOrderId(@Param("orderId") Long orderId);
}
