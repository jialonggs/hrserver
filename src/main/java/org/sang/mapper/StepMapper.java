package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.Step;

import java.util.List;

public interface StepMapper {

    int addStep(Step step);

    List<Step> getStepsList();

    int delStep(@Param("id") Long id);
}
