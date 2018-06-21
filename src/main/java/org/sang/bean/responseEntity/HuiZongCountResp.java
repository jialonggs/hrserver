package org.sang.bean.responseEntity;

public class HuiZongCountResp {
    private  Long userId;
    private  String userName;
    private  Double workTime;
    private  Double lastMonthArge;
    private  Double currentMonthNeedArge;
    private  Double currentMonthFinishArge;
    private  Double currentMonthArge;
    private  Double currentMonthShenYuArge;
    private  Double efficiency;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Double workTime) {
        this.workTime = workTime;
    }

    public Double getLastMonthArge() {
        return lastMonthArge;
    }

    public void setLastMonthArge(Double lastMonthArge) {
        this.lastMonthArge = lastMonthArge;
    }

    public Double getCurrentMonthNeedArge() {
        return currentMonthNeedArge;
    }

    public void setCurrentMonthNeedArge(Double currentMonthNeedArge) {
        this.currentMonthNeedArge = currentMonthNeedArge;
    }

    public Double getCurrentMonthFinishArge() {
        return currentMonthFinishArge;
    }

    public void setCurrentMonthFinishArge(Double currentMonthFinishArge) {
        this.currentMonthFinishArge = currentMonthFinishArge;
    }

    public Double getCurrentMonthArge() {
        return currentMonthArge;
    }

    public void setCurrentMonthArge(Double currentMonthArge) {
        this.currentMonthArge = currentMonthArge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Double efficiency) {
        this.efficiency = efficiency;
    }

    public Double getCurrentMonthShenYuArge() {
        return currentMonthShenYuArge;
    }

    public void setCurrentMonthShenYuArge(Double currentMonthShenYuArge) {
        this.currentMonthShenYuArge = currentMonthShenYuArge;
    }
}
