package org.sang.bean.responseEntity;

import org.sang.bean.Flow;
import org.sang.bean.FlowSteps;

import java.util.List;

public class FlowStepsResp extends Flow{

    List<FlowSteps> stepslist;

    public List<FlowSteps> getStepslist() {
        return stepslist;
    }

    public void setStepslist(List<FlowSteps> stepslist) {
        this.stepslist = stepslist;
    }
}
