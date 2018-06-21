package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.FaMo;
import org.sang.bean.responseEntity.FaMoResponse;

import java.util.List;
public interface FaMoMapper {

    int addFaMo(FaMo faMo);

    List<FaMo> getAllFaMo(@Param("status") Integer status);

    List<FaMo> getWaitFaMo(@Param("addUserId") Integer addUserId);

    FaMo getById(@Param("id") Long id);

    FaMoResponse getFaMo(@Param("id") Long id);

    int aduitFaMo(@Param("id")Long id,@Param("status")String status, @Param("auditId")Integer auditId, @Param("auditName")String auditName,
                  @Param("auditJingId")Integer auditJingId, @Param("auditJingName")String auditJingName);


    int updateFaMo(@Param("faMo") FaMo faMo);

    int updateFaMoStatus(@Param("id") Integer Id, @Param("status") Integer status, @Param("infoId") Long infoId);
}
