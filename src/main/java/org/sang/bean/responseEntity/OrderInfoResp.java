package org.sang.bean.responseEntity;

import org.sang.bean.*;

import java.util.List;

public class OrderInfoResp extends Order{

    private List<MouldInfo> mouldInfoList;
    private ControlOrderFrom controlOrderFrom;
    private TechCard techCard;
    private Project project;

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

    public TechCard getTechCard() {
        return techCard;
    }

    public void setTechCard(TechCard techCard) {
        this.techCard = techCard;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
