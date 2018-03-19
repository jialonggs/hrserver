package org.sang.bean;

import java.util.Date;

public class Order {

    private Long id;
    private String orderName;
    private String qrCode;
    private Integer projectId;
    private Integer technologyId;
    private Integer managerId;
    private String managerName;
    private String expected;
    private Integer urgency;
    private Boolean hasRemark;
    private String machiningType;
    private Double realityArea;
    private Double stayArea;
    private Double alreadyArea;
    private Double perfectArea;
    private Double appliqueArea;
    private Boolean ygb;
    private String picUrls;
    private Date finishTime;

    private String addUserId;
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

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Integer technologyId) {
        this.technologyId = technologyId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
    }

    public Boolean getHasRemark() {
        return hasRemark;
    }

    public void setHasRemark(Boolean hasRemark) {
        this.hasRemark = hasRemark;
    }

    public String getMachiningType() {
        return machiningType;
    }

    public void setMachiningType(String machiningType) {
        this.machiningType = machiningType;
    }

    public Double getRealityArea() {
        return realityArea;
    }

    public void setRealityArea(Double realityArea) {
        this.realityArea = realityArea;
    }

    public Double getStayArea() {
        return stayArea;
    }

    public void setStayArea(Double stayArea) {
        this.stayArea = stayArea;
    }

    public Double getAlreadyArea() {
        return alreadyArea;
    }

    public void setAlreadyArea(Double alreadyArea) {
        this.alreadyArea = alreadyArea;
    }

    public Double getPerfectArea() {
        return perfectArea;
    }

    public void setPerfectArea(Double perfectArea) {
        this.perfectArea = perfectArea;
    }

    public Double getAppliqueArea() {
        return appliqueArea;
    }

    public void setAppliqueArea(Double appliqueArea) {
        this.appliqueArea = appliqueArea;
    }

    public Boolean getYgb() {
        return ygb;
    }

    public void setYgb(Boolean ygb) {
        this.ygb = ygb;
    }

    public String getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String picUrls) {
        this.picUrls = picUrls;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
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

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

}
