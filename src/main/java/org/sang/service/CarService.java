package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.Car;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.responseEntity.ProjectListResp;
import org.sang.mapper.CarMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarMapper carMapper;

    public Car getCarByName(String carName){
        return carMapper.getCarByName(carName);
    }


    public Boolean addCar(String carName, String addUserId, Long mainEngineId, String addUserName,String remark){
        Car car = new Car();
        car.setName(carName);
        car.setAddUserId(addUserId);
        car.setMainEngineId(mainEngineId);
        car.setAddUserName(addUserName);
        car.setRemark(remark);
        int i = carMapper.addCar(car);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }



    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<Car> getCarListByMainId(PageInfoEntity pageInfoEntity, Long mainId) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<Car> list = carMapper.getCarListByMain(mainId);
        PageInfo page = new PageInfo(list);
        PageBean<Car> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<Car> getCarList(PageInfoEntity pageInfoEntity) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<Car> list = carMapper.getCarList();
        PageInfo page = new PageInfo(list);
        PageBean<Car> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    /**
     * 修改
     * @param carName
     * @param updateUserId
     * @param mainEngineId
     * @return
     */
    public Boolean updateCarType(String carName, String updateUserId, Long mainEngineId, Long carId, String remark){
        Car car = carMapper.getCarById(carId);
        if(null == car){
            return false;
        }
        car.setName(carName);
        car.setMainEngineId(mainEngineId);
        car.setRemark(remark);
        int i = carMapper.updateCar(car);
        if(i > 0){
            return  true;
        }else{
            return  false;
        }
    }

    public List<Car> getAll(){
        return carMapper.getCarList();
    }
}
