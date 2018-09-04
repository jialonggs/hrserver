package org.sang.bean.responseEntity;

import org.sang.bean.*;

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
      private Car car;
      private ProcessUnit processUnit;



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

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public ProcessUnit getProcessUnit() {
        return processUnit;
    }

    @Override
    public void setProcessUnit(ProcessUnit processUnit) {
        this.processUnit = processUnit;
    }
}
