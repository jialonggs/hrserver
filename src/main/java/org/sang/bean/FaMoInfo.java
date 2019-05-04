package org.sang.bean;

import java.util.Date;

public class FaMoInfo {

    private Long id;
    private String chePai;
    private String jiaShiYuan;
    private Boolean kuaiDi;
    private Boolean muXiang;
    private Boolean zhuanChe;
    private Boolean huoYun;
    private String ids;
    private String picUrls;

    private String addUserId;
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

    public String getChePai() {
        return chePai;
    }

    public void setChePai(String chePai) {
        this.chePai = chePai;
    }

    public String getJiaShiYuan() {
        return jiaShiYuan;
    }

    public void setJiaShiYuan(String jiaShiYuan) {
        this.jiaShiYuan = jiaShiYuan;
    }

    public Boolean getKuaiDi() {
        return kuaiDi;
    }

    public void setKuaiDi(Boolean kuaiDi) {
        this.kuaiDi = kuaiDi;
    }

    public Boolean getMuXiang() {
        return muXiang;
    }

    public void setMuXiang(Boolean muXiang) {
        this.muXiang = muXiang;
    }

    public Boolean getZhuanChe() {
        return zhuanChe;
    }

    public void setZhuanChe(Boolean zhuanChe) {
        this.zhuanChe = zhuanChe;
    }

    public Boolean getHuoYun() {
        return huoYun;
    }

    public void setHuoYun(Boolean huoYun) {
        this.huoYun = huoYun;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
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
}
