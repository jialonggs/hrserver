package org.sang.Component;


import com.sun.org.apache.xpath.internal.operations.Or;
import org.sang.bean.Hr;
import org.sang.bean.Order;
import org.sang.service.HrService;
import org.sang.service.OrderService;
import org.sang.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class CheckOrderDay {

    @Autowired
    OrderService orderService;

    @Autowired
    SendMessageService sendMessageService;

    @Autowired
    HrService hrService;

    @Scheduled(cron = "0 0 5 * * ?")
    public void checkCollect(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar nowDay = Calendar.getInstance();
        nowDay.add(Calendar.DATE, -3);
        String  beginDate = sdf.format(nowDay.getTime());
        // 查看未发模并且已超过三天 发防锈警报
        List<Order> orderList = orderService.getNeedAlert(beginDate);
        if(null != orderList && !orderList.isEmpty()){
            this.sendMsg(orderList);
        }

    }

    public void sendMsg(List<Order> list){
        // 只发送 车间主管以及库房主管
        List<Hr> hrs = hrService.getByRole("ROLE_chejian");
        String msg = "";
        for (Order order : list){
            msg = msg + "  " + order.getId() + "  ------  " + order.getOrderName() + "   |   ";
        }
        msg = "需要的防锈的订单如下：" + msg;
        String title = "需要防锈处理的订单";
        List<Long> ids = new ArrayList<>();
        for (Hr hr : hrs){
            ids.add(hr.getId());
        }
        sendMessageService.toSendByIds(msg,title, ids);
    }
}
