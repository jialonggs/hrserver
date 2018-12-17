package org.sang.controller.aftersale;

import org.sang.bean.*;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.OrderAffterOffice;
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

    @RequestMapping("/office/list")
    public BaseResponseEntity getWaitOrderList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                               @RequestParam(value = "userId") Integer userId){
        if (null == userId) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<OrderAffterOffice> orderList = new ArrayList<>();
        PageBean<OrderAffterOffice> list = afterSaleService.getOrderAffterOffice(pageInfoEntity, userId);
        if (null != list && list.getItems() != null && list.getItems().size() != 0) {
            orderList = list.getItems();
            map.put("count", list.getPageInfo().getTotal());
        }
        map.put("afterofficeList", orderList);
        return succResult(map);
    }

//    @RequestMapping("/office/toSale")
//    public BaseResponseEntity toSale(@RequestParam(value = "orderId") Integer orderId,
//                                     @RequestParam(value = "afterStatus") Integer afterStatus){
//        if (null == orderId || null==  afterStatus) {
//            return badResult(ErrCodeMsg.ARGS_MISSING);
//        }
//        Boolean result = afterSaleService.toSale(afterStatus, orderId);
//        if(result){
//            return succResult();
//        }else{
//            return badResult(ErrCodeMsg.COMMON_FAIL);
//        }
//    }

    @RequestMapping("/office/addXZ")
    public BaseResponseEntity toAddXZ(@RequestBody ShXzOrder shXzOrder){
        Boolean addResult = afterSaleService.addShXz(shXzOrder);
        if(addResult){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }
    @RequestMapping("/office/addSh")
    public BaseResponseEntity addSh(@RequestBody SHBaoGao shBaoGao){
        Boolean addResult = afterSaleService.addSh(shBaoGao);
        if(addResult){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    @RequestMapping("/wait/updateXZ")
    public BaseResponseEntity toUpdateXZ(@RequestBody ShXzOrder shXzOrder){
        Boolean addResult = afterSaleService.updateShXz(shXzOrder);
        if(addResult){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }






    @RequestMapping("/wait/list")
    public BaseResponseEntity getWaitOrderList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                               @RequestParam(value = "userId") Integer userId,
                                               @RequestParam(value = "status") Integer status){
        if (null == userId) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<OrderShouhou> orderList = new ArrayList<>();
        PageBean<OrderShouhou> list = afterSaleService.getAfterOrders(pageInfoEntity, userId, status);
        if (null != list && list.getItems() != null && list.getItems().size() != 0) {
            orderList = list.getItems();
            map.put("count", list.getPageInfo().getTotal());
        }
        map.put("afterlist", orderList);
        return succResult(map);
    }

   @RequestMapping("/wait/add")
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


    @RequestMapping("/job/list")
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

//    @RequestMapping("/job/add/bg")
//    public BaseResponseEntity addShouHou(@RequestBody SHBaoGao shBaoGao){
//        if (null == shBaoGao || null ==shBaoGao.getOrderId()) {
//            return badResult(ErrCodeMsg.ARGS_MISSING);
//        }
//        Boolean result = afterSaleService.addBaoGao(shBaoGao);
//        if(result){
//            return succResult();
//        }else{
//            return badResult(ErrCodeMsg.COMMON_FAIL);
//        }
//    }


}
