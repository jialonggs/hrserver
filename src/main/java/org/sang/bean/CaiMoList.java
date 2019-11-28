package org.sang.bean;

import java.util.Date;

public class CaiMoList {

    private Long id;
    private Long mouldId;
    private Integer youSiWenNum;
    private Integer wuSiWenNum;
    private String picUrls;
    private Long addUserId;
    private String addUserName;
    private String status;
    private String remark;
    private Boolean isDeleted;
    private Date updateTime;
    private Date createTime;


    public String getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String picUrls) {
        this.picUrls = picUrls;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMouldId() {
        return mouldId;
    }

    public void setMouldId(Long mouldId) {
        this.mouldId = mouldId;
    }

    public Integer getYouSiWenNum() {
        return youSiWenNum;
    }

    public void setYouSiWenNum(Integer youSiWenNum) {
        this.youSiWenNum = youSiWenNum;
    }

    public Integer getWuSiWenNum() {
        return wuSiWenNum;
    }

    public void setWuSiWenNum(Integer wuSiWenNum) {
        this.wuSiWenNum = wuSiWenNum;
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
