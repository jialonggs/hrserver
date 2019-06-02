package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.Order;
import org.sang.bean.OrderFlow;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.UserOrder;
import org.sang.bean.responseEntity.UserOrderCountResp;
import org.sang.mapper.*;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserOrderService {
    @Autowired
    UserOrderMapper userOrderMapper;

    @Autowired
    QualityOrderUserMapper qualityOrderUserMapper;


    @Autowired
    OrderFlowMapper orderFlowMapper;

    @Autowired
    StepMapper stepMapper;

    @Autowired
    OrderMapper orderMapper;

    public  List<UserOrder>  getUserOrderByOrderId(Long orderId, Integer status){
        return userOrderMapper.getUserOrderByOrderId(orderId, status);
    }


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<UserOrderCountResp> getOrdersList(PageInfoEntity pageInfoEntity, Integer userId,String startTime1,String endTime1) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<UserOrderCountResp> list = userOrderMapper.getCountUserOrder(userId, startTime1, endTime1);
        PageInfo page = new PageInfo(list);
        PageBean<UserOrderCountResp> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    @Transactional
    public Boolean backFenPei(Long orderId) {
        try {
            // 删除质量分配
            qualityOrderUserMapper.delByOrderId(orderId);
            // 删除技工分配
            userOrderMapper.delByOrderId(orderId);

            // 删除流程分配
            orderFlowMapper.delByOrderId(orderId);
//
//        // 删除步骤分配
//        stepMapper.delByOrderId(orderId);
            // 回退到未分配状态
            orderMapper.updateBackPlant(orderId);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
