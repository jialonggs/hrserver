package org.sang.bean;

import java.util.Date;

public class FaMo {
    private Long id;
    private Long orderId;
    private String orderName;
    private String faMoRemark;
    private Integer faMoType;
    private Integer auditId;
    private String  auditName;
    private Integer faMoNum;
    private Integer liuChangNum;
    private Boolean liuChang;
    private String driverPhone;
    private String chePai;
    private Integer cheJian;

    private Integer infoId;

    private Integer auditJingId;
    private String  auditJingName;
    private String addUserId;
    private String addUserName;
    private String status;
    private String remark;
    private Boolean isDeleted;
    private Date updateTime;
    private Date createTime;


    public Integer getCheJian() {
        return cheJian;
    }

    public void setCheJian(Integer cheJian) {
        this.cheJian = cheJian;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getChePai() {
        return chePai;
    }

    public void setChePai(String chePai) {
        this.chePai = chePai;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getFaMoType() {
        return faMoType;
    }

    public void setFaMoType(Integer faMoType) {
        this.faMoType = faMoType;
    }

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

    public String getFaMoRemark() {
        return faMoRemark;
    }

    public void setFaMoRemark(String faMoRemark) {
        this.faMoRemark = faMoRemark;
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

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public Integer getFaMoNum() {
        return faMoNum;
    }

    public void setFaMoNum(Integer faMoNum) {
        this.faMoNum = faMoNum;
    }

    public Integer getLiuChangNum() {
        return liuChangNum;
    }

    public void setLiuChangNum(Integer liuChangNum) {
        this.liuChangNum = liuChangNum;
    }

    public Boolean getLiuChang() {
        return liuChang;
    }

    public void setLiuChang(Boolean liuChang) {
        this.liuChang = liuChang;
    }

    public Integer getAuditJingId() {
        return auditJingId;
    }

    public void setAuditJingId(Integer auditJingId) {
        this.auditJingId = auditJingId;
    }

    public String getAuditJingName() {
        return auditJingName;
    }

    public void setAuditJingName(String auditJingName) {
        this.auditJingName = auditJingName;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }
}
