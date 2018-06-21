package org.sang.bean;

import java.util.Date;

public class UserOrder {

    private Long id;
    private Long orderId;
    private String orderName;
    private Long userId;
    private String userName;


    private Double zongJiArea;
    private Double shengYuArea;
    private Double wanChengArea;
    private Double jingFengArea;
    private Double jingFengBiLi;
    private Double tieHuaArea;
    private Double biLi;


    private Long  addUserId;
    private String addUserName;
    private String status;
    private String remark;
    private Boolean isDeleted;
    private Date updateTime;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getZongJiArea() {
        return zongJiArea;
    }

    public void setZongJiArea(Double zongJiArea) {
        this.zongJiArea = zongJiArea;
    }

    public Double getShengYuArea() {
        return shengYuArea;
    }

    public void setShengYuArea(Double shengYuArea) {
        this.shengYuArea = shengYuArea;
    }

    public Double getWanChengArea() {
        return wanChengArea;
    }

    public void setWanChengArea(Double wanChengArea) {
        this.wanChengArea = wanChengArea;
    }

    public Double getJingFengArea() {
        return jingFengArea;
    }

    public void setJingFengArea(Double jingFengArea) {
        this.jingFengArea = jingFengArea;
    }

    public Double getTieHuaArea() {
        return tieHuaArea;
    }

    public void setTieHuaArea(Double tieHuaArea) {
        this.tieHuaArea = tieHuaArea;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getBiLi() {
        return biLi;
    }

    public void setBiLi(Double biLi) {
        this.biLi = biLi;
    }

    public Double getJingFengBiLi() {
        return jingFengBiLi;
    }

    public void setJingFengBiLi(Double jingFengBiLi) {
        this.jingFengBiLi = jingFengBiLi;
    }
}
