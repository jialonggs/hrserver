package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.ShouMoList;
import org.sang.bean.responseEntity.ShouMoListResp;

import java.util.Date;
import java.util.List;

public interface ShouMoListMapper {

    List<ShouMoList> getAllShouMoList();

    List<ShouMoListResp> getShouMoList();

    List<ShouMoList> getShouMoByTime(@Param("begainTime") String begainTime, @Param("endTime") String endTime);

    List<ShouMoListResp> getShouMoByTime2(@Param("begainTime") String begainTime, @Param("endTime") String endTime);

    List<ShouMoListResp> getCaiMoMoulds(@Param("begainTime") String begainTime, @Param("endTime") String endTime);

    int createShouMo(ShouMoList shouMoList);

    int updateShouMo(@Param("shouMo") ShouMoList shouMoList);

    ShouMoList getById(@Param("id") Integer id);


}
