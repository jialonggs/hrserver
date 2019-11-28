package org.sang.controller.shoufamo;

import com.alibaba.fastjson.JSONObject;
import org.sang.bean.*;
import org.sang.bean.requestEntity.RequestBean;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.ShouMoListResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.MouldInfoService;
import org.sang.service.ShouMoService;
import org.sang.utils.DateFormatUtil;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/shou/mo")
public class ShouMoController extends BaseController{

    @Autowired
    ShouMoService shouMoService;

    @Autowired
    MouldInfoService mouldInfoService;

    @Value("${data.days}")
    public  String days;


    /**
     * 查找收发模列表
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponseEntity getShouMoList() {
        List<ShouMoListResp> list = shouMoService.getShouMoList();
        return succResult(list);
    }

    /**
     * 查找收发模列表(分页)
     * @return
     */
    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponseEntity getShouMoList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<ShouMoListResp> shoumoList = new ArrayList<>();
        PageBean<ShouMoListResp> list = shouMoService.getShouMoListByPage(pageInfoEntity);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            shoumoList = list.getItems();
            for (ShouMoListResp shouMoListResp : shoumoList) {
                int num = 0;
                List<MouldInfo> mouldInfoList = shouMoListResp.getMouldInfos();
                if (mouldInfoList != null && !mouldInfoList.isEmpty()) {
                    for (MouldInfo mouldInfo : mouldInfoList) {
                        num = num + mouldInfo.getMouldNum();
                    }
                }
                shouMoListResp.setMouldNum(num);
            }
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("shoumolist", shoumoList);
        return succResult(map);
    }

    /**
     * 获取批次
     * @param dateTime
     * @return String
     */
    @RequestMapping(value = "/max/batch", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponseEntity getMaxBatch(@RequestParam String dateTime) {
        Integer maxBatch = shouMoService.getMaxBatch(dateTime);
        return succResult(maxBatch);
    }


    /**
     * 添加收模基础信息
     * @param shouMoList
     * @return
     */
    @RequestMapping(value = "/add/baseinfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseEntity addShouMo(ShouMoList shouMoList) {
        Map<String, Object> map = new HashMap<>();
        Long i = shouMoService.addBaseInfo(shouMoList);
        if (i >= 1) {
            map.put("id",1);
            return  succResult(map);
        } else {
            map.put("id",-1);
            return succResult(map);
        }
    }

    /**
     * 更新信息
     * @param shouMoList
     * @return
     */
    @RequestMapping(value = "/update/baseinfo", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponseEntity updateShouMo(ShouMoList shouMoList) {
        if (shouMoService.updateShouMo(shouMoList) == 1) {
            return succResult();
        }
        return badResult(ErrCodeMsg.COMMON_FAIL);
    }

    /**
     * 根据id查找收模信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/byid", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponseEntity getShouMoById(@RequestParam Integer id) {
        ShouMoList shouMo = shouMoService.getById(id);
        if(null != shouMo){
            return succResult(shouMo);
        }
        return badResult(ErrCodeMsg.COMMON_FAIL);
    }

    /**
     * 根据收模id 获取模具列表
     * @param shouMoId
     * @return
     */
    @RequestMapping(value = "/list/mouldinfo", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponseEntity getMouldInfoList(@RequestParam("shouMoId") Long shouMoId) {
        List<MouldInfo> mouldInfo= mouldInfoService.getMouldInfoList(shouMoId);
        if(null != mouldInfo){
            return succResult(mouldInfo);
        }
        return badResult(ErrCodeMsg.COMMON_FAIL);
    }

    /**
     * 创建模具信息
     * @param mouldInfo
     * @return
     */
    @RequestMapping(value = "/create/mouldinfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseEntity createMouldInfo(MouldInfo mouldInfo) {
        int i = mouldInfoService.addMouldInfo(mouldInfo);
        if ( i >= 1) {
            return succResult();
        }
        return badResult(ErrCodeMsg.COMMON_FAIL);
    }

    /**
     * 修改模具
     * @param
     * @return
     */
    @RequestMapping(value = "/update/mouldinfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseEntity updteMouldInfo(MouldInfo mouldInfo) {
        int i = mouldInfoService.updateMouldInfo(mouldInfo);
        if ( i == 1) {
            return succResult();
        }
        return badResult(ErrCodeMsg.COMMON_FAIL);
    }


    /**
     * 删除模具
     * @param mouldId
     * @return
     */
    @RequestMapping(value = "/del/mould", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponseEntity deletedMould(@RequestParam("mouldId") Long mouldId) {
        if(null == mouldId || mouldId+"" ==""){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        MouldInfo mouldInfo = mouldInfoService.getMouldById(mouldId);
        if(null == mouldId){
            return  badResult(ErrCodeMsg.SELECT_NULL);
        }
        mouldInfo.setDeleted(true);
        int i = mouldInfoService.updateMouldInfo(mouldInfo);
        if ( i == 1) {
            return succResult();
        }
        return badResult(ErrCodeMsg.COMMON_FAIL);
    }

    /**
     * 默认获取15天内的模具列表
     * @return
     */
    @RequestMapping(value = "/get/byday", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponseEntity getDayOf7List() {
        try {
            Integer day = Integer.parseInt(days);
            List<MouldInfo> list = mouldInfoService.getMouldOfDay(day);
            if(null == list || list.size() ==0){
                return  badResult(ErrCodeMsg.COMMON_FAIL);
            }
            return succResult(list);
        }catch (Exception e) {
            e.printStackTrace();
            return badResult(ErrCodeMsg.SYSTEM_ERROR);
        }
    }

    /**
     * 默认获取15天内的模具列表
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponseEntity getByMouldNameOrAddName(@RequestParam("mouldName") String mouldName,@RequestParam("addUserName") String addUserName) {
        try {
            List<MouldInfo> list = mouldInfoService.selectBy(mouldName, addUserName);
            if(null == list || list.size() == 0){
                return  badResult(ErrCodeMsg.COMMON_FAIL);
            }
            return succResult(list);
        }catch (Exception e) {
            e.printStackTrace();
            return badResult(ErrCodeMsg.SYSTEM_ERROR);
        }
    }

}
