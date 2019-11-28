package org.sang.controller.shoufamo;

import org.sang.bean.CaiMoList;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.requestEntity.CaiMoListRequest;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.CaiMoListResp;
import org.sang.bean.responseEntity.MouldPartTreeResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.CaiMoService;
import org.sang.service.MouldInfoService;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/shou/cai")
public class CaiMoController extends BaseController{

    @Autowired
    CaiMoService caiMoService;

    @Autowired
    MouldInfoService mouldInfoService;

    @Value("${tree.days}")
    public  String days;


    /**
     * 获取拆模列表
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getCaiMoListByPage(@RequestParam (value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<CaiMoListResp> caiMoList = new ArrayList<>();
        PageBean<CaiMoListResp> list = caiMoService.getShouMoListByPage(pageInfoEntity);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            caiMoList = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("caiMoList", caiMoList);
        return succResult(map);
    }

    /**
     * 添加记录
     * @param caiMoList
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public BaseResponseEntity createCaiMo(CaiMoList caiMoList){
        int i = caiMoService.addCaiMo(caiMoList);
        if(i>0){
            return succResult(i);
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 添加记录
     * @param caiMoListRequest
     * @return
     */
    @RequestMapping(value = "/createNew", method = RequestMethod.PUT)
    public BaseResponseEntity createCaiMo(CaiMoListRequest caiMoListRequest){
        int i = caiMoService.addCaiMoNew(caiMoListRequest);
        if(i>0){
            return succResult(i);
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public BaseResponseEntity updateCaiMo(CaiMoList caiMoList){
        int i = caiMoService.updateCaiMoList(caiMoList);
        if(i == 1){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 获取模具树
     * @return
     */
    @RequestMapping(value = "/mould/tree", method = RequestMethod.GET)
    public BaseResponseEntity getMouldTree(){
        try {
            Map<String, Object> map = new HashMap<>();
            List<MouldPartTreeResp> list = mouldInfoService.getCaiMould(Integer.parseInt(days));
            if(null != list && list.size()>0){
                map.put("tree", list);
                return succResult(map);
            }else{
                return badResult(ErrCodeMsg.COMMON_FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  badResult(ErrCodeMsg.SYSTEM_ERROR);
        }
    }


}
