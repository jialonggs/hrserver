package org.sang.controller.stroage;

import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.StorageBill;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.OrderService;
import org.sang.service.StorageService;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/storage")
public class StorageController extends BaseController{

    @Autowired
    OrderService orderService;

    @Autowired
    StorageService storageService;


    /**
     * 查询项目列表
     * @return
     */
    @RequestMapping(value = "/have/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                            @RequestParam("storageStatus") Integer storageStatus) {
        if(null == storageStatus ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<Order> orderslist = new ArrayList<>();
        PageBean<Order> list = orderService.getWaitStorageOrder1(pageInfoEntity, storageStatus);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            orderslist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("putorderlist", orderslist);
        return succResult(map);
    }
    /**
     * 查询项目列表
     * @return
     */
    @RequestMapping(value = "/put/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                             @RequestParam("liuChengStatus") Integer liuChengStatus,
                                             @RequestParam("jingFengStatus") Integer jingFengStatus,
                                             @RequestParam("storageStatus") Integer storageStatus) {
        if(null == liuChengStatus ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<Order> orderslist = new ArrayList<>();
        PageBean<Order> list = orderService.getWaitStorageOrder(pageInfoEntity, liuChengStatus, jingFengStatus, storageStatus);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            orderslist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("putorderlist", orderslist);
        return succResult(map);
    }

    @RequestMapping(value = "/put/check", method = RequestMethod.POST)
    public BaseResponseEntity checkOrderRuKu(@RequestParam("kuFangRemark") String kuFangRemark, @RequestParam("orderId") Long orderId,
                                             @RequestParam("storageStatus") Integer storageStatus){
        if(orderId == null || null == storageStatus){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

        Boolean result = storageService.checkStorageStatus(kuFangRemark, storageStatus, orderId);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    @RequestMapping(value = "/add/bill", method = RequestMethod.POST)
    public BaseResponseEntity addStorageBill(StorageBill storageBill){
        if(null == storageBill){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

        Boolean result = storageService.addBill(storageBill);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

    }
}
