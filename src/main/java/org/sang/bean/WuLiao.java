package org.sang.bean;

import java.util.Date;

public class WuLiao {

    private Long id;
    private Long orderId;
    private String orderName;
    private String wuLiaoName;
    private String wuLiaoNum;
    private Integer status;
    private Long principalUserId;
    private String principalUserName;
    private Date haveTime;
    private String liaoJiang;
    private Date songTime;
    private Date yinTime;


    private String addUserId;
    private String addUserName;
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

    public String getWuLiaoName() {
        return wuLiaoName;
    }

    public void setWuLiaoName(String wuLiaoName) {
        this.wuLiaoName = wuLiaoName;
    }

    public String getWuLiaoNum() {
        return wuLiaoNum;
    }

    public void setWuLiaoNum(String wuLiaoNum) {
        this.wuLiaoNum = wuLiaoNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getPrincipalUserId() {
        return principalUserId;
    }

    public void setPrincipalUserId(Long principalUserId) {
        this.principalUserId = principalUserId;
    }

    public String getPrincipalUserName() {
        return principalUserName;
    }

    public void setPrincipalUserName(String principalUserName) {
        this.principalUserName = principalUserName;
    }

    public Date getHaveTime() {
        return haveTime;
    }

    public void setHaveTime(Date haveTime) {
        this.haveTime = haveTime;
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

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getLiaoJiang() {
        return liaoJiang;
    }

    public void setLiaoJiang(String liaoJiang) {
        this.liaoJiang = liaoJiang;
    }

    public Date getSongTime() {
        return songTime;
    }

    public void setSongTime(Date songTime) {
        this.songTime = songTime;
    }

    public Date getYinTime() {
        return yinTime;
    }

    public void setYinTime(Date yinTime) {
        this.yinTime = yinTime;
    }
}
