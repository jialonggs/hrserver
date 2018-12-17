package org.sang.bean.responseEntity;

import org.sang.bean.Order;
import org.sang.bean.Project;
import org.sang.bean.TechCard;
import org.sang.bean.WenLi;

import java.util.List;

public class CountOrderResp extends Order{

    private Project project;

    public List<WenLi> wenlis;
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
