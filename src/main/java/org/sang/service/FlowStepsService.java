package org.sang.service;

import org.sang.bean.FlowSteps;
import org.sang.mapper.FlowStepsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowStepsService {
    @Autowired
    FlowStepsMapper flowStepsMapper;

    public int addFlowSteps(List<FlowSteps> flowSteps){
        return flowStepsMapper.addFlowSteps(flowSteps);
    }

    public FlowSteps getById(Long id){
        return flowStepsMapper.getById(id);
    }

    public FlowSteps getByOrderIdAndIndex(Long orderId, Integer index){
        return flowStepsMapper.flowStepsMapper(orderId, index);
    }
}
