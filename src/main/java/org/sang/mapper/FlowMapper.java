package org.sang.mapper;

import org.sang.bean.Flow;
import org.sang.bean.responseEntity.FlowStepsResp;

import java.util.List;

public interface FlowMapper {

    int addFlow(Flow flow);

    List<FlowStepsResp> selectAll();
}
