package org.sang.bean.requestEntity;

import org.sang.bean.ControlOrderFrom;
import org.sang.bean.Order;
import org.sang.bean.WenLi;

import java.util.List;

public class OrderRequestInfo {
    private Order order;
    private String mouldIds;
    private ControlOrderFrom controlOrderFrom;
    private List<WenLi> wenlis;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getMouldIds() {
        return mouldIds;
    }

    public void setMouldIds(String mouldIds) {
        this.mouldIds = mouldIds;
    }

    public ControlOrderFrom getControlOrderFrom() {
        return controlOrderFrom;
    }

    public void setControlOrderFrom(ControlOrderFrom controlOrderFrom) {
        this.controlOrderFrom = controlOrderFrom;
    }

    public List<WenLi> getWenlis() {
        return wenlis;
    }

    public void setWenlis(List<WenLi> wenlis) {
        this.wenlis = wenlis;
    }
}
