package org.sang.controller.wuliao;

import org.sang.bean.Hr;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.WuLiao;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.HrService;
import org.sang.service.WuLiaoService;
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
@RequestMapping(value = "/stock/manager")
public class StockController extends BaseController{

    @Autowired
    WuLiaoService wuLiaoService;

    @Autowired
    HrService hrService;

    /**
     * 查询项目列表
     * @return
     */
    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                            @RequestParam(value = "status") Integer status) {
        if(null == status ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<WuLiao> wuLiaoList = new ArrayList<>();
        PageBean<WuLiao> list = wuLiaoService.getWuLiaoListByStatus(pageInfoEntity, status);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            wuLiaoList = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("wuliaolist", wuLiaoList);
        return succResult(map);
    }


    /**
     * 查询项目列表
     * @return
     */
    @RequestMapping(value = "/finish", method = RequestMethod.POST)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "wuLiaoId") Long wuLiaoId,
                                            @RequestParam(value = "status") Integer status,
                                            @RequestParam("principalUserId") Long principalUserId,
                                            @RequestParam("principalUserName") String principalUserName) {
        if(null == status || null == wuLiaoId ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        int i = wuLiaoService.updateStatus(wuLiaoId, status,principalUserId,principalUserName);
        if(i>0){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    /**
     * 查询项目列表
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "wuLiaoId") Long wuLiaoId,
                                            @RequestParam(value = "status") Integer status, @RequestParam(value = "getUserId") Long getUserId) {
        if(null == status || null == wuLiaoId || getUserId == null) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        WuLiao wuLiao = wuLiaoService.getWuLiaoById(wuLiaoId);
        if(null == wuLiao){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
        if(!wuLiao.getAddUserId().equals(getUserId+"")){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
        int i = wuLiaoService.updateStatus(wuLiaoId, status, null, null);
        if(i>0){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    /**
     * 验证用户
     * @param userId
     * @param privateStr
     * @return
     */
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public BaseResponseEntity checkUserInfo(@RequestParam("userId") Long userId, @RequestParam("privateStr") String privateStr){

        if(null == userId || null == privateStr) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }

        Hr result = hrService.getHrById(userId);

        if(null == result){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        System.out.print(result.toString());
        if(result.getPrivateStr().equals(privateStr)){
            return succResult();
        }
        return badResult(ErrCodeMsg.COMMON_FAIL);

    }


}
