package org.sang.controller.wuliao;


import org.sang.bean.Hr;
import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.WuLiao;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.HrService;
import org.sang.service.WuLiaoService;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/material")
public class WuLiaoController  extends BaseController {

    @Autowired
    WuLiaoService wuLiaoService;

    @Autowired
    HrService hrService;



    /**
     * 查询项目列表
     * @return
     */
    @RequestMapping(value = "/record/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                            @RequestParam(value = "addUserId") Long addUserId) {
        if(null == addUserId ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<WuLiao> wuLiaoList = new ArrayList<>();
        PageBean<WuLiao> list = wuLiaoService.getWuLiaoList(pageInfoEntity, addUserId);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            wuLiaoList = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("wuliaolist", wuLiaoList);
        return succResult(map);
    }


    /**
     * 添加物料单
     * @return
     */
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public BaseResponseEntity addWuliao(WuLiao wuLiao){
        if(null == wuLiao  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        Long i = wuLiaoService.addWuLiao(wuLiao);
        if (i >= 1) {
            map.put("id",i);
            return  succResult(map);
        } else {
            map.put("id",-1);
            return succResult(map);
        }
    }

    /**
     * 获取该员工被分配的订单列表
     * @return
     */
    @RequestMapping(value = "/apply/order/list", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersBy(@RequestParam("userId") Long userId){
        if(null == userId  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        List<Order> orderList = wuLiaoService.getOrderList(userId);
        return succResult(orderList);
    }

    /**
     * 验证操作人员信息
     * @param
     * @return
     */
    @RequestMapping(value = "/apply/check", method = RequestMethod.POST)
    public BaseResponseEntity checkUserInfo(@RequestParam("userPhone") String userPhone, @RequestParam("password") String password) {
        if(userPhone.isEmpty() ||  password.isEmpty() ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        UserDetails hr = hrService.loadUserByUsername(userPhone);
        if(null == hr){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String userPassword = encoder.encode(password);
            if(userPassword.equals(hr.getPassword())){
                map.put("userInfo", hr);
            }else{
                return badResult(ErrCodeMsg.COMMON_FAIL);
            }

        }
        return succResult(map);
    }




}
