package org.sang.bean.responseEntity;

import org.sang.bean.BusinessBaoJia;
import org.sang.bean.BusinessProduct;
import org.sang.bean.Project;

import java.util.List;

public class BusInfoResp extends BusinessBaoJia{
    private List<BusinessProduct> businessProductList;
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<BusinessProduct> getBusinessProductList() {
        return businessProductList;
    }

    public void setBusinessProductList(List<BusinessProduct> businessProductList) {
        this.businessProductList = businessProductList;
    }
}
