package org.sang.bean;

import java.util.Date;

public class ShouHou {

    private Long id;
    private Integer orderId;
    private Integer xzId;
    private Integer shId;
    private String address;
    private String danwei;
    private Long userId;
    private String userName;
    private String days;
    private String diDian;
    private String ZJremark;
    private Date toTime;

    private Long cheJianId;
    private Long xingZhengId;

    private String addUserId;
    private String addUserName;
    private Date finishTime;
    private Integer status;
    private String remark;
    private Boolean isDeleted;
    private Date updateTime;
    private Date createTime;
    private String wanJieUrls;
    private String wanJieRemark;


    public Long getCheJianId() {
        return cheJianId;
    }

    public void setCheJianId(Long cheJianId) {
        this.cheJianId = cheJianId;
    }

    public Long getXingZhengId() {
        return xingZhengId;
    }

    public void setXingZhengId(Long xingZhengId) {
        this.xingZhengId = xingZhengId;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getDiDian() {
        return diDian;
    }

    public void setDiDian(String diDian) {
        this.diDian = diDian;
    }

    public String getZJremark() {
        return ZJremark;
    }

    public void setZJremark(String ZJremark) {
        this.ZJremark = ZJremark;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public String getAddUserName() {
        return addUserName;
    }

    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public Integer getXzId() {
        return xzId;
    }

    public void setXzId(Integer xzId) {
        this.xzId = xzId;
    }

    public Integer getShId() {
        return shId;
    }

    public void setShId(Integer shId) {
        this.shId = shId;
    }

    public String getWanJieUrls() {
        return wanJieUrls;
    }

    public void setWanJieUrls(String wanJieUrls) {
        this.wanJieUrls = wanJieUrls;
    }

    public String getWanJieRemark() {
        return wanJieRemark;
    }

    public void setWanJieRemark(String wanJieRemark) {
        this.wanJieRemark = wanJieRemark;
    }
}
