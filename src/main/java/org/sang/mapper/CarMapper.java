package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.Car;

import java.util.List;

public interface CarMapper {

    Car getCarByName(@Param("carName") String carName);

    int addCar(Car car);

    List<Car> getCarListByMain(@Param("mainId") Long mainId);

    List<Car> getCarList();

    Car getCarById(@Param("carId") Long carId);

    List<Car> getByUnitId(@Param("unitId") Long unitId);

    int updateCar( Car car);

}
