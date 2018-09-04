package org.sang.controller.car;

import org.sang.bean.Car;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.ProjectListResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.CarService;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/car")
public class CarController extends BaseController{

    @Autowired
    CarService carService;


    /**
     * 添加新的车型
     * @param carName
     * @param addUserId
     * @param mainEngineId
     * @return
     */
    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public BaseResponseEntity addCar(String name, String addUserId, Long mainEngineId, String addUserName, String remark){
        if(null == name || null == addUserId || null == mainEngineId || null == addUserName){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean result = carService.addCar(name, addUserId, mainEngineId, addUserName,remark);
        if(result){
            return succResult();
        }else{
            return  badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 根据名称获取车类型
     * @param carName
     * @return
     */
    @RequestMapping(value = "/checkCarName", method = RequestMethod.POST)
    public BaseResponseEntity checkCarName(String carName){
        if(null == carName){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Car car = carService.getCarByName(carName);
        return succResult(car);
    }


    /**
     * 根据主机厂ID获取车型列表
     * @param page
     * @param size
     * @param mainEngineId
     * @return
     */
    @RequestMapping(value = "/bymain/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getCarListByMain(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size
     ,@RequestParam("mainEngineId") Long mainEngineId) {
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<Car> carList = new ArrayList<>();
        PageBean<Car> list = carService.getCarListByMainId(pageInfoEntity, mainEngineId);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){

            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("carlist", carList);
        return succResult(map);
    }


    /**
     * 获取车型列表
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getCarListByMain(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<Car> carList = new ArrayList<>();
        PageBean<Car> list = carService.getCarList(pageInfoEntity);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){

            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("carlist", list.getItems());
        return succResult(map);
    }




    /**
     * 获取车型列表
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public BaseResponseEntity getCarALL() {
        Map<String, Object> map = new HashMap<>();
        List<Car> carList = carService.getAll();
        map.put("allcarlist", carList);
        return succResult(map);
    }


    /**
     * 编辑车型
     * @param updateUserId
     * @param mainEngineId
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResponseEntity updateCarType(String name, String updateUserId, Long mainEngineId, Long id, String remark){
        if(null == name || updateUserId == null || mainEngineId == null){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean result = carService.updateCarType(name, updateUserId, mainEngineId, id, remark);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

    }
}
