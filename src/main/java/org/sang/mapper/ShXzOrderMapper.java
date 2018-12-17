package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.ShXzOrder;

public interface ShXzOrderMapper {

    int addShXzOrder (ShXzOrder shXzOrder);

    ShXzOrder getByOrderId(@Param("orderId") Integer orderId);

    int updateSh(@Param("order") ShXzOrder shXzOrder);
}
