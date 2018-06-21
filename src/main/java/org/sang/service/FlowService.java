package org.sang.service;

import com.sun.org.apache.regexp.internal.RE;
import org.sang.bean.Flow;
import org.sang.bean.responseEntity.FlowStepsResp;
import org.sang.mapper.FlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowService {
    @Autowired
    FlowMapper flowMapper;

    public Long addFlow(Flow flow){
        flowMapper.addFlow(flow);
        return flow.getId();
    }

    public List<FlowStepsResp> selectALL(){
        return flowMapper.selectAll();
    }
}
