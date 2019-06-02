package org.sang.bean.responseEntity;

import org.sang.bean.Project;
import org.sang.bean.YuBaoJia;
import org.sang.bean.YuProduct;

import java.util.List;

public class YuBaoJiaInfoResp extends YuBaoJia{
    private List<YuProduct> yuProductList;
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<YuProduct> getYuProductList() {
        return yuProductList;
    }

    public void setYuProductList(List<YuProduct> yuProductList) {
        this.yuProductList = yuProductList;
    }
}
