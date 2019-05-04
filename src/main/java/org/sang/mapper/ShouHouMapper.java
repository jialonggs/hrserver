package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.ShouHou;
import org.sang.bean.responseEntity.OrderShouhou;

import java.util.List;

public interface ShouHouMapper {

    int add(ShouHou shouHou);

    int updateShouHou(ShouHou shouHou);

    List<OrderShouhou> getShouHouList(@Param("userId") Integer userId, @Param("status")Integer status);

    int updateShouHouStatus(@Param("orderId") Integer orderId, @Param("status") Integer status);

    ShouHou getShouHouByOrderId(@Param("orderId") Integer orderId);

    OrderShouhou getShouHouById(@Param("id") Integer id);

    List<OrderShouhou> getAfterOrdersList(@Param("status") Integer status);

    int updateXzOrBg(@Param("id") Long id, @Param("xzId") Integer xzId, @Param("shId") Integer shId);

    int updateBGIdStatus (@Param("orderId") Integer orderId, @Param("shId") Long shId, @Param("status") Integer status);

    int updateWanJie(@Param("id") Integer id, @Param("wanJieUrls") String  urls, @Param("wanJieRemark") String wanJieRemark);
}
