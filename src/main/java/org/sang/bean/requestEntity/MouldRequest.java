package org.sang.bean.requestEntity;

public class MouldRequest {
    private Long orderId;
    private Long uid;
    private String mouldIds;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getMouldIds() {
        return mouldIds;
    }

    public void setMouldIds(String mouldIds) {
        this.mouldIds = mouldIds;
    }
}
