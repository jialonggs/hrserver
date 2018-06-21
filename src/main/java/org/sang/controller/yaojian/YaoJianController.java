package org.sang.controller.yaojian;

import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.YaoJian;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.YaoJianOrderResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.OrderService;
import org.sang.service.YaoJianService;
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
@RequestMapping(value = "/yao/list")
public class YaoJianController extends BaseController{

    @Autowired
    OrderService orderService;

    @Autowired
    YaoJianService yaoJianService;


    /**
     * 药检列表
     * @return
     */
    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                            @RequestParam(value = "yaoJian") Boolean yaoJian) {

        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<Order> yaolist = new ArrayList<>();
        PageBean<Order> list = yaoJianService.getYubaoJiaList(pageInfoEntity, yaoJian);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
                yaolist = list.getItems();
                map.put("count",list.getPageInfo().getTotal());
        }
        map.put("yaolist", yaolist);
        return succResult(map);
    }


    /**
     * 已添加药检列表
     * @return
     */
    @RequestMapping(value = "/added", method = RequestMethod.GET)
    public BaseResponseEntity getAdded(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {

        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<YaoJianOrderResp> yaolist = new ArrayList<>();
        PageBean<YaoJianOrderResp> list = yaoJianService.getAddedList(pageInfoEntity);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            yaolist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("yaolist", yaolist);
        return succResult(map);
    }

    /**
     * 添加药检记录
     * @param yaoJian
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponseEntity addYaoJian(YaoJian yaoJian){
        if(null == yaoJian){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        int i = yaoJianService.addYaoJian(yaoJian);
        if(i > 0){
            return  succResult();
        }else {
            return  badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

}
