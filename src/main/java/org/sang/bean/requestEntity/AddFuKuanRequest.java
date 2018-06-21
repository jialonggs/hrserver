package org.sang.bean.requestEntity;

import java.util.Date;

public class AddFuKuanRequest {

    private Long projectId;
    private String financeJinE;
    private String financeBiLi;
    private Date financeTime;
    private String financeRemark;
    private Integer financeStatus;

    public String getFinanceJinE() {
        return financeJinE;
    }

    public void setFinanceJinE(String financeJinE) {
        this.financeJinE = financeJinE;
    }

    public String getFinanceBiLi() {
        return financeBiLi;
    }

    public void setFinanceBiLi(String financeBiLi) {
        this.financeBiLi = financeBiLi;
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getFinanceStatus() {
        return financeStatus;
    }

    public void setFinanceStatus(Integer financeStatus) {
        this.financeStatus = financeStatus;
    }
}
