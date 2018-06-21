package org.sang.bean.responseEntity;

import org.sang.bean.Order;
import org.sang.bean.Project;
import org.sang.bean.TechCard;

public class CountOrderResp extends Order{

    private Project project;

    private TechCard techCard;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public TechCard getTechCard() {
        return techCard;
    }

    public void setTechCard(TechCard techCard) {
        this.techCard = techCard;
    }
}
