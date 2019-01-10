package org.sang.controller.process;


import org.sang.bean.Car;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.ProcessUnit;
import org.sang.bean.requestEntity.UnitRequest;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.mapper.ProcessUnitMapper;
import org.sang.service.ProcessUnitService;
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
@RequestMapping(value = "/unit")
public class ProcessUnitController extends BaseController{

    @Autowired
    ProcessUnitService processUnitService;

    public BaseResponseEntity checkName(String name){
        Map<String, Object> map = new HashMap<>();
        ProcessUnit processUnit = processUnitService.getByName(name);
        map.put("unit", processUnit);
        return succResult(map);
    }

    /**
     * 添加加工单位
     * @param processUnit
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponseEntity addUnit(UnitRequest processUnit){
        if(null == processUnit ){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        ProcessUnit processUnit1 = processUnitService.getByName(processUnit.getClientCompanyName());
        if(null != processUnit1){
            return badResult(ErrCodeMsg.DAN_WEI_NAME);
        }
        Boolean result = processUnitService.addUnit(processUnit);
        if(result){
            return succResult();
        }else{
            return  badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 编辑加工单位
     * @param processUnit
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResponseEntity updateUnit(UnitRequest processUnit){
        if(null == processUnit ){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean result = processUnitService.updateUnit(processUnit);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 获取加工单位列表
     * @param page
     * @param size
     * @return
     */

    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getUnitListByMain(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        PageBean<ProcessUnit> list = processUnitService.getUnitList(pageInfoEntity);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){

            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("unitlist", list.getItems());
        return succResult(map);
    }


    /**
     * 根据条件搜索
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/engine/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getUnitListByEnginge(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size
    , Long engineId, Long carId, String name) {
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<ProcessUnit> unitList = new ArrayList<>();
        PageBean<ProcessUnit> list = processUnitService.getUnitListByCon(pageInfoEntity, name, engineId,carId);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){

            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("unitlist", list);
        return succResult(map);
    }

    @RequestMapping(value = "/list/bycarid", method = RequestMethod.GET)
    public BaseResponseEntity getUnitListByCarId(Long carId){
        if(null == carId){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        List<ProcessUnit> list = processUnitService.getListByCarId(carId);
        if(null !=list){
            Map<String, Object> map = new HashMap<>();
            map.put("unitlist", list);
            return succResult(map);
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }



    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public BaseResponseEntity getUnitListByMain() {
        Map<String, Object> map = new HashMap<>();
        List<ProcessUnit> list = processUnitService.getAllUnitList();
        if(null != list ){
            map.put("unitlist", list);
        }
        return succResult(map);
    }
}
