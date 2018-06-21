package org.sang.controller.tech;

import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.TechCard;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.OrderService;
import org.sang.service.TechCardService;
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
@RequestMapping(value = "/tech/stay")
public class TechController extends BaseController{

    @Autowired
    OrderService orderService;

    @Autowired
    TechCardService techCardService;


    /**
     * 查询未提交工艺卡
     * @return
     */
    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size
                                            ) {

        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<Order> stayorderlist = new ArrayList<>();
        PageBean<Order> list = orderService.getOrdersUnAddedTech(pageInfoEntity,false);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            stayorderlist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("stayorderlist", stayorderlist);
        return succResult(map);
    }



    /**
     * 添加项目工艺卡
     * @param techCard
     * @return
     */
    @RequestMapping(value = "/add/tech", method = RequestMethod.POST)
    public BaseResponseEntity addTechCard(TechCard techCard) {
        if(null == techCard  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean i = techCardService.addTech(techCard);
        if(i){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


}
