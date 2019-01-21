package org.sang.bean;

import java.util.Date;

public class Project {
    private Long id;
    private Long unitId;
    private Long carId;
    private String projectName;
    private String cilentCompanyName;

    private Integer financeStatus;
    private String financeBiLi;
    private String financeJinE;
    private Date financeTime;
    private String financeRemark;
    private Long financeId;
    private Integer kaiPiaoStatus;
    private Long kaiPiaoId;
    private Double needKaiPiao;
    private Double kaiPiaoMoney;

    private Long addUserId;
    private String addUserName;
    private Date finishTime;
    private String status;
    private String remark;
    private Boolean isDeleted;
    private Date updateTime;
    private Date createTime;
    private Integer busStatus;

    private Car car;
    private ProcessUnit processUnit;


    public Double getNeedKaiPiao() {
        return needKaiPiao;
    }

    public void setNeedKaiPiao(Double needKaiPiao) {
        this.needKaiPiao = needKaiPiao;
    }

    public Double getKaiPiaoMoney() {
        return kaiPiaoMoney;
    }

    public void setKaiPiaoMoney(Double kaiPiaoMoney) {
        this.kaiPiaoMoney = kaiPiaoMoney;
    }

    public Integer getBusStatus() {
        return busStatus;
    }

    public void setBusStatus(Integer busStatus) {
        this.busStatus = busStatus;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCilentCompanyName() {
        return cilentCompanyName;
    }

    public void setCilentCompanyName(String cilentCompanyName) {
        this.cilentCompanyName = cilentCompanyName;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFinanceStatus() {
        return financeStatus;
    }

    public void setFinanceStatus(Integer financeStatus) {
        this.financeStatus = financeStatus;
    }

    public String getFinanceBiLi() {
        return financeBiLi;
    }

    public void setFinanceBiLi(String financeBiLi) {
        this.financeBiLi = financeBiLi;
    }

    public String getFinanceJinE() {
        return financeJinE;
    }

    public void setFinanceJinE(String financeJinE) {
        this.financeJinE = financeJinE;
    }

    public Date getFinanceTime() {
        return financeTime;
    }

    public void setFinanceTime(Date financeTime) {
        this.financeTime = financeTime;
    }

    public String getFinanceRemark() {
        return financeRemark;
    }

    public void setFinanceRemark(String financeRemark) {
        this.financeRemark = financeRemark;
    }

    public Long getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Long financeId) {
        this.financeId = financeId;
    }

    public Integer getKaiPiaoStatus() {
        return kaiPiaoStatus;
    }

    public void setKaiPiaoStatus(Integer kaiPiaoStatus) {
        this.kaiPiaoStatus = kaiPiaoStatus;
    }

    public Long getKaiPiaoId() {
        return kaiPiaoId;
    }

    public void setKaiPiaoId(Long kaiPiaoId) {
        this.kaiPiaoId = kaiPiaoId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ProcessUnit getProcessUnit() {
        return processUnit;
    }

    public void setProcessUnit(ProcessUnit processUnit) {
        this.processUnit = processUnit;
    }
}
