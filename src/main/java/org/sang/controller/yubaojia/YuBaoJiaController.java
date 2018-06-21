package org.sang.controller.yubaojia;

import com.alibaba.fastjson.JSONObject;
import org.sang.bean.*;
import org.sang.bean.requestEntity.AddYuBaoJiaRequest;
import org.sang.bean.requestEntity.YuProductRquest;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.YuBaoJiaService;
import org.sang.service.YuProductService;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/offer/per")
public class YuBaoJiaController extends BaseController{

    @Autowired
    YuBaoJiaService yuBaoJiaService;

    @Autowired
    YuProductService yuProductService;



    /**
     * 查询预报价
     * @return
     */
    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getYuBaoJiaList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                            @RequestParam(value = "addUserId") Integer addUserId) {
        if(null == addUserId ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<YuBaoJia> yubaojialist = new ArrayList<>();
        PageBean<YuBaoJia> list = yuBaoJiaService.getYubaoJiaList(pageInfoEntity, addUserId);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            yubaojialist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("yubaojialist", yubaojialist);
        return succResult(map);
    }

    /**
     *添加预报价基本信息
     * @param yuBaoJia
     * @return
     */
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public BaseResponseEntity addYuBaoJia(YuBaoJia yuBaoJia) {
//        if(null == yuBaoJia  ) {
//            return badResult(ErrCodeMsg.ARGS_MISSING);
//        }
//        Long projectId = yuBaoJia.getProjectId();
//        YuBaoJia yuBaoJia1 = yuBaoJiaService.getByProjectId(projectId);
//        if(null != yuBaoJia1){
//            return badResult(ErrCodeMsg.COMMON_FAIL);
//        }
//        Map<String, Object> map = new HashMap<>();
//        Long i = yuBaoJiaService.addYuBaoJia(yuBaoJia);
//        if (i >= 1) {
//            map.put("id",i);
//            return  succResult(map);
//        } else {
//            map.put("id",-1);
//            return succResult(map);
//        }
//    }


    /**
     * 添加预报价单产品信息
     * @param
     * @return
     */
    @RequestMapping(value = "/add/product", method = RequestMethod.POST)
    public BaseResponseEntity addProduct(YuProductRquest yuProducts) {
        if(null == yuProducts ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Integer yuBaoJiaId = yuProducts.getYuBaoJiaId();
        String products = yuProducts.getYuProducts();
        if(null == products ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        List<YuProduct> list = new ArrayList<>();
        String[] strings = products.split("\\|");

        for (String item : strings) {
            YuProduct product = JSONObject.parseObject(item, YuProduct.class);
            list.add(product);
        }

        int i = yuProductService.addYuProduct(list);
        if(i > 0){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponseEntity addYuBaoJia(@RequestBody AddYuBaoJiaRequest addYuBaoJiaRequest) {
        if(null == addYuBaoJiaRequest  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        if(addYuBaoJiaRequest.getYuBaoJia().getSubmitType() == 0){
            if(null == addYuBaoJiaRequest.getYuProductList() || addYuBaoJiaRequest.getYuProductList().size() <=0){
                return badResult(ErrCodeMsg.ARGS_MISSING);
            }
        }
        Boolean reslut = yuBaoJiaService.addYuBaoJia2(addYuBaoJiaRequest);
        if(reslut){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    /**
     * 添加预报价产品信息
     * @param
     * @return
     */
    @RequestMapping(value = "/add/new/product", method = RequestMethod.POST)
    public BaseResponseEntity addProjectProduct(YuProduct product){
        if(null == product || null == product.getYuBaoJiaId()) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        List<YuProduct> list = new ArrayList<>();
        list.add(product);
        int i = yuProductService.addNewYuProduct(list);
        if(i > 0){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 更新预报价产品信息
     * @param
     * @return
     */
    @RequestMapping(value = "/update/product", method = RequestMethod.POST)
    public BaseResponseEntity updateProjectProduct(YuProduct product){
        if(null == product || null == product.getYuBaoJiaId() || null == product.getId()) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean i = yuProductService.updateYuProduct(product);
        if(i){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

    }


    @RequestMapping(value = "/list/project", method = RequestMethod.GET)
    public BaseResponseEntity getProjectList(@RequestParam("addUserId") Long addUserId){
        if(null == addUserId){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        List<Project> list = yuBaoJiaService.getProjectListByAddUserId(addUserId);
        if(null == list || list.isEmpty()){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
        map.put("projectlist", list);
        return succResult(map);

    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public BaseResponseEntity delProduct(YuProduct yuProduct){
        if(null == yuProduct){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean i = yuProductService.delProduct(yuProduct);
        if(i){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

    }


    @RequestMapping(value = "/again/audit", method = RequestMethod.POST)
    public BaseResponseEntity againAudit(YuBaoJia yuBaoJia){
        if(null == yuBaoJia){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        int i = yuBaoJiaService.aginAudit(yuBaoJia);
        if(i > 0){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

    }


}
