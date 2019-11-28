package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.StorageBill;

public interface StorageBillMapper {

    int addBill(StorageBill storageBill);

    StorageBill getByOrderId(@Param("orderId") Long orderId);
}
