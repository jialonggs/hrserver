package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.SHBaoGao;

public interface SHBaoGaoMapper {

    int add(SHBaoGao shBaoGao);

    SHBaoGao getByOrderId(@Param("orderId") Long orderId);
}
