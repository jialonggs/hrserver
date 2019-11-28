package org.sang.bean;

import java.util.Date;

public class MouldInfo {
    private Long id;
    private String mouldName;
    private Integer mouldNum;
    private String picUrls;
    private Boolean isSelected;
    private Long selectId;
    private Long orderId;
    private Integer shouMoId;
    private Boolean caiStatus;

    private Long addUserId;
    private String addUserName;
    private String status;
    private String remark;
    private Boolean isDeleted;
    private Date updateTime;
    private Date createTime;

    public Boolean getCaiStatus() {
        return caiStatus;
    }

    public void setCaiStatus(Boolean caiStatus) {
        this.caiStatus = caiStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMouldName() {
        return mouldName;
    }

    public void setMouldName(String mouldName) {
        this.mouldName = mouldName;
    }

    public Integer getMouldNum() {
        return mouldNum;
    }

    public void setMouldNum(Integer mouldNum) {
        this.mouldNum = mouldNum;
    }

    public String getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String picUrls) {
        this.picUrls = picUrls;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public Long getSelectId() {
        return selectId;
    }

    public void setSelectId(Long selectId) {
        this.selectId = selectId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getShouMoId() {
        return shouMoId;
    }

    public void setShouMoId(Integer shouMoId) {
        this.shouMoId = shouMoId;
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
}


