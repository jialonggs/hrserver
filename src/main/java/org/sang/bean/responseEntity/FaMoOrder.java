package org.sang.bean.responseEntity;

import org.sang.bean.Order;
import org.sang.bean.Project;

public class FaMoOrder extends Order{
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
