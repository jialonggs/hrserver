package org.sang.controller.busbao;

import com.alibaba.fastjson.JSONObject;
import org.sang.bean.BusinessBaoJia;
import org.sang.bean.BusinessProduct;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.Project;
import org.sang.bean.requestEntity.AddBusBaoJiaRequest;
import org.sang.bean.requestEntity.AddYuBaoJiaRequest;
import org.sang.bean.requestEntity.BusinessProductRquest;
import org.sang.bean.requestEntity.YuProductRquest;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.BusInfoResp;
import org.sang.bean.responseEntity.ProjectListResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.BusBaoJiaService;
import org.sang.service.BusinessBaoJiaService;
import org.sang.service.BusinessProductService;
import org.sang.service.ProjectService;
import org.sang.utils.DoubleUtil;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/offer/bus")
public class BusinessBaoJiaController extends BaseController{

    @Autowired
    BusinessBaoJiaService businessBaoJiaService;

    @Autowired
    BusinessProductService businessProductService;

    @Autowired
    ProjectService projectService;



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
        List<BusInfoResp> busbaojialist = new ArrayList<>();
        PageBean<BusInfoResp> list = businessBaoJiaService.getBusinessbaoJiaList(pageInfoEntity, addUserId);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            busbaojialist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("busbaojialist", busbaojialist);
        return succResult(map);
    }

    /**
     *添加预报价基本信息
     * @param
     * @return
     */
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public BaseResponseEntity addBusinessBaoJia(BusinessBaoJia businessBaoJia) {
//        if(null == businessBaoJia  ) {
//            return badResult(ErrCodeMsg.ARGS_MISSING);
//        }
//        Map<String, Object> map = new HashMap<>();
//        Long i = businessBaoJiaService.addBusinessBaoJia(businessBaoJia);
//        if (i >= 1) {
//            map.put("id",i);
//            return  succResult(map);
//        } else {
//            map.put("id",-1);
//            return succResult(map);
//        }
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponseEntity addYuBaoJia(@RequestBody AddBusBaoJiaRequest addBusBaoJiaRequest) {
        if(null == addBusBaoJiaRequest  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Long projectId = addBusBaoJiaRequest.getBusinessBaoJia().getProjectId();
        BusinessBaoJia businessBaoJia = businessBaoJiaService.getProjectBuInfo(projectId);
        if(null != businessBaoJia){
            return badResult(ErrCodeMsg.YU_BAO_JIA_IS_HAVE);
        }
        if(addBusBaoJiaRequest.getBusinessBaoJia().getSubmitType() == 0){
            if(null == addBusBaoJiaRequest.getBusinessProductList() || addBusBaoJiaRequest.getBusinessProductList().size() <=0){
                return badResult(ErrCodeMsg.ARGS_MISSING);
            }
        }
        Boolean reslut = businessBaoJiaService.addBusinessBaoJia2(addBusBaoJiaRequest);
        if(reslut){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    /**
     * 添加预报价单产品信息
     * @param
     * @return
     */
    @RequestMapping(value = "/add/product", method = RequestMethod.POST)
    public BaseResponseEntity addProduct(BusinessProductRquest businessProduct) {
        if(null == businessProduct ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Integer yuBaoJiaId = businessProduct.getBusinessBaoJiaId();
        String products = businessProduct.getBusinessProducts();
        if(null == products ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        List<BusinessProduct> list = new ArrayList<>();
        String[] strings = products.split("\\|");

        for (String item : strings) {
            BusinessProduct product = JSONObject.parseObject(item, BusinessProduct.class);
//            Double price = DoubleUtil.m2(product.getTotal() / (product.getProductNum() * product.getArea()));
//            product.setPrice(price);
            list.add(product);
        }

        int i = businessProductService.addBusinessProduct(list);
        if(i > 0){
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
        List<ProjectListResp>list = businessBaoJiaService.getProjectListByAddUserId(addUserId);
        if(null == list || list.isEmpty()){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
        map.put("projectlist", list);
        return succResult(map);
    }


    @RequestMapping(value = "/again/audit", method = RequestMethod.POST)
    public BaseResponseEntity againAudit(BusinessBaoJia businessBaoJia){
        if(null == businessBaoJia){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        int i = businessBaoJiaService.aginAudit(businessBaoJia);
        if(i > 0){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

    }


    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public BaseResponseEntity delProduct(BusinessProduct businessProduct){
        if(null == businessProduct){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean i = businessProductService.delProduct(businessProduct);
        if(i){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

    }


    /**
     * 更新预报价产品信息
     * @param
     * @return
     */
    @RequestMapping(value = "/update/product", method = RequestMethod.POST)
    public BaseResponseEntity updateProjectProduct(BusinessProduct businessProduct){
        if(null == businessProduct || null == businessProduct.getYuBaoJiaId() || null == businessProduct.getId()) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean i = businessProductService.updateYuProduct(businessProduct);
        if(i){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

    }


    /**
     * 添加预报价产品信息
     * @param
     * @return
     */
    @RequestMapping(value = "/add/new/product", method = RequestMethod.POST)
    public BaseResponseEntity addProjectProduct(BusinessProduct businessProduct){
        if(null == businessProduct || null == businessProduct.getYuBaoJiaId()) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        List<BusinessProduct> list = new ArrayList<>();
        list.add(businessProduct);
        int i = businessProductService.addNewYuProduct(list);
        if(i > 0){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 修改最终优惠报价
     * @param id
     * @param tax
     * @param finalBaoJia
     * @return
     */
    @RequestMapping(value = "/update/final/baojia", method = RequestMethod.POST)
    public BaseResponseEntity updateFinal(@RequestParam("id") Long id, @RequestParam("tax") Double tax,
                                          @RequestParam("finalBaoJia") Double finalBaoJia){
        if(id == null || tax == null || finalBaoJia == null){
            badResult(ErrCodeMsg.ARGS_MISSING);
        }

        Boolean result = businessBaoJiaService.updateFinalBaoJia(id, tax, finalBaoJia);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
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
        BusInfoResp busInfoResp = businessBaoJiaService.getById(id);
        map.put("businfo", busInfoResp);
        return succResult(map);

    }







}
