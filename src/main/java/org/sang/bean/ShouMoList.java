package org.sang.bean;





import java.util.Date;


public class ShouMoList {

    private Long id;
    private String clientCompanyName;
    private String batch;
    private String freightType;
    private Integer woodenCaseNum;
    private Integer palletNum;
    private Integer diaoHuanNum;
    private Boolean jianBao;
    private String carNum;
    private String driverPhone;
    private Long addUserId;
    private String addUserName;
    private String status;
    private String remark;
    private Boolean isDeleted;
    private Date updateTime;
    private Date createTime;
    private Date trueTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientCompanyName() {
        return clientCompanyName;
    }

    public void setClientCompanyName(String clientCompanyName) {
        this.clientCompanyName = clientCompanyName;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getFreightType() {
        return freightType;
    }

    public void setFreightType(String freightType) {
        this.freightType = freightType;
    }

    public Integer getWoodenCaseNum() {
        return woodenCaseNum;
    }

    public void setWoodenCaseNum(Integer woodenCaseNum) {
        this.woodenCaseNum = woodenCaseNum;
    }

    public Integer getPalletNum() {
        return palletNum;
    }

    public void setPalletNum(Integer palletNum) {
        this.palletNum = palletNum;
    }

    public Integer getDiaoHuanNum() {
        return diaoHuanNum;
    }

    public void setDiaoHuanNum(Integer diaoHuanNum) {
        this.diaoHuanNum = diaoHuanNum;
    }

    public Boolean getJianBao() {
        return jianBao;
    }

    public void setJianBao(Boolean jianBao) {
        this.jianBao = jianBao;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
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

    public Date getTrueTime() {
        return trueTime;
    }

    public void setTrueTime(Date trueTime) {
        this.trueTime = trueTime;
    }
}
