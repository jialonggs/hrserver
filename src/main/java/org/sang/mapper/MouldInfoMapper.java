package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.MouldInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface MouldInfoMapper {

    List<MouldInfo> getMouldInfoByShouMoId(@Param("id") Long id);

    List<MouldInfo> getMouldInfoByShouMoId1(@Param("id") Long id);

    int addMouldInfo( MouldInfo mouldInfo);

    int updateMouldInfo(MouldInfo mouldInfo);

    List<MouldInfo> getByOrderId(@Param("orderId") Long orderId);

    MouldInfo getMouldById(@Param("id") Long id);

    List<MouldInfo> getMouldByTime(@Param("begainTime")Date begainTime, @Param("endTime") Date endTime);

    List<MouldInfo> selectBy(@Param("mouldName")String mouldName, @Param("addUserName") String addUserName);

//    int updateMouldInfoBySelected(Map<String,Object> map);
   int updateMouldInfoBySelected(@Param("id") Long id, @Param("selectId") Long uid,@Param("orderId") Long orderId );

   int updateMould(@Param("id") Long id);

   List<MouldInfo> getUnSelect(@Param("begainTime") String begainTime);

    int addMoulds(@Param("moulds") List<MouldInfo> moulds);

    int updateCaiStatus(@Param("mouldIds") List<MouldInfo> mouldIds);

}
