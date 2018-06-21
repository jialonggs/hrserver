package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.ControlOrderFrom;

@Mapper
public interface ControlOrderFromMapper {

    int addControlOrderFrom(ControlOrderFrom controlOrderFrom);

    ControlOrderFrom getByOrderId(@Param("orderId") Long orderId);

    int updateControlOrderFrom(@Param("order") ControlOrderFrom controlOrderFrom);
}
