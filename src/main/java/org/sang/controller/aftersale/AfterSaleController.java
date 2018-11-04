package org.sang.controller.aftersale;

import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.SHBaoGao;
import org.sang.bean.ShouHou;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.OrderShouhou;
import org.sang.bean.responseEntity.QualityOrderResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.AfterSaleService;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/after/sale")
public class AfterSaleController extends BaseController{

    @Autowired
    private AfterSaleService afterSaleService;

    @RequestMapping("/wait")
    public BaseResponseEntity getWaitOrderList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                               @RequestParam(value = "userId") Integer userId,
                                               @RequestParam(value = "afterStatus") Integer afterStatus){
        if (null == userId) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<Order> orderList = new ArrayList<>();
        PageBean<Order> list = afterSaleService.getAfterOrders(pageInfoEntity, userId, afterStatus);
        if (null != list && list.getItems() != null && list.getItems().size() != 0) {
            orderList = list.getItems();
            map.put("count", list.getPageInfo().getTotal());
        }
        map.put("afterlist", orderList);
        return succResult(map);
    }

   @RequestMapping("/add")
    public BaseResponseEntity addShouHou(@RequestBody  ShouHou shouHou){

        if (null == shouHou || null ==shouHou.getOrderId()) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }

        Boolean result = afterSaleService.addShouHou(shouHou);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

    }


    @RequestMapping("/job")
    public BaseResponseEntity getShouHouList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                               @RequestParam(value = "userId") Integer userId,
                                               @RequestParam(value = "status", required = false) Integer status){
        if (null == userId) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<OrderShouhou> orderList = new ArrayList<>();
        PageBean<OrderShouhou> list = afterSaleService.getAfterOrderShouHou(pageInfoEntity, userId, status);
        if (null != list && list.getItems() != null && list.getItems().size() != 0) {
            orderList = list.getItems();
            map.put("count", list.getPageInfo().getTotal());
        }
        map.put("shouhoulist", orderList);
        return succResult(map);
    }

    @RequestMapping("/add/bg")
    public BaseResponseEntity addShouHou(@RequestBody SHBaoGao shBaoGao){
        if (null == shBaoGao || null ==shBaoGao.getOrderId()) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean result = afterSaleService.addBaoGao(shBaoGao);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


}
