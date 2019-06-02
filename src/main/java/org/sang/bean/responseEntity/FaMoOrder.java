package org.sang.bean.responseEntity;

import org.sang.bean.Order;
import org.sang.bean.Project;
import org.sang.bean.QualityOrderUser;

import java.util.List;

public class FaMoOrder extends Order{
   // private Project project;
    private ProjectListResp project;

    private List<QualityOrderUser> qualityOrderUsers;

    public List<QualityOrderUser> getQualityOrderUsers() {
        return qualityOrderUsers;
    }

    public void setQualityOrderUsers(List<QualityOrderUser> qualityOrderUsers) {
        this.qualityOrderUsers = qualityOrderUsers;
    }

    public ProjectListResp getProject() {
        return project;
    }

    public void setProject(ProjectListResp project) {
        this.project = project;
    }
}
