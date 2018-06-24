package org.sang.controller.quality;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.sang.bean.*;
import org.sang.bean.requestEntity.JingFengJieSuanRequest;
import org.sang.bean.requestEntity.YgaRquest;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.OrderInfoResp;
import org.sang.bean.responseEntity.OverOrderResponse;
import org.sang.bean.responseEntity.QualityOrderResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.*;
import org.sang.utils.DoubleUtil;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quality")
public class QualityController extends BaseController {

    @Autowired
    QualityOrderService qualityOrderService;

    @Autowired
    OrderFlowService orderFlowService;

    @Autowired
    FlowStepsService flowStepsService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserOrderService userOrderService;


    /**
     * 查询项目列表
     *
     * @return
     */
    @RequestMapping(value = "/process/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                            @RequestParam(value = "userId") Integer userId,
                                            @RequestParam(value = "status") Integer status) {
        if (null == userId) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<QualityOrderResp> qualityOrderResps = new ArrayList<>();
        PageBean<QualityOrderResp> list = qualityOrderService.getQualityOrders(pageInfoEntity, userId, status);
        if (null != list && list.getItems() != null && list.getItems().size() != 0) {
            qualityOrderResps = list.getItems();
            map.put("count", list.getPageInfo().getTotal());
        }
        map.put("qualityorderlist", qualityOrderResps);
        return succResult(map);
    }

    /**
     * 查询已完结的订单列表
     *
     * @return
     */
    @RequestMapping(value = "/over/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<OverOrderResponse> qualityOrderResps = new ArrayList<>();
        PageBean<OverOrderResponse> list = qualityOrderService.getOverOrders(pageInfoEntity);
        if (null != list && list.getItems() != null && list.getItems().size() != 0) {
            qualityOrderResps = list.getItems();
            map.put("count", list.getPageInfo().getTotal());
        }
        map.put("overorderlist", qualityOrderResps);
        return succResult(map);
    }


