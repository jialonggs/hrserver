package org.sang.bean.requestEntity;

import org.sang.bean.Hr;
import org.sang.bean.responseEntity.FlowStepsResp;

import java.util.List;

public class JingFengJieSuanRequest {

    private Long orderId;
    private String orderName;
    private Long addUserId;
    private String addUserName;

    private List<YgaRquest> ygas;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Long getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(Long addUserId) {
        this.addUserId = addUserId;
    }

    public String getAddUserName() {
        return addUserName;
    }

    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    public List<YgaRquest> getYgas() {
        return ygas;
    }

    public void setYgas(List<YgaRquest> ygas) {
        this.ygas = ygas;
    }
}
