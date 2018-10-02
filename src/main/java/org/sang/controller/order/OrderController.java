package org.sang.controller.order;


import org.apache.ibatis.annotations.Param;
import org.sang.bean.*;
import org.sang.bean.requestEntity.OrderRequestInfo;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.FaMoOrder;
import org.sang.bean.responseEntity.MouldPartTreeResp;
import org.sang.bean.responseEntity.OrderInfoResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.*;
import org.sang.utils.PageBean;
import org.sang.utils.QrCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @Autowired
    SendMessageService sendMessageService;

    @Autowired
    ProjectService projectService;


    @Value("${tree.days}")
    public  String days;

    @Value("${img.location}")
    private String location;

    @Value("${imgurl.url}")
    public  String imgurl;


    /**
     * 新的添加接口
     * @param orderRequestInfo
     * @return
     */
    @RequestMapping(value = "/new/add", method = RequestMethod.POST)
    public BaseResponseEntity addNewOrderInfo( @RequestBody OrderRequestInfo orderRequestInfo){
        if(null == orderRequestInfo.getControlOrderFrom() || null == orderRequestInfo.getMouldIds() ||
                null == orderRequestInfo.getOrder() || null == orderRequestInfo.getWenlis()) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        String mouldIds = orderRequestInfo.getMouldIds();
        if(null == mouldIds ) {
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
        Order order = orderRequestInfo.getOrder();
        if(order.getExpectedTime() == null){
            order.setExpectedTime(new Date());
        }




        // 生成二维码并存入相应的地址
        Date date = new Date();
        String qrName = date.getTime()+"";
        String  path = location+"qrcode"+"/" + qrName +".png";
        Long orderId =  orderService.getMaxOrderID() + 1;
        Map<String, Object> map = new HashMap<>();
        order.setPresentStepName("待加工");
        order.setPresentSchedule(0.0);
        QrCodeUtil.zxingCodeCreate("http://39.107.78.95:8082/order.html?orderId="+orderId,500,500,path,"png");
        String url = imgurl +"qrcode"+ "/" + qrName + ".png";
        order.setQrCode(url);
        Long i = orderService.addNewOrder(order, selectedMouldIds, orderRequestInfo.getControlOrderFrom(), orderRequestInfo.getWenlis());
        if (i >= 1) {
            // 发送信息给车间主管
            String msg = "新订单【" + order.getOrderName()+"】,由  _ "+  order.getAddUserName() +" _ 创建成功,请查看";
            String title = "新订单";
            List<Long> ids = new ArrayList<>();
            ids.add(order.getManagerId());
            sendMessageService.toSendByIds(msg, title, ids);
            map.put("id",i);
            return  succResult(map);
        } else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

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
        List<FaMoOrder> orderslist = new ArrayList<>();
        PageBean<FaMoOrder> list = orderService.getOrdersList(pageInfoEntity, addUserId);
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
     * 添加订单
     * @param order
     * @return
     */
    @RequestMapping(value = "/add/order", method = RequestMethod.POST)
    public BaseResponseEntity addOrderInfo(Order order) {
        if(null == order  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        if(order.getExpectedTime() == null){
            order.setExpectedTime(new Date());
        }
        // 生成二维码并存入相应的地址
        Date date = new Date();
        String qrName = date.getTime()+"";
        String  path = location+"qrcode"+"/" + qrName +".png";
        Long orderId =  orderService.getMaxOrderID() + 1;
        Map<String, Object> map = new HashMap<>();
        order.setPresentStepName("待加工");
        order.setPresentSchedule(0.0);
        QrCodeUtil.zxingCodeCreate("http://39.107.78.95:8082/order.html?orderId="+orderId,500,500,path,"png");
        String url = imgurl +"qrcode"+ "/" + qrName + ".png";
        order.setQrCode(url);
        Long i = orderService.addOrder(order);
        if (i >= 1) {

            // 发送信息给车间主管
            String msg = "新订单【" + order.getOrderName()+"】,由  _ "+  order.getAddUserName() +" _ 创建成功,请查看";
            String title = "新订单";
            List<Long> ids = new ArrayList<>();
            ids.add(order.getManagerId());
            sendMessageService.toSendByIds(msg, title, ids);

            map.put("id",i);
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
     * 更新模具选择
     * @param mouldId
     * @return
     */

    @RequestMapping(value = "/update/set/mould", method = RequestMethod.POST)
    public BaseResponseEntity updateMould(@RequestParam("mouldId") Long mouldId){
        if(null == mouldId) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean updateResult = orderService.updateMould(mouldId);
        if(updateResult){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

    }

    /**
     * 添加订单控制单
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


    /**
     * 更新订单控制单
     * @param controlOrderFrom
     * @return
     */
    @RequestMapping(value = "/update/control", method = RequestMethod.POST)
    public BaseResponseEntity updateControlOrderFrom(ControlOrderFrom controlOrderFrom) {
        if(null == controlOrderFrom  || controlOrderFrom.getOrderId() == null) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean result = controlOrderFromService.updateControlOrderFrom(controlOrderFrom);
        if (result) {
            return  succResult();
        } else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    @RequestMapping(value = "/update/order", method = RequestMethod.POST)
    public BaseResponseEntity updateOrder(@RequestBody  Order order) {
        if(null == order  || order.getId() == null) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean result = orderService.updateBaseInfo(order);
        if (result) {
            return  succResult();
        } else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public BaseResponseEntity getOrderInfo(@Param("orderId") Long orderId){
        if(null == orderId ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        OrderInfoResp orderInfoResp = orderService.getOrderInfoResp(orderId);
        map.put("orderinfo", orderInfoResp);
        return succResult(map);

    }


    @RequestMapping(value = "/by/condition", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                            @RequestParam(value = "engineId" , required = false) Long engineId,
                                            @RequestParam(value = "carId", required = false) Long carId,
                                            @RequestParam(value = "projectId", required = false) Long projectId,
                                            @RequestParam(value = "addUserId") Long addUserId,
                                            @RequestParam(value = "unitId", required = false) Long unitId) {

        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<FaMoOrder> orderslist = new ArrayList<>();
        PageBean<FaMoOrder> list = orderService.getOrdersByConditionList(pageInfoEntity, engineId, carId, projectId, addUserId, unitId);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            orderslist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("orderlist", orderslist);
        return succResult(map);
    }


    /**
     * 修改紧急程度
     * @param urgency
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/change/urgency", method = RequestMethod.POST)
    public BaseResponseEntity changeJinJi(@RequestParam("urgency") Integer urgency, @RequestParam("orderId") Integer orderId){

        if(urgency == null || orderId == null){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }

        Boolean changeResult = orderService.changeJinJi(urgency, orderId);
        if(changeResult){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }





}
