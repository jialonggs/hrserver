package org.sang.controller.aftersale;

import io.swagger.annotations.Api;
import org.sang.bean.*;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.OrderAffterOffice;
import org.sang.bean.responseEntity.OrderShouhou;
import org.sang.bean.responseEntity.QualityOrderResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.AfterSaleService;
import org.sang.service.HrService;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "欢迎", tags = {"用户操作接口说明"})
@RestController
@RequestMapping("/after/sale")
public class AfterSaleController extends BaseController{

    @Autowired
    private AfterSaleService afterSaleService;

    @Autowired
    private HrService hrService;

    @PostMapping("/add")
    public boolean addUser(@RequestBody  Hr hr) {
        return false;
    }


    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return true;
    }

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

    @RequestMapping("/job/wanjie")
    public BaseResponseEntity toUpdateXZ(Integer id, String urls, String remark){
        Boolean wanJieResult = afterSaleService.updateWanJie(id, urls, remark);
        if(wanJieResult){
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


    @RequestMapping("/job/info")
    public BaseResponseEntity getShouHouList(@RequestParam(value = "id") Integer id,
                                             @RequestParam(value = "userId", required = false) Integer userId){


        OrderShouhou orderShouhou = afterSaleService.getAfterOrderShouHouById(id);
        return succResult(orderShouhou);
    }




    @RequestMapping("/checked/xz")
    public BaseResponseEntity checkXz(@RequestParam("orderId") Integer orderId, @RequestParam("status") Integer status){
        if (null == orderId ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean result = afterSaleService.checkStatus(orderId, status);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

    }

    @RequestMapping("/course/checked")
    public BaseResponseEntity courseChecked(@RequestParam("orderId") Integer orderId, @RequestParam("uid") Long uid){
        if (null == orderId ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Hr hr = hrService.getHrById(uid);
        if(null == hr){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        List<Role> roles = hr.getRoles();
        Long cheJianId = null;
        Long xingZhengId = null;
        if(null != roles && !roles.isEmpty()){
            for (Role role : roles){
                if (role.getName().equals("ROLE_chejian")){
                    cheJianId = uid;
                }
            }
        }
        if(null == cheJianId && null == xingZhengId){
             return badResult(ErrCodeMsg.NO_PERMISSION);
        }
        // 校验是否含有
        Boolean result = afterSaleService.courseChecked(orderId, cheJianId, xingZhengId);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

    }

}
