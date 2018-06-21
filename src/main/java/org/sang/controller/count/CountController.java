package org.sang.controller.count;

import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.UserOrder;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.HuiZongCountResp;
import org.sang.bean.responseEntity.UserOrderCountResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.CountService;
import org.sang.service.OrderService;
import org.sang.service.UserOrderService;
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
@RequestMapping(value = "/count/work")
public class CountController extends BaseController{

    @Autowired
    CountService countService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserOrderService userOrderService;


    @RequestMapping(value = "/huizong",method = RequestMethod.GET)
    public BaseResponseEntity getHuiZhongBiao(){
        Map<String, Object> map = new HashMap<>();
        // 员工的汇总表
        // ----总表单----
        // 汇集员工上月的遗留面积?
        // 汇集员工所有本月的接单面积
        List<HuiZongCountResp> list = countService.getHuiZong();
        map.put("huizong", list);
        return succResult(map);
    }

    /**
     * 查询项目列表
     * @return
     */
    @RequestMapping(value = "/user/order/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                            @RequestParam(value = "userId") Integer userId) {
        if(null == userId ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<UserOrderCountResp> orderslist = new ArrayList<>();
        PageBean<UserOrderCountResp> list = userOrderService.getOrdersList(pageInfoEntity, userId);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            orderslist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("userordercount", orderslist);
        return succResult(map);
    }
}
