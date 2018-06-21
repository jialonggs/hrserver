package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.OrderArgeLog;

import java.util.List;

public interface OrderArgeLogMapper {

    List<OrderArgeLog> getLogs(@Param("startTime") String startTime);

    int insertLogs(@Param("orderArgeLogs") List<OrderArgeLog> orderArgeLogs);

}
