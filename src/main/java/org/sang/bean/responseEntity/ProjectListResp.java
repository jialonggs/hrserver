package org.sang.bean.responseEntity;

import org.sang.bean.Project;

public class ProjectListResp extends Project{

    private Long yuBaoJiaId;
    private Integer yuBaoJiaStatus;

    private Long shangWuId;
    private Integer shangWuStatus;

    private Integer orderNums;
    private Double orderSchedule;

    public Long getYuBaoJiaId() {
        return yuBaoJiaId;
    }

    public void setYuBaoJiaId(Long yuBaoJiaId) {
        this.yuBaoJiaId = yuBaoJiaId;
    }

    public Integer getYuBaoJiaStatus() {
        return yuBaoJiaStatus;
    }

    public void setYuBaoJiaStatus(Integer yuBaoJiaStatus) {
        this.yuBaoJiaStatus = yuBaoJiaStatus;
    }

    public Long getShangWuId() {
        return shangWuId;
    }

    public void setShangWuId(Long shangWuId) {
        this.shangWuId = shangWuId;
    }

    public Integer getShangWuStatus() {
        return shangWuStatus;
    }

    public void setShangWuStatus(Integer shangWuStatus) {
        this.shangWuStatus = shangWuStatus;
    }

    public Integer getOrderNums() {
        return orderNums;
    }

    public void setOrderNums(Integer orderNums) {
        this.orderNums = orderNums;
    }

    public Double getOrderSchedule() {
        return orderSchedule;
    }

    public void setOrderSchedule(Double orderSchedule) {
        this.orderSchedule = orderSchedule;
    }
}
