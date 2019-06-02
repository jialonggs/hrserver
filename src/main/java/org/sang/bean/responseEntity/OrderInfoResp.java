package org.sang.bean.responseEntity;

import org.sang.bean.*;

import java.util.List;

public class OrderInfoResp extends Order{

    private List<MouldInfo> mouldInfoList;
    private ControlOrderFrom controlOrderFrom;
    private List<TechCard> techCardList;
//    private TechCard techCard;
    private Project project;
    private List<QualityOrderUser> qualityOrderUsers;
    private List<UserOrder> orderUsers;
    private OrderFlow orderFlow;

    private List<LanMo> lanMoList;

    public List<MouldInfo> getMouldInfoList() {
        return mouldInfoList;
    }

    public void setMouldInfoList(List<MouldInfo> mouldInfoList) {
        this.mouldInfoList = mouldInfoList;
    }

    public ControlOrderFrom getControlOrderFrom() {
        return controlOrderFrom;
    }

    public void setControlOrderFrom(ControlOrderFrom controlOrderFrom) {
        this.controlOrderFrom = controlOrderFrom;
    }



    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<QualityOrderUser> getQualityOrderUsers() {
        return qualityOrderUsers;
    }

    public void setQualityOrderUsers(List<QualityOrderUser> qualityOrderUsers) {
        this.qualityOrderUsers = qualityOrderUsers;
    }

    public List<UserOrder> getOrderUsers() {
        return orderUsers;
    }

    public void setOrderUsers(List<UserOrder> orderUsers) {
        this.orderUsers = orderUsers;
    }


    public OrderFlow getOrderFlow() {
        return orderFlow;
    }

    public void setOrderFlow(OrderFlow orderFlow) {
        this.orderFlow = orderFlow;
    }

    public List<TechCard> getTechCardList() {
        return techCardList;
    }

    public void setTechCardList(List<TechCard> techCardList) {
        this.techCardList = techCardList;
    }

    public List<LanMo> getLanMoList() {
        return lanMoList;
    }

    public void setLanMoList(List<LanMo> lanMoList) {
        this.lanMoList = lanMoList;
    }
}
