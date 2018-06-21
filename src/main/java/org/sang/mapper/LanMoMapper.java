package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.LanMo;

import java.util.List;

public interface LanMoMapper {

    Long addLanMo(LanMo lanMo);

    List<LanMo> getByTechId(@Param("techId") Long techId);

    int updateLanMo(LanMo lanMo);

    int delLanMo(@Param("id") Long id);
}
