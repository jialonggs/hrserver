package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.ShouHou;
import org.sang.bean.responseEntity.OrderShouhou;

import java.util.List;

public interface ShouHouMapper {

    int add(ShouHou shouHou);

    List<OrderShouhou> getShouHouList(@Param("userId") Integer userId, @Param("status")Integer status);

    int updateShouHouStatus(@Param("orderId") Long orderId);
}
