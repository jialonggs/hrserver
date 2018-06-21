package org.sang.controller.busbao;

import org.sang.bean.BusBaoJia;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.YuBaoJia;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.BusBaoJiaService;
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
@RequestMapping(value = "/offer/bus/old")
public class BusBaoJiaController extends BaseController{

    @Autowired
    BusBaoJiaService busBaoJiaService;

    /**
     * 查看商务报价
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
        List<BusBaoJia> busbaojialist = new ArrayList<>();
        PageBean<BusBaoJia> list = busBaoJiaService.getBusBaoJiaList(pageInfoEntity, addUserId);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            busbaojialist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("busbaojialist", busbaojialist);
        return succResult(map);
    }


    /**
     *添加商务报价信息
     * @param busBaoJia
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponseEntity addBusBaoJia(BusBaoJia busBaoJia) {
        if(null == busBaoJia  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        Long i = busBaoJiaService.addBusBaoJia(busBaoJia);
        if (i >= 1) {
            map.put("id",1);
            return  succResult(map);
        } else {
            map.put("id",-1);
            return succResult(map);
        }
    }

}
