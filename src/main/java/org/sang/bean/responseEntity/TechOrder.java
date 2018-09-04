package org.sang.bean.responseEntity;

import org.sang.bean.*;

import java.util.List;

public class TechOrder  extends Order{

    private List<MouldInfo> mouldInfoList;
    private ControlOrderFrom controlOrderFrom;
    private Project project;
    private List<WenLi> wenlis;

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

    @Override
    public List<WenLi> getWenlis() {
        return wenlis;
    }

    @Override
    public void setWenlis(List<WenLi> wenlis) {
        this.wenlis = wenlis;
    }
}
