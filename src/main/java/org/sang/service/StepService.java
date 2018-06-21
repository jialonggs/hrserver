package org.sang.service;

import org.sang.bean.Step;
import org.sang.mapper.StepMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepService {

    @Autowired
    StepMapper stepMapper;

    public int addStep(Step step){
        return stepMapper.addStep(step);
    }

    public List<Step> getStepsList(){
        return stepMapper.getStepsList();
    }

    public int delStep(Long id){
        return stepMapper.delStep(id);
    }

}
