package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.ProcessUnit;

import java.util.List;

public interface ProcessUnitMapper {

    int addUnit(ProcessUnit processUnit);

    ProcessUnit getByName(@Param("name") String name);

    int updateUnit(ProcessUnit processUnit);

    List<ProcessUnit> getUnitList();

    int addCarForUnit(@Param("u_id") Long uid, @Param("c_ids") Long[] cids);

    int deleteCarByUnitId(Long unitId);

    List<ProcessUnit> getListByCarId(Long carId);


    ProcessUnit getById(@Param("unitId") Long unitId);

//    List<ProcessUnit> getAllUnitList();
}
