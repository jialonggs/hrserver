package org.sang.controller.famo;

import org.sang.bean.*;
import org.sang.bean.responseEntity.FaMoOrder;
import org.sang.bean.responseEntity.FaMoResponse;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.FaMoService;
import org.sang.service.MouldInfoService;
import org.sang.service.SendMessageService;
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
@RequestMapping(value = "/fa/mo")
public class FaMoController extends BaseController{

    @Autowired
    FaMoService faMoService;

    @Autowired
    SendMessageService sendMessageService;

    @Autowired
    MouldInfoService mouldInfoService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponseEntity addFaMo(FaMo faMo){
        if (null == faMo){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
        Boolean result = faMoService.addFaMo(faMo);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResponseEntity updateFaMo(FaMo faMo){
        if(null == faMo){
            return  badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean result = faMoService.updateFaMo(faMo);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 可申请发模列表
     * @return
     */
    @RequestMapping(value = "/need/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getNeedFaMo(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                          @RequestParam("addUserId") Integer addUserId,
                                          @RequestParam("storageStatus") Integer storageStatus,
                                          @RequestParam("faMoStatus") Integer faMoStatus) {
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<FaMoOrder> needfamolist = new ArrayList<>();
        PageBean<FaMoOrder> list = faMoService.getZhunBei(pageInfoEntity, addUserId, storageStatus, faMoStatus);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            needfamolist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("needfamolist", needfamolist);
        return succResult(map);
    }


    /**
     * 待审核
     * @return
     */
    @RequestMapping(value = "/wait/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getNeedFaMo(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                          @RequestParam("addUserId") Integer addUserId) {
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<FaMo> needfamolist = new ArrayList<>();
        PageBean<FaMo> list = faMoService.getWait(pageInfoEntity, addUserId);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            needfamolist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("waitfamolist", needfamolist);
        return succResult(map);
    }

    /**
     * 根据状态查询待发模列表
     * @param page
     * @param size
     * @param status
     * @return
     */
    @RequestMapping(value = "/by/status", method = RequestMethod.GET)
    public BaseResponseEntity getFaMoByStatus(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                           @RequestParam("status") Integer status) {
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<FaMo> needfamolist = new ArrayList<>();
        PageBean<FaMo> list = faMoService.getByStatus(pageInfoEntity, status);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            needfamolist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("needfamolist", needfamolist);
        return succResult(map);
    }

    /**
     * 发模申请列表
     * @return
     */
    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getYuBaoJiaList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                              @RequestParam(value = "status") Integer status) {
        if(null == status ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<FaMo> famolist = new ArrayList<>();
        PageBean<FaMo> list = faMoService.getAllFaMo(pageInfoEntity, status);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            famolist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("famolist", famolist);
        return succResult(map);
    }


    /**
     * 获取详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public BaseResponseEntity getInfoById(@RequestParam("id") Long id){
        if(null == id ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        FaMoResponse faMo = faMoService.getById(id);
        map.put("faMo", faMo);
        return succResult(map);

    }

    /**
     * 审核操作
     * @param id
     * @param status
     * @return
     */
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public  BaseResponseEntity checkShangwu(@RequestParam("id") Long id,@RequestParam("status") Integer status,
                                            @RequestParam("auditId") Integer auditId,
                                            @RequestParam("auditName") String auditName,
                                            @RequestParam("addUserId") Long addUserId){
        if(null == id  || null == status) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        int i = faMoService.auditFaMo(id, status, auditId, auditName);
        if(i>0){
            String msg = "";
            if(status == 1){
                msg = "您提交的发模申请 ，审核通过";
            }else {
                msg = "您提交的发模申请 ，被驳回";
            }
            String title = "发模申请";
            List<Long> ids = new ArrayList<>();
            ids.add(addUserId);
            sendMessageService.toSendByIds(msg,title, ids);
            // 发送信息
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 添加详情
     * @param faMoInfo
     * @return
     */
    @RequestMapping(value = "/add/info", method = RequestMethod.POST)
    public BaseResponseEntity addFaMoInfo(FaMoInfo faMoInfo){
        if(null == faMoInfo){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean result = faMoService.addFaMoInfo(faMoInfo);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 添加详情
     * @param cheJian
     * @return
     */
    @RequestMapping(value = "/que/ren", method = RequestMethod.POST)
    public BaseResponseEntity addFaMoInfo(@RequestParam(value = "cheJian") Integer cheJian,
                                          @RequestParam(value = "id") Integer id){
        if(null == cheJian){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean result = faMoService.queRen(id, cheJian);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

    }

    @RequestMapping(value = "/order/famo", method = RequestMethod.GET)
    public BaseResponseEntity getMouldInfoList(@RequestParam(value = "orderId") Long orderId){
        List<MouldInfo> list = mouldInfoService.getMouldOrderId(orderId);
        return succResult(list);
    }
}
