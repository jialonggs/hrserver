package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.bean.ControlOrderFrom;

@Mapper
public interface ControlOrderFromMapper {

    int addControlOrderFrom(ControlOrderFrom controlOrderFrom);
}
