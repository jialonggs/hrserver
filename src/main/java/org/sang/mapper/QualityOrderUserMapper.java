package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.QualityOrderUser;
import org.sang.bean.responseEntity.QualityOrderResp;

import java.util.List;

public interface QualityOrderUserMapper {

    int addQualityOrderUsers( @Param("qualityOrderUsers") List<QualityOrderUser> qualityOrderUser);

    List<QualityOrderResp> getQualityOrdersList(@Param("userId") Integer userId, @Param("status") Integer status);

    int updateStatus(@Param("status") Integer status, @Param("orderId") Long orderId);

    List<QualityOrderResp> getOverOrdersList();

    QualityOrderUser checkOrderAuth(@Param("userId") Long userId, @Param("orderId") Long orderId);

    List<QualityOrderUser> getQualityOrders(@Param("id") Long orderId);

    int delByOrderId(@Param("orderId") Long orderId);
}
