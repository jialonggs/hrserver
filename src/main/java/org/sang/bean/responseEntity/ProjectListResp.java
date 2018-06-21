package org.sang.bean.responseEntity;

import org.sang.bean.BusinessBaoJia;
import org.sang.bean.Order;
import org.sang.bean.Project;
import org.sang.bean.YuBaoJia;

import java.util.List;

public class ProjectListResp extends Project{

//    private Long yuBaoJiaId;
//    private Integer yuBaoJiaStatus;
//
//    private Long shangWuId;
//    private Integer shangWuStatus;
//
      private Integer orderNums;
//    private Double orderSchedule;


      private YuBaoJiaInfoResp yuBaoJia;
      private BusInfoResp businessBaoJia;
      private List<Order> orders;


    public YuBaoJiaInfoResp getYuBaoJia() {
        return yuBaoJia;
    }

    public void setYuBaoJia(YuBaoJiaInfoResp yuBaoJia) {
        this.yuBaoJia = yuBaoJia;
    }

    public BusInfoResp getBusinessBaoJia() {
        return businessBaoJia;
    }

    public void setBusinessBaoJia(BusInfoResp businessBaoJia) {
        this.businessBaoJia = businessBaoJia;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Integer getOrderNums() {
        return orderNums;
    }

    public void setOrderNums(Integer orderNums) {
        this.orderNums = orderNums;
    }
}
