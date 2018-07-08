package org.sang.bean.requestEntity;

import org.sang.bean.ControlOrderFrom;
import org.sang.bean.Order;

public class OrderRequestInfo {
    private Order order;
    private String mouldIds;
    private ControlOrderFrom controlOrderFrom;

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
}
