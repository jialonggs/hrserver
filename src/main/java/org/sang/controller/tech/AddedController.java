package org.sang.controller.tech;

import org.sang.bean.LanMo;
import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.TechCard;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.TechAdded;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.LanMoService;
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
@RequestMapping(value = "/tech/added")
public class AddedController extends BaseController{

    @Autowired
    TechCardService techCardService;

    @Autowired
    OrderService orderService;

    @Autowired
    LanMoService lanMoService;

    /**
     * 查询已提交工艺卡
     * @return
     */
    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size
    ,@RequestParam(value = "wenli", required = false) String wenli, @RequestParam(value = "orderId", required = false) Long orderId) {

        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<TechAdded> stayorderlist = new ArrayList<>();
        PageBean<TechAdded> list = techCardService.getOrdersAddedTech(pageInfoEntity,wenli,orderId);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            stayorderlist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("stayorderlist", stayorderlist);
        return succResult(map);
    }


    /**
     * 根据订单Id查询
     * @param orderId
     * @return
     */

    @RequestMapping(value = "/get/tech", method = RequestMethod.GET)
    public BaseResponseEntity getTechCardByOrderId(@RequestParam("orderId") Long orderId ){
        if(null == orderId  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        TechCard techCard = techCardService.getByOrderId(orderId);
        if(null== techCard){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }else {
            map.put("techcard", techCard);
            return succResult(map);
        }
    }

    /**
     *更新工艺卡
     * @return
     */
    @RequestMapping(value = "/update/techcard", method = RequestMethod.POST)
    public BaseResponseEntity getUpdateTechCard(TechCard techCard) {
        if(null == techCard  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean lanmo = techCardService.updateTechCard(techCard);
        if(lanmo){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    /**
     * 添加烂模信息
     * @param lanMo
     * @return
     */
    @RequestMapping(value = "/add/lanmo", method = RequestMethod.POST)
    public BaseResponseEntity addTechCard(LanMo lanMo) {
        if(null == lanMo  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        TechCard techCard = techCardService.getTechId(lanMo.getTechId());
        lanMo.setOrderId(techCard.getOrderId());
        Long i = lanMoService.addLanMo(lanMo);
        if(i>0){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    /**
     *获取烂模列表
     * @return
     */
    @RequestMapping(value = "/lanmo/list", method = RequestMethod.GET)
    public BaseResponseEntity getLanMoList(@RequestParam("techId") Long techId) {
        Map<String, Object> map = new HashMap<>();
        List<LanMo> lanMoList = lanMoService.getByTechId(techId);
        map.put("lanmolist", lanMoList);
        return succResult(map);
    }

    @RequestMapping(value = "/del/lanmo", method = RequestMethod.GET)
    public BaseResponseEntity getDelLanMo(@RequestParam("id") Long id) {
        if(null == id  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean lanmo = lanMoService.delLanMo(id);
        if(lanmo){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    /**
     *更新烂模信息
     * @return
     */
    @RequestMapping(value = "/update/lanmo", method = RequestMethod.POST)
    public BaseResponseEntity getUpdateLanMo(LanMo lanMo) {
        if(null == lanMo  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean lanmo = lanMoService.updateLanMo(lanMo);
        if(lanmo){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

}
