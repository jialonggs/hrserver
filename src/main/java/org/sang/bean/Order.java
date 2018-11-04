package org.sang.bean;

import java.util.Date;
import java.util.List;

public class Order {

    private Long id;
    private String orderName;
    private String qrCode;
    private String beiShu;
    private Integer projectId;
    private Integer technologyId;
    private Long managerId;
    private String managerName;
    private String expected;
    private Date expectedTime;
    private Integer presentStepId;
    private String presentStepName;
    private Double presentSchedule;
    private String clientCompanyName;
    private Integer urgency;
    private Boolean hasRemark;
    private String machiningType;
    private Double realityArea;
    private Double workArea;
    private Double stayArea;
    private Double alreadyArea;
    private Double perfectArea;
    private Double appliqueArea;
    private Boolean ygb;
    private String picUrls;
    private Date finishTime;
    private Boolean techId;
    private Boolean yaoJian;
    private Integer plantStatus;
    private Integer liuChengStatus;
    private String kuFangRemark;
    private Integer liuZhuanStatus;
    private Double liuZhuanArea;
    private Double liuZhuanBiLi;
    private String nanDuDengJi;

    private String piWenDaiMa;

    private Integer jingFengStatus;
    private Integer storageStatus;
    private Integer financeStatus;
    private String financeBiLi;
    private String financeJinE;
    private Date financeTime;
    private String financeRemark;

    private Integer faMoStatus;

    private String addUserId;
    private String addUserName;
    private String status;
    private String remark;
    private Boolean isDeleted;
    private Date storageTime;
    private Date updateTime;
    private Date createTime;
    private Integer techNum;
    private List<WenLi> wenlis;
    private Integer afterStatus;


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

    public Boolean getTechId() {
        return techId;
    }

    public void setTechId(Boolean techId) {
        this.techId = techId;
    }

    public Boolean getYaoJian() {
        return yaoJian;
    }

    public void setYaoJian(Boolean yaoJian) {
        this.yaoJian = yaoJian;
    }

    public Integer getPresentStepId() {
        return presentStepId;
    }

    public void setPresentStepId(Integer presentStepId) {
        this.presentStepId = presentStepId;
    }

    public String getPresentStepName() {
        return presentStepName;
    }

    public void setPresentStepName(String presentStepName) {
        this.presentStepName = presentStepName;
    }

    public Double getPresentSchedule() {
        return presentSchedule;
    }

    public void setPresentSchedule(Double presentSchedule) {
        this.presentSchedule = presentSchedule;
    }

    public String getClientCompanyName() {
        return clientCompanyName;
    }

    public void setClientCompanyName(String clientCompanyName) {
        this.clientCompanyName = clientCompanyName;
    }

    public Integer getPlantStatus() {
        return plantStatus;
    }

    public void setPlantStatus(Integer plantStatus) {
        this.plantStatus = plantStatus;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Double getWorkArea() {
        return workArea;
    }

    public void setWorkArea(Double workArea) {
        this.workArea = workArea;
    }

    public String getBeiShu() {
        return beiShu;
    }

    public void setBeiShu(String beiShu) {
        this.beiShu = beiShu;
    }

    public Date getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
    }

    public Integer getLiuChengStatus() {
        return liuChengStatus;
    }

    public void setLiuChengStatus(Integer liuChengStatus) {
        this.liuChengStatus = liuChengStatus;
    }

    public String getKuFangRemark() {
        return kuFangRemark;
    }

    public void setKuFangRemark(String kuFangRemark) {
        this.kuFangRemark = kuFangRemark;
    }

    public Integer getLiuZhuanStatus() {
        return liuZhuanStatus;
    }

    public void setLiuZhuanStatus(Integer liuZhuanStatus) {
        this.liuZhuanStatus = liuZhuanStatus;
    }

    public Double getLiuZhuanArea() {
        return liuZhuanArea;
    }

    public void setLiuZhuanArea(Double liuZhuanArea) {
        this.liuZhuanArea = liuZhuanArea;
    }

