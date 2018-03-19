package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.MouldInfo;
import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.Project;
import org.sang.mapper.MouldInfoMapper;
import org.sang.mapper.OrderMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    MouldInfoMapper mouldInfoMapper;

    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<Order> getOrdersList(PageInfoEntity pageInfoEntity, Integer addUserId) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<Order> list = orderMapper.getOrdersList(addUserId);
        PageInfo page = new PageInfo(list);
        PageBean<Order> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    /**
     *添加订单基础信息
     * @param order
     * @return
     */
    public Long addOrder(Order order) {
        orderMapper.addOrder(order);
        return order.getId();
    }

    public void orderSelectMould(Long[] mouldIds, Long uid, Long orderId) {
//        Map<String,Object> map = new HashMap<>();
//        List<MouldInfo> list = new ArrayList<>();
        for (Long id : mouldIds){
//            MouldInfo mouldInfo = new MouldInfo();
//            mouldInfo.setId(id);
//            mouldInfo.setSelectId(uid);
//            mouldInfo.setOrderId(orderId);
//            mouldInfo.setDeleted(true);
//            mouldInfo.setUpdateTime(new Date());
            mouldInfoMapper.updateMouldInfoBySelected(id, uid, orderId);
            // list.add(mouldInfo);
        }
//        map.put("list", list);
//        mouldInfoMapper.updateMouldInfoBySelected(map);
    }

}