    /**
     * 审核
     *
     * @return
     */
    @RequestMapping(value = "/audit", method = RequestMethod.POST)
    public BaseResponseEntity checkOrders(@RequestParam("orderId") Long orderId, @RequestParam("presentStepId") Integer presentStepId,
                                          @RequestParam("remark") String remark,
                                          @RequestParam("fuJianUrl") String fuJianUrl,
                                          @RequestParam("userId") Long userId,
                                          @RequestParam("userName") String userName,
                                          @RequestParam("auditResult") Integer auditResult) {
        if (null == orderId || null == presentStepId) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Order order = orderService.getOrderInfoById(orderId);
        if (null == order) {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
        OrderFlow orderFlow = orderFlowService.getByOrderId(orderId);
        if (null == orderFlow) {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("auditUserId", userId);
        map.put("auditUserName", userName);
        map.put("auditRemark", remark);
        map.put("fuJianUrl", fuJianUrl);
        map.put("auditResult", auditResult);

        String json = orderFlow.getFlowJson();
        JSONObject flows = JSON.parseObject(json);
        JSONArray steps = flows.getJSONArray("stepslist");
        String nexStepName = "";
        String nexStepId = "";
        String stepStatus = "";
        Integer status = 0;
        Boolean isLastStep = false;
        Integer stepsNums = steps.size();
        // 最后一步
        if (stepsNums == presentStepId) {
            isLastStep = true;
            stepStatus = steps.getJSONObject(presentStepId - 1).getString("stepName");
            steps.getJSONObject(presentStepId - 1).put("audit", map);
        } else {
            // 非最后一步
            stepStatus = steps.getJSONObject(presentStepId - 1).getString("stepName");
            steps.getJSONObject(presentStepId - 1).put("audit", map);
            JSONObject nexStep = steps.getJSONObject(presentStepId);
            nexStepName = nexStep.getString("stepName");
            nexStepId = nexStep.getString("stepIndex");
        }
        flows.put("stepslist", steps);
        orderFlow.setFlowJson(flows.toJSONString());
        if (isLastStep) {
            order.setLiuChengStatus(2);
            status = 1;
        }
        if (auditResult.equals(0)) {
            // 通过进行下一步 并且不是最后一步
            if (!nexStepName.equals("") && !nexStepId.equals("") && !isLastStep) {
                order.setPresentStepId(Integer.parseInt(nexStepId));
                order.setPresentStepName(nexStepName);
            }
            List<UserOrder> userOrders = userOrderService.getUserOrderByOrderId(orderId, 0);
            if (null == userOrders) {
                return badResult(ErrCodeMsg.COMMON_FAIL);
            }
            Double wancheng = 0.0;
            Double stay = 0.0;
            // 贴花
            if (stepStatus.equals("贴花")) {
                // 调整面积 订单只有完成面积以及未完成面积以及比例
                // 员工只有需完成面积 待完成面积 已完成面积 以及比例 以及每步的单独面积需完成的精封面积 需完成每步贴花的面积
                List<OrderArgeLog> orderArgeLogs = new ArrayList<>();
                for (UserOrder userOrder : userOrders) {
                    Double itemWan = userOrder.getWanChengArea() + userOrder.getTieHuaArea();
                    userOrder.setWanChengArea(DoubleUtil.m2(itemWan));
                    wancheng = wancheng + userOrder.getTieHuaArea();
                    Double itemWan2 = userOrder.getZongJiArea() - userOrder.getWanChengArea();
                    userOrder.setShengYuArea(DoubleUtil.m2(itemWan2));
                    OrderArgeLog orderArgeLog = new OrderArgeLog();
                    orderArgeLog.setOrderId(orderId);
                    orderArgeLog.setAddUserId(userId + "");
                    orderArgeLog.setAddUserName(userName);
                    orderArgeLog.setOrderName("");
                    orderArgeLog.setUserId(userOrder.getUserId());
                    orderArgeLog.setUserName(userOrder.getUserName());
                    orderArgeLog.setArge(userOrder.getTieHuaArea());
                    orderArgeLog.setStepName("贴花");
                    orderArgeLog.setStepType(1);
                    orderArgeLogs.add(orderArgeLog);

                }
                Double item = order.getAlreadyArea();

                order.setAlreadyArea(DoubleUtil.m2(item + wancheng));
                order.setStayArea(DoubleUtil.m2(order.getWorkArea() - order.getAlreadyArea()));
                Double all = item + wancheng;
                Double jidDu = 100 * (all / order.getWorkArea());
                order.setPresentSchedule(jidDu);
                Boolean reslut = qualityOrderService.shenHe(order, orderFlow, userOrders, orderArgeLogs, status);
                if (reslut) {
                    return succResult();
                } else {
                    return badResult(ErrCodeMsg.COMMON_FAIL);
                }

            }
            qualityOrderService.shenHe(order, orderFlow, null, null, status);
            return succResult();
        } else {
            // 更新步骤并通知消息
            return succResult();
        }
    }


    /**
     *
     * @param addUserId
     * @param addUserName
     * @return
     */
    @RequestMapping(value = "/moren/jingfeng", method = RequestMethod.POST)
    public BaseResponseEntity jieSuanJingFengMoRen(@RequestParam("addUserId") Long addUserId,
                                                   @RequestParam("addUserName") String addUserName,
                                                   @RequestParam("orderId") Long orderId,
                                                   @RequestParam("orderName") String orderName){
        if(null == addUserId || addUserName == null || null == orderId){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Order order = orderService.getOrderInfoById(orderId);
        if (null == order){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
        List<UserOrder> userOrders = userOrderService.getUserOrderByOrderId(orderId, 0);
        if(null == userOrders || userOrders.isEmpty()){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

        // 调整面积 订单只有完成面积以及未完成面积以及比例
        // 员工只有需完成面积 待完成面积 已完成面积 以及比例 以及每步的单独面积需完成的精封面积 需完成每步贴花的面积
        Double wancheng = 0.0;
        List<OrderArgeLog> orderArgeLogs = new ArrayList<>();
        for (UserOrder userOrder : userOrders) {
            Double itemWan = userOrder.getWanChengArea() + userOrder.getJingFengArea();
            userOrder.setWanChengArea(DoubleUtil.m2(itemWan));
            wancheng = wancheng + userOrder.getJingFengArea();
            Double itemWan2 = userOrder.getZongJiArea() - userOrder.getWanChengArea();
            userOrder.setShengYuArea(DoubleUtil.m2(itemWan2));
            OrderArgeLog orderArgeLog = new OrderArgeLog();
            orderArgeLog.setOrderId(orderId);
            orderArgeLog.setAddUserId(addUserId + "");
            orderArgeLog.setAddUserName(addUserName);
            orderArgeLog.setOrderName(orderName);
            orderArgeLog.setUserId(userOrder.getUserId());
            orderArgeLog.setUserName(userOrder.getUserName());
            orderArgeLog.setArge(userOrder.getJingFengArea());
            orderArgeLog.setStepName("精封");
            orderArgeLog.setStepType(1);
            orderArgeLogs.add(orderArgeLog);

        }
        Double item = order.getAlreadyArea();

        order.setAlreadyArea(DoubleUtil.m2(item + wancheng));
        order.setStayArea(DoubleUtil.m2(order.getWorkArea() - order.getAlreadyArea()));
        Double all = item + wancheng;
        Double jidDu = 100 * (all / order.getWorkArea());
        order.setPresentSchedule(jidDu);
        Boolean reslut = qualityOrderService.toDefaultJingFeng(order, userOrders, orderArgeLogs, 0);
        if(reslut){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    /**
     * 自定义精封分配
     *
     * @return
     */
    @RequestMapping(value = "/jie/jingfeng", method = RequestMethod.POST)
    public BaseResponseEntity jieSuanJingFeng(@RequestBody JingFengJieSuanRequest jingFengJieSuanRequest) {
        if (null == jingFengJieSuanRequest) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        if (null == jingFengJieSuanRequest.getYgas()) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        try {
            Order order = orderService.getOrderInfoById(jingFengJieSuanRequest.getOrderId());
            List<UserOrder> list = userOrderService.getUserOrderByOrderId(jingFengJieSuanRequest.getOrderId(), 0);
            List<YgaRquest> ygas = jingFengJieSuanRequest.getYgas();
            List<YgaRquest> newYgas = new ArrayList<>();
            List<UserOrder> newUserOrders = new ArrayList<>();
            if (null != list && !list.isEmpty()) {
                for (YgaRquest ygaRquest : ygas) {
                    Boolean flag = false;
                    for (UserOrder userOrder : list) {
                        // 如果相同
                        if (userOrder.getUserId().equals(ygaRquest.getUserId())) {
                            userOrder.setJingFengArea(ygaRquest.getJingFengArea());
                            userOrder.setJingFengBiLi(ygaRquest.getJingFengBiLi());
                            newUserOrders.add(userOrder);
                            flag = true;
                            break;
                        }
                    }
                    // 未曾参与者
                    if (!flag) {
                        newYgas.add(ygaRquest);
                    }
                }
                // 开始结算面积
                // 员工只有需完成面积 待完成面积 已完成面积 以及比例 以及每步的单独面积需完成的精封面积 需完成每步贴花的面积
                List<OrderArgeLog> orderArgeLogs = new ArrayList<>();
                Double wancheng = 0.0;
                Double stay = 0.0;
                List<UserOrder> needAdd = new ArrayList<>();
                if (null != newYgas && !newYgas.isEmpty()) {
                    for (YgaRquest ygaRquest : newYgas) {
                        UserOrder newUserOrder = new UserOrder();
                        newUserOrder.setJingFengBiLi(ygaRquest.getJingFengBiLi());
                        newUserOrder.setJingFengArea(ygaRquest.getJingFengArea());
                        newUserOrder.setShengYuArea(0.0);
                        newUserOrder.setWanChengArea(ygaRquest.getJingFengArea());
                        newUserOrder.setUserName(ygaRquest.getUserName());
                        newUserOrder.setUserId(ygaRquest.getUserId());
                        newUserOrder.setOrderId(jingFengJieSuanRequest.getOrderId());
                        newUserOrder.setZongJiArea(ygaRquest.getJingFengArea());
                        newUserOrder.setTieHuaArea(0.0);
                        newUserOrder.setBiLi(0.0);

                        needAdd.add(newUserOrder);

                        wancheng = wancheng + ygaRquest.getJingFengArea();

                        OrderArgeLog orderArgeLog = new OrderArgeLog();
                        orderArgeLog.setOrderId(jingFengJieSuanRequest.getOrderId());
                        orderArgeLog.setAddUserId(jingFengJieSuanRequest.getAddUserId() + "");
                        orderArgeLog.setAddUserName(jingFengJieSuanRequest.getAddUserName());
                        orderArgeLog.setOrderName("");
                        orderArgeLog.setUserId(ygaRquest.getUserId());
                        orderArgeLog.setUserName(ygaRquest.getUserName());
                        orderArgeLog.setArge(ygaRquest.getJingFengArea());
                        orderArgeLog.setStepName("精封");
                        orderArgeLog.setStepType(1);
                        orderArgeLogs.add(orderArgeLog);
                    }
                }
                for (UserOrder userOrder : newUserOrders) {
                    userOrder.setWanChengArea(userOrder.getWanChengArea() + userOrder.getJingFengArea());
                    wancheng = wancheng + userOrder.getWanChengArea();
                    userOrder.setShengYuArea(userOrder.getZongJiArea() - userOrder.getWanChengArea());
                    stay = stay + userOrder.getShengYuArea();
                    OrderArgeLog orderArgeLog = new OrderArgeLog();
                    orderArgeLog.setOrderId(userOrder.getOrderId());
                    orderArgeLog.setAddUserId(jingFengJieSuanRequest.getAddUserId() + "");
                    orderArgeLog.setAddUserName(jingFengJieSuanRequest.getAddUserName());
                    orderArgeLog.setOrderName("");
                    orderArgeLog.setUserId(userOrder.getUserId());
                    orderArgeLog.setUserName(userOrder.getUserName() + "");
                    orderArgeLog.setArge(userOrder.getJingFengArea());
                    orderArgeLog.setStepName("精封");
                    orderArgeLog.setStepType(1);
                    orderArgeLogs.add(orderArgeLog);
                }
                order.setAlreadyArea(DoubleUtil.m2(order.getAlreadyArea() + wancheng));
                order.setStayArea(DoubleUtil.m2(order.getWorkArea() - order.getAlreadyArea()));
                order.setJingFengStatus(1);
                Double all = order.getAlreadyArea() + wancheng;
                Double jinDu = 100 * (all / order.getWorkArea());
                order.setPresentSchedule(jinDu);
                // 更新
                Boolean reslut = qualityOrderService.jingFengJieSuan(order, orderArgeLogs, needAdd, newUserOrders);
                if(reslut){
                    return succResult();
                }else{
                    return badResult(ErrCodeMsg.COMMON_FAIL);
                }
            } else {
                return badResult(ErrCodeMsg.SYSTEM_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return badResult(ErrCodeMsg.SYSTEM_ERROR);
        }
    }
}
