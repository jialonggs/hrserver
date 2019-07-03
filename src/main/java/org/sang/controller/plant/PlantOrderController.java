package org.sang.controller.plant;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.*;
import org.sang.bean.requestEntity.JingFengJieSuanRequest;
import org.sang.bean.requestEntity.OrderFenPeiRequest;
import org.sang.bean.requestEntity.OrderLiuZhuanRequest;
import org.sang.bean.requestEntity.YgaRquest;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.OrderAndProject;
import org.sang.bean.responseEntity.OverOrderResponse;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.*;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/plant")
public class PlantOrderController extends BaseController{

    @Autowired
    OrderService orderService;

    @Autowired
    PlantService plantService;

    @Autowired
    UserOrderService userOrderService;

    @Autowired
    QualityOrderService qualityOrderService;

    @Autowired
    OrderFlowService orderFlowService;





    @RequestMapping(value = "/new/order", method = RequestMethod.GET)
    public BaseResponseEntity getNewOrder(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                          @RequestParam("userId") Long userId, @RequestParam("plantStatus") Integer plantStatus){
        if(null == userId){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<OrderAndProject> orderslist = new ArrayList<>();
        PageBean<OrderAndProject> list = orderService.getPlantOrdersList1(pageInfoEntity, userId, plantStatus);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            orderslist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("orderlist", orderslist);
        return succResult(map);
    }


    @RequestMapping(value = "/new/order/condition", method = RequestMethod.GET)
    public BaseResponseEntity getNewOrderByCadition(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                          @RequestParam("userId") Long userId, @RequestParam("plantStatus") Integer plantStatus,
                                          @RequestParam(value = "projectId", required = false) Long projectId,
                                          @RequestParam(value = "unitId", required = false) Long unitId,
                                          @RequestParam(value = "orderName", required = false) String orderName){
        if(null == userId){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<OrderAndProject> orderslist = new ArrayList<>();
        PageBean<OrderAndProject> list = orderService.getPlantOrdersList(pageInfoEntity, userId, plantStatus, projectId, unitId, orderName);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            orderslist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("orderlist", orderslist);
        return succResult(map);
    }

    /**
     * 分配工作
     *
     * @param flowId
     * @param ygaIds
     * @param qualityUsers
     * @return
     */
//    @RequestMapping(value = "/fen/pei", method = RequestMethod.POST)
//    public BaseResponseEntity fenPeiOrder(@RequestParam(value = "flowId") Long flowId,
//                                          @RequestParam(value = "orderId") Long orderId,
//                                          @RequestParam(value = "flowInfo") String flowInfo,
//                                          @RequestParam(value = "nanDuXiShu") Integer nanDuXiShu,
//                                          @RequestParam(value = "ygaIds") String ygaIds,
//                                          @RequestParam(value = "qualityUsers") String qualityUsers){
//
//        if(null == flowId || null == orderId || null == flowInfo || null == ygaIds || null == qualityUsers
//                || null == nanDuXiShu){
//            return badResult(ErrCodeMsg.ARGS_MISSING);
//        }
//
//        Order order = orderService.getOrderInfoById();
//        if(null == order){
//            return badResult(ErrCodeMsg.COMMON_FAIL);
//        }
//        try {
//            String[] _ygaIds = ygaIds.split(",");
//            List<UserOrder> userOrders = new ArrayList<>();
//            Integer ygaNums = _ygaIds.length;
//            Double realArea = order.getRealityArea(); // 获取实际加工面积
//            Double allArea = realArea * 2 * nanDuXiShu;// 总面积
//            Double onePersonAreaTieHua = allArea / ygaNums;//一个人贴花面积
//            Double onePersonJingFeng = allArea * 0.1;// 一个人的精封面积
//            for
//
//        }catch (Exception e){
//
//        }
//        return null;
//    }


    /**
     * 分配工作
     *
     * @return
     */
    @RequestMapping(value = "/fen/pei", method = RequestMethod.POST)
    public BaseResponseEntity fenPeiOrder(@RequestBody OrderFenPeiRequest orderFenPeiRequest){

        if(null == orderFenPeiRequest){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }

        Order order = orderService.getOrderInfoById(orderFenPeiRequest.getOrderId());
        if (order.getPlantStatus() == 1){
            return badResult(ErrCodeMsg.ORDER_PLANTED_ERROR);
        }
        if(null == order){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
        try {
            // 分配员工
            List<UserOrder> userOrders = new ArrayList<>();
            List<YgaRquest> ygas = orderFenPeiRequest.getYgas();
            Double realArea = order.getRealityArea(); // 获取实际加工面积

            for(int i = 0; i< ygas.size(); i++){
                UserOrder userOrder = new UserOrder();
                userOrder.setJingFengArea(ygas.get(i).getJingFengArea());
                userOrder.setAddUserId(orderFenPeiRequest.getAddUserId());
                userOrder.setAddUserName(orderFenPeiRequest.getAddUserName());
                userOrder.setOrderId(orderFenPeiRequest.getOrderId());
                userOrder.setOrderName(orderFenPeiRequest.getOrderName());
                userOrder.setZongJiArea(ygas.get(i).getOrderNeedArea() * ygas.get(i).getBiLi() / 100);
                userOrder.setShengYuArea(ygas.get(i).getOrderNeedArea() * ygas.get(i).getBiLi() / 100);
                userOrder.setTieHuaArea(ygas.get(i).getOneceTieHuaArea());
                userOrder.setUserId(ygas.get(i).getUserId());
                userOrder.setBiLi(ygas.get(i).getBiLi());
                userOrder.setUserName(ygas.get(i).getUserName());
                userOrders.add(userOrder);
            }

            // 添加质量总监
            List<Hr> qualityUsers = orderFenPeiRequest.getQualityUsers();
            List<QualityOrderUser> qualityOrderUsers = new ArrayList<>();
            for(int i = 0; i< qualityUsers.size(); i++){
                QualityOrderUser qualityOrderUser = new QualityOrderUser();
                qualityOrderUser.setAddUserId(orderFenPeiRequest.getAddUserId());
                qualityOrderUser.setAddUserName(orderFenPeiRequest.getAddUserName());
                qualityOrderUser.setPrincipalType(0);
                qualityOrderUser.setOrderId(orderFenPeiRequest.getOrderId());
                qualityOrderUser.setUserId(qualityUsers.get(i).getId());
                qualityOrderUser.setUserName(qualityUsers.get(i).getName());
                qualityOrderUsers.add(qualityOrderUser);
            }
            // 添加流程
            OrderFlow orderFlow = new OrderFlow();
            orderFlow.setAddUserId(orderFenPeiRequest.getAddUserId());
            orderFlow.setAddUserName(orderFenPeiRequest.getAddUserName());
            orderFlow.setOrderId(orderFenPeiRequest.getOrderId());
            orderFlow.setFlowJson(JSONObject.toJSONString(orderFenPeiRequest.getFlow()));

            // 设置订单工序的第一步骤
            order.setPresentStepName(orderFenPeiRequest.getFlow().getStepslist().get(0).getStepName());
            order.setPresentStepId(Integer.parseInt(orderFenPeiRequest.getFlow().getStepslist().get(0).getStepIndex()+""));
            order.setStayArea(ygas.get(0).getOrderNeedArea());
            order.setPerfectArea(ygas.get(0).getOrderNeedArea()*0.1);
            order.setAppliqueArea(ygas.get(0).getOrderNeedArea()*0.9);
            order.setAlreadyArea(0.0);
            Boolean reslut = plantService.fenPei(order, userOrders, qualityOrderUsers, orderFlow);
            if(reslut){
                return succResult();
            }else{
                return badResult(ErrCodeMsg.COMMON_FAIL);
            }
        }catch (Exception e){
            e.printStackTrace();
            return badResult(ErrCodeMsg.SYSTEM_ERROR);
        }

    }


    /**
     * 获取订单分配用户
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public BaseResponseEntity getOrderUser(@RequestParam("orderId") Long orderId, @RequestParam("status") Integer status){
        if(null == orderId || null == status ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        List<UserOrder> userOrders = userOrderService.getUserOrderByOrderId(orderId, status);
        map.put("orderusers", userOrders);
        return succResult(map);
    }

    /**
     * 结算订单
     * @return
     */
    @RequestMapping(value = "/jie/suan", method = RequestMethod.POST)
    public BaseResponseEntity jieSuan(UserOrder userOrder){
        if(null == userOrder ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Order order = orderService.getOrderInfoById(userOrder.getOrderId());
        if(null == order){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

        Double result = orderService.liuZhuan(order, userOrder);
        if(result > 0){
            return succResult(result);
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    /**
     * 流转分配
     * @return
     */
    @RequestMapping(value = "/liu/zhuan", method = RequestMethod.POST)
    public BaseResponseEntity fenPeiOrder(@RequestBody OrderLiuZhuanRequest orderLiuZhuanRequest){
        if(null == orderLiuZhuanRequest){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        try {
            // 分配员工
            List<UserOrder> userOrders = new ArrayList<>();
            List<YgaRquest> ygas = orderLiuZhuanRequest.getYgas();
//            Order order = orderService.getOrderInfoById(orderLiuZhuanRequest.getOrderId());
//            if(null == order){
//                return badResult(ErrCodeMsg.COMMON_FAIL);
//            }
            Order order = orderService.getOrderInfoById(orderLiuZhuanRequest.getOrderId());
            if(null == order ){
                return badResult(ErrCodeMsg.COMMON_FAIL);
            }

            for(int i = 0; i< ygas.size(); i++){
                UserOrder userOrder = new UserOrder();
                userOrder.setJingFengArea(ygas.get(i).getJingFengArea());
                userOrder.setAddUserId(orderLiuZhuanRequest.getAddUserId());
                userOrder.setAddUserName(orderLiuZhuanRequest.getAddUserName());
                userOrder.setOrderId(orderLiuZhuanRequest.getOrderId());
                userOrder.setOrderName(orderLiuZhuanRequest.getOrderName());
                userOrder.setZongJiArea(ygas.get(i).getOrderNeedArea() * ygas.get(i).getBiLi() / 100);
                userOrder.setTieHuaArea(ygas.get(i).getOneceTieHuaArea());
                userOrder.setUserId(ygas.get(i).getUserId());
                userOrder.setShengYuArea(ygas.get(i).getOrderNeedArea() * ygas.get(i).getBiLi() / 100);
                userOrder.setBiLi(ygas.get(i).getBiLi());
                userOrder.setUserName(ygas.get(i).getUserName());
                userOrders.add(userOrder);
            }

            Double reslut = plantService.liuZhuan(userOrders, order);
            if(reslut > 0){
                return succResult(reslut);
            }else{
                return badResult(ErrCodeMsg.COMMON_FAIL);
            }
        }catch (Exception e){
            e.printStackTrace();
            return badResult(ErrCodeMsg.SYSTEM_ERROR);
        }
    }


    /**
     * 修改难度等级
     * @param nanDuDengJi
     * @return
     */
    @RequestMapping(value = "/nan/du", method = RequestMethod.POST)
    public BaseResponseEntity updateOrderNanDu(@Param("nanDuDengJi") String nanDuDengJi, @Param("orderId") Long orderId){
        if(null == nanDuDengJi ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        int i = orderService.updateOrderNanDu(nanDuDengJi, orderId);
        if(i>0){
            return succResult();
        }else{
            return  badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    /**
     * 查询已完结的订单列表
     *
     * @return
     */
    @RequestMapping(value = "/over/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                            @RequestParam(value = "projectId", required = false) Long projectId,
                                            @RequestParam(value = "unitId", required = false) Long unitId,
                                            @RequestParam(value = "orderName", required = false) String orderName) {
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<OverOrderResponse> qualityOrderResps = new ArrayList<>();
        PageBean<OverOrderResponse> list = qualityOrderService.getOverOrders1(pageInfoEntity, projectId, unitId, orderName);
        if (null != list && list.getItems() != null && list.getItems().size() != 0) {
            qualityOrderResps = list.getItems();
            map.put("count", list.getPageInfo().getTotal());
        }
        map.put("overorderlist", qualityOrderResps);
        return succResult(map);
    }



    /**
     * 获取订单分配用户
     * @return
     */
    @RequestMapping(value = "/back", method = RequestMethod.POST)
    public BaseResponseEntity backOrder(@RequestParam("orderId") Long orderId, @RequestParam("userId") Integer userId){
        if(null == orderId || null == userId ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Order order = orderService.getOrderInfoById(orderId);
        if (order == null) {
            return badResult(ErrCodeMsg.ORDER_IS_NULL);
        }
        if (order.getPlantStatus() != 1) {
            return badResult(ErrCodeMsg.ORDER_IS_NOT_PLAN);
        }

        if(order.getAlreadyArea() > 0 || order.getJingFengStatus() >0){
            return badResult(ErrCodeMsg.ORDER_IS_HAVE_ARE);
        }
        // 校验是否已进入加工状态
//        OrderFlow orderFlow = orderFlowService.getByOrderId(orderId);
//        if (null == orderFlow) {
//            return badResult(ErrCodeMsg.ORDER_IS_NOT_PLAN);
//        }
//        // 校验是否已经进行第一步
//        String json = orderFlow.getFlowJson();
//        JSONObject flows = JSON.parseObject(json);
//        JSONArray steps = flows.getJSONArray("stepslist");

        Boolean result = userOrderService.backFenPei(orderId);
        if (result) {
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }
}
