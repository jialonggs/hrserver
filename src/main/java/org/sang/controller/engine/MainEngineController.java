package org.sang.controller.engine;

import org.sang.bean.Car;
import org.sang.bean.MainEngine;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.MainEngineService;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value ="/engine")
public class MainEngineController extends BaseController{

    @Autowired
    MainEngineService mainEngineService;


    /**
     * 根据名称获取主机厂
     * @param name
     * @return
     */
    @RequestMapping(value = "/checkEngineName", method = RequestMethod.POST)
    public BaseResponseEntity checkEngineName(String name){
        if(null == name){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        MainEngine mainEngine = mainEngineService.getByName(name);
        map.put("engine", mainEngine);
        return succResult(map);
    }

    /**
     * 添加主机厂
     * @param name
     * @param addUserId
     * @param addUserName
     * @return
     */
    @RequestMapping(value = "/addEngine", method = RequestMethod.POST)
    public BaseResponseEntity addEngine(String name, String addUserId, String addUserName ,String remark){
        if(null == name || null == addUserId   || null == addUserName){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        MainEngine check = mainEngineService.getByName(name);
        if(null != check){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
        Boolean result = mainEngineService.addMainEngine(name, addUserName, addUserId, remark);
        if(result){
            return succResult();
        }else{
            return  badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    /**
     * 获取主机厂列表
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
        List<MainEngine> engineList = new ArrayList<>();
        PageBean<MainEngine> list = mainEngineService.getEngineList(pageInfoEntity);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){

            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("enginelist", list.getItems());
        return succResult(map);
    }

    /**
     * 编辑车型
     * @param name
     * @param updateUserId
     * @return
     */
    @RequestMapping(value = "/updateEngine", method = RequestMethod.POST)
    public BaseResponseEntity updateCarType(String name, String updateUserId, Long id,String remark){
        if(null == name || updateUserId == null || id == null){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean result = mainEngineService.updateEngine(name, updateUserId, id, remark);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 获取主机厂列表
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public BaseResponseEntity getAll() {
        Map<String, Object> map = new HashMap<>();
        List<MainEngine> list = mainEngineService.getAll();
        map.put("allenginelist", list);
        return succResult(map);
    }



}
