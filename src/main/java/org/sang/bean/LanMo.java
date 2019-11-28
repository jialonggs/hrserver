package org.sang.bean;

import java.util.Date;

public class LanMo {
    private Long id;
    private Long techId;
    private Long orderId;
    private Date beginTime;
    private Date lanMoTime;
    private String yaoShui;
    private String shenDu;
    private String needLanMoTime;
    private String lanMoTimeFen;
    private String lanMoTimeMiao;
    private String caoZuoRen;

    private String addUserId;
    private String addUserName;
    private String status;
    private String remark;
    private Boolean isDeleted;
    private Date updateTime;
    private Date createTime;


    public String getCaoZuoRen() {
        return caoZuoRen;
    }

    public void setCaoZuoRen(String caoZuoRen) {
        this.caoZuoRen = caoZuoRen;
    }

    public String getNeedLanMoTime() {
        return needLanMoTime;
    }

    public void setNeedLanMoTime(String needLanMoTime) {
        this.needLanMoTime = needLanMoTime;
    }

    public String getLanMoTimeFen() {
        return lanMoTimeFen;
    }

    public void setLanMoTimeFen(String lanMoTimeFen) {
        this.lanMoTimeFen = lanMoTimeFen;
    }

    public String getLanMoTimeMiao() {
        return lanMoTimeMiao;
    }

    public void setLanMoTimeMiao(String lanMoTimeMiao) {
        this.lanMoTimeMiao = lanMoTimeMiao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTechId() {
        return techId;
    }

    public void setTechId(Long techId) {
        this.techId = techId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getLanMoTime() {
        return lanMoTime;
    }

    public void setLanMoTime(Date lanMoTime) {
        this.lanMoTime = lanMoTime;
    }

    public String getYaoShui() {
        return yaoShui;
    }

    public void setYaoShui(String yaoShui) {
        this.yaoShui = yaoShui;
    }

    public String getShenDu() {
        return shenDu;
    }

    public void setShenDu(String shenDu) {
        this.shenDu = shenDu;
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
