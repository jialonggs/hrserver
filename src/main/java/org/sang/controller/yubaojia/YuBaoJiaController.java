package org.sang.controller.yubaojia;

import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.YuBaoJia;
import org.sang.bean.YuProduct;
import org.sang.bean.requestEntity.YuProductRquest;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.YuBaoJiaService;
import org.sang.service.YuProductService;
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
@RequestMapping(value = "/offer/per")
public class YuBaoJiaController extends BaseController{

    @Autowired
    YuBaoJiaService yuBaoJiaService;

    @Autowired
    YuProductService yuProductService;



    /**
     * 查询项目列表
     * @return
     */
    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
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
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponseEntity addYuBaoJia(YuBaoJia yuBaoJia) {
        if(null == yuBaoJia  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        Long i = yuBaoJiaService.addYuBaoJia(yuBaoJia);
        if (i >= 1) {
            map.put("id",1);
            return  succResult(map);
        } else {
            map.put("id",-1);
            return succResult(map);
        }
    }


    /**
     * 添加预报价单产品信息
     * @param yuProducts
     * @return
     */
    @RequestMapping(value = "/add/product", method = RequestMethod.POST)
    public BaseResponseEntity addProduct(YuProductRquest yuProducts) {
        if(null == yuProducts  || yuProducts.getYuProducts() == null ||yuProducts.getYuProducts().size() ==0 ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        List<YuProduct> products = yuProducts.getYuProducts();
        Map<String, Object> map = new HashMap<>();
        int i = yuProductService.addYuProduct(products);
        System.out.print(i+"这就是");
        if (i >= 0) {
            return  succResult();
        } else {
            map.put("id",-1);
            return badResult(map);
        }
    }


}
