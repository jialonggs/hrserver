package org.sang.bean;

import java.util.Date;

public class TechCard {
    private Long id;
    private Long orderId;
    private String piWenDaiMa;
    private String nanDuXiShu;
    private Integer tieHuaBuShu;
    private String gongYiCanShu;
    private String guangZhe;
    private String chaiLiao;
    private String tiaoZheng;


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

    public String getPiWenDaiMa() {
        return piWenDaiMa;
    }

    public void setPiWenDaiMa(String piWenDaiMa) {
        this.piWenDaiMa = piWenDaiMa;
    }

    public String getNanDuXiShu() {
        return nanDuXiShu;
    }

    public void setNanDuXiShu(String nanDuXiShu) {
        this.nanDuXiShu = nanDuXiShu;
    }

    public Integer getTieHuaBuShu() {
        return tieHuaBuShu;
    }

    public void setTieHuaBuShu(Integer tieHuaBuShu) {
        this.tieHuaBuShu = tieHuaBuShu;
    }

    public String getGongYiCanShu() {
        return gongYiCanShu;
    }

    public void setGongYiCanShu(String gongYiCanShu) {
        this.gongYiCanShu = gongYiCanShu;
    }

    public String getGuangZhe() {
        return guangZhe;
    }

    public void setGuangZhe(String guangZhe) {
        this.guangZhe = guangZhe;
    }

    public String getChaiLiao() {
        return chaiLiao;
    }

    public void setChaiLiao(String chaiLiao) {
        this.chaiLiao = chaiLiao;
    }

    public String getTiaoZheng() {
        return tiaoZheng;
    }

    public void setTiaoZheng(String tiaoZheng) {
        this.tiaoZheng = tiaoZheng;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
