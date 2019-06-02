package org.sang.bean.requestEntity;

public class YgaRquest {
    private Long userId;
    private String userName;
    private Double biLi;
    private Double allTieHuaArea;
    private Double oneceTieHuaArea;
    private Double jingFengArea;
    private Double orderNeedArea;
    private Double jingFengBiLi;
    private String addUserId;
    private String addUserName;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Double getAllTieHuaArea() {
        return allTieHuaArea;
    }

    public void setAllTieHuaArea(Double allTieHuaArea) {
        this.allTieHuaArea = allTieHuaArea;
    }

    public Double getOneceTieHuaArea() {
        return oneceTieHuaArea;
    }

    public void setOneceTieHuaArea(Double oneceTieHuaArea) {
        this.oneceTieHuaArea = oneceTieHuaArea;
    }

    public Double getJingFengArea() {
        return jingFengArea;
    }

    public void setJingFengArea(Double jingFengArea) {
        this.jingFengArea = jingFengArea;
    }

    public Double getOrderNeedArea() {
        return orderNeedArea;
    }

    public void setOrderNeedArea(Double orderNeedArea) {
        this.orderNeedArea = orderNeedArea;
    }

    public Double getBiLi() {
        return biLi;
    }

    public void setBiLi(Double biLi) {
        this.biLi = biLi;
    }

    public Double getJingFengBiLi() {
        return jingFengBiLi;
    }

    public void setJingFengBiLi(Double jingFengBiLi) {
        this.jingFengBiLi = jingFengBiLi;
    }

    @Override
    public String toString() {
        return "YgaRquest{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", biLi=" + biLi +
                ", allTieHuaArea=" + allTieHuaArea +
                ", oneceTieHuaArea=" + oneceTieHuaArea +
                ", jingFengArea=" + jingFengArea +
                ", orderNeedArea=" + orderNeedArea +
                '}';
    }
}
