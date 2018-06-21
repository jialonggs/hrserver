package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.FlowSteps;
import org.springframework.security.access.method.P;

import java.util.List;

public interface FlowStepsMapper {
    int addFlowSteps(@Param("list") List<FlowSteps> flowSteps);
    FlowSteps getById(@Param("id") Long id);

    FlowSteps flowStepsMapper(@Param("orderId")Long orderId, @Param("index") Integer index);
}
