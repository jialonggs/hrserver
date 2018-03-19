package org.sang.controller.order;


import org.omg.PortableInterceptor.INACTIVE;
import org.sang.bean.*;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.MouldPartTreeResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.ControlOrderFromService;
import org.sang.service.HrService;
import org.sang.service.MouldInfoService;
import org.sang.service.OrderService;
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
@RequestMapping(value = "/order/list")
public class OrderController extends BaseController{

    @Autowired
    OrderService orderService;

    @Autowired
    HrService hrService;

    @Autowired
    MouldInfoService mouldInfoService;

    @Autowired
    ControlOrderFromService controlOrderFromService;


    @Value("${tree.days}")
    public  String days;

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
        List<Order> orderslist = new ArrayList<>();
        PageBean<Order> list = orderService.getOrdersList(pageInfoEntity, addUserId);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            orderslist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("orderlist", orderslist);
        return succResult(map);
    }

    /**
     * 获取角色为车间主管的用户
     * @return
     */
    @RequestMapping(value = "/mangers", method = RequestMethod.GET)
    public BaseResponseEntity getHrRoleOfManger(@RequestParam(value = "role") String role) {
        List<Hr> list = hrService.getByRole(role);
        if(null == list || list.size() == 0){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
        return succResult(list);
    }

    /**
     * 添加项目信息
     * @param order
     * @return
     */
    @RequestMapping(value = "/add/order", method = RequestMethod.POST)
    public BaseResponseEntity addShouMo(Order order) {
        if(null == order  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        Long i = orderService.addOrder(order);
        if (i >= 1) {
            map.put("id",1);
            return  succResult(map);
        } else {
            map.put("id",-1);
            return succResult(map);
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
            List<MouldPartTreeResp> list = mouldInfoService.getCollectInfosByTime(Integer.parseInt(days));
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


    /**
     * 订单设置模具信息
     * @return
     */
    @RequestMapping(value = "/set/mould", method = RequestMethod.POST)
    public BaseResponseEntity orderSetMould(@RequestParam("mouldIds") String mouldIds, @RequestParam("uid") Long uid,@RequestParam("orderId") Long orderId){
        try {
            if(null == mouldIds || null == uid || null == orderId) {
                return badResult(ErrCodeMsg.ARGS_MISSING);
            }
            String[] selectMoulds = mouldIds.split(",");
            if(null == selectMoulds || selectMoulds.length <=0){
                return badResult(ErrCodeMsg.ARGS_MISSING);
            }
            Long[] selectedMouldIds = new Long[selectMoulds.length];
            for(int i=0; i<selectMoulds.length; i++){
                selectedMouldIds[i] = Long.parseLong(selectMoulds[i]);
            }
            orderService.orderSelectMould(selectedMouldIds, uid, orderId);
            return succResult();
        } catch (Exception e) {
            e.printStackTrace();
            return  badResult(ErrCodeMsg.SYSTEM_ERROR);
        }
    }

    /**
     * 添加项目信息
     * @param controlOrderFrom
     * @return
     */
    @RequestMapping(value = "/add/control", method = RequestMethod.POST)
    public BaseResponseEntity addControlOrderFrom(ControlOrderFrom controlOrderFrom) {
        if(null == controlOrderFrom  || controlOrderFrom.getOrderId() == null) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        Long i = controlOrderFromService.addControlOrderFrom(controlOrderFrom);
        if (i >= 1) {
            map.put("id",1);
            return  succResult(map);
        } else {
            map.put("id",-1);
            return succResult(map);
        }
    }
}