    public Double getLiuZhuanBiLi() {
        return liuZhuanBiLi;
    }

    public void setLiuZhuanBiLi(Double liuZhuanBiLi) {
        this.liuZhuanBiLi = liuZhuanBiLi;
    }

    public String getNanDuDengJi() {
        return nanDuDengJi;
    }

    public void setNanDuDengJi(String nanDuDengJi) {
        this.nanDuDengJi = nanDuDengJi;
    }

    public Integer getJingFengStatus() {
        return jingFengStatus;
    }

    public void setJingFengStatus(Integer jingFengStatus) {
        this.jingFengStatus = jingFengStatus;
    }

    public Integer getStorageStatus() {
        return storageStatus;
    }

    public void setStorageStatus(Integer storageStatus) {
        this.storageStatus = storageStatus;
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

    public Integer getFaMoStatus() {
        return faMoStatus;
    }

    public void setFaMoStatus(Integer faMoStatus) {
        this.faMoStatus = faMoStatus;
    }

    public String getPiWenDaiMa() {
        return piWenDaiMa;
    }

    public void setPiWenDaiMa(String piWenDaiMa) {
        this.piWenDaiMa = piWenDaiMa;
    }

    public Date getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(Date storageTime) {
        this.storageTime = storageTime;
    }

    public List<WenLi> getWenlis() {
        return wenlis;
    }

    public void setWenlis(List<WenLi> wenlis) {
        this.wenlis = wenlis;
    }

    public Integer getTechNum() {
        return techNum;
    }

    public void setTechNum(Integer techNum) {
        this.techNum = techNum;
    }

    public Integer getAfterStatus() {
        return afterStatus;
    }

    public void setAfterStatus(Integer afterStatus) {
        this.afterStatus = afterStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", beiShu='" + beiShu + '\'' +
                ", projectId=" + projectId +
                ", technologyId=" + technologyId +
                ", managerId=" + managerId +
                ", managerName='" + managerName + '\'' +
                ", expected='" + expected + '\'' +
                ", expectedTime=" + expectedTime +
                ", presentStepId=" + presentStepId +
                ", presentStepName='" + presentStepName + '\'' +
                ", presentSchedule=" + presentSchedule +
                ", clientCompanyName='" + clientCompanyName + '\'' +
                ", urgency=" + urgency +
                ", hasRemark=" + hasRemark +
                ", machiningType='" + machiningType + '\'' +
                ", realityArea=" + realityArea +
                ", workArea=" + workArea +
                ", stayArea=" + stayArea +
                ", alreadyArea=" + alreadyArea +
                ", perfectArea=" + perfectArea +
                ", appliqueArea=" + appliqueArea +
                ", ygb=" + ygb +
                ", picUrls='" + picUrls + '\'' +
                ", finishTime=" + finishTime +
                ", techId=" + techId +
                ", yaoJian=" + yaoJian +
                ", plantStatus=" + plantStatus +
                ", liuChengStatus=" + liuChengStatus +
                ", kuFangRemark='" + kuFangRemark + '\'' +
                ", liuZhuanStatus=" + liuZhuanStatus +
                ", liuZhuanArea=" + liuZhuanArea +
                ", liuZhuanBiLi=" + liuZhuanBiLi +
                ", nanDuDengJi='" + nanDuDengJi + '\'' +
                ", piWenDaiMa='" + piWenDaiMa + '\'' +
                ", jingFengStatus=" + jingFengStatus +
                ", storageStatus=" + storageStatus +
                ", financeStatus=" + financeStatus +
                ", financeBiLi='" + financeBiLi + '\'' +
                ", financeJinE='" + financeJinE + '\'' +
                ", financeTime=" + financeTime +
                ", financeRemark='" + financeRemark + '\'' +
                ", faMoStatus=" + faMoStatus +
                ", addUserId='" + addUserId + '\'' +
                ", addUserName='" + addUserName + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", isDeleted=" + isDeleted +
                ", storageTime=" + storageTime +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", techNum=" + techNum +
                ", wenlis=" + wenlis +
                '}';
    }
}
