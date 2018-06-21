package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.UserOrder;
import org.sang.bean.responseEntity.UserOrderCountResp;
import org.sang.mapper.UserOrderMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderService {
    @Autowired
    UserOrderMapper userOrderMapper;

    public  List<UserOrder>  getUserOrderByOrderId(Long orderId, Integer status){
        return userOrderMapper.getUserOrderByOrderId(orderId, status);
    }


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<UserOrderCountResp> getOrdersList(PageInfoEntity pageInfoEntity, Integer userId) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<UserOrderCountResp> list = userOrderMapper.getCountUserOrder(userId);
        PageInfo page = new PageInfo(list);
        PageBean<UserOrderCountResp> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }
}
