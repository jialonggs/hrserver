package org.sang.service;

import org.sang.bean.Hr;
import org.sang.bean.OrderArgeLog;
import org.sang.bean.UserOrder;
import org.sang.bean.responseEntity.HuiZongCountResp;
import org.sang.bean.responseEntity.UsersOrderResp;
import org.sang.mapper.HrMapper;
import org.sang.mapper.OrderArgeLogMapper;
import org.sang.mapper.UserOrderMapper;
import org.sang.utils.DateFormatUtil;
import org.sang.utils.DoubleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountService {

    @Autowired
    UserOrderMapper userOrderMapper;

    @Autowired
    HrMapper hrMapper;

    @Autowired
    OrderArgeLogMapper orderArgeLogMapper;

    public List<HuiZongCountResp> getHuiZong(){
        // 本月接单--按时间
      String monthFirst = DateFormatUtil.getMonthFirst(DateFormatUtil.YYYY_MM_DD_HH_MM);

       // 本月所有的接单
        List<UserOrder> currentOrders = userOrderMapper.getByTime(monthFirst);
        //上月数据
        List<UserOrder> lastMonthOrders = userOrderMapper.getLastTime(monthFirst,0);
        // 员工完成面积记录
        List<OrderArgeLog> logs = orderArgeLogMapper.getLogs(monthFirst);
        List<Hr> allUsers = hrMapper.getByRole("ROLE_yga");
        List<HuiZongCountResp> list = new ArrayList<>();
        for (Hr hr : allUsers){
            HuiZongCountResp huiZongCountResp = new HuiZongCountResp();
            Double lastMonthArge = 0.0;
            Double workTime = 0.0;
            //Double currentMonthNeedArge = 0.0;
            Double currentMonthFinishArge = 0.0;
            Double currentMonthArge = 0.0;
            Double lastMonth = 0.0;
            // 本月需要完成的
            for (UserOrder userOrder : currentOrders){
                if(userOrder.getUserId() == hr.getId()){
                    if(userOrder.getStatus().equals("1")){
                        // 面积已被流转
                        currentMonthArge = currentMonthArge + userOrder.getWanChengArea();
                    }else{
                        currentMonthArge = currentMonthArge + userOrder.getZongJiArea();
                    }
                }
            }
            // 本月完成记录
            for (OrderArgeLog orderArgeLog : logs){
                if (orderArgeLog.getUserId() == hr.getId()){
                    currentMonthFinishArge = currentMonthFinishArge + orderArgeLog.getArge();
                }
            }
            // 上月遗留
            for (UserOrder userOrder : lastMonthOrders){
                if(userOrder.getUserId() == hr.getId() && !userOrder.getStatus().equals("1")){
                    lastMonth = lastMonth + userOrder.getShengYuArea();
                }
            }
            huiZongCountResp.setCurrentMonthFinishArge(DoubleUtil.m2(currentMonthFinishArge));
            huiZongCountResp.setCurrentMonthNeedArge(DoubleUtil.m2(currentMonthArge + lastMonth));
            huiZongCountResp.setCurrentMonthArge(DoubleUtil.m2(currentMonthArge));
            huiZongCountResp.setCurrentMonthShenYuArge(DoubleUtil.m2(currentMonthArge + lastMonth-currentMonthFinishArge));
            huiZongCountResp.setLastMonthArge(DoubleUtil.m2(lastMonthArge));
            huiZongCountResp.setUserId(hr.getId());
            huiZongCountResp.setUserName(hr.getName());
            huiZongCountResp.setWorkTime(0.0);
            huiZongCountResp.setEfficiency(0.0);
            list.add(huiZongCountResp);
        }
        return list;

    }
}
