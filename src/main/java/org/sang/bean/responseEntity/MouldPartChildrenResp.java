package org.sang.bean.responseEntity;

import java.util.List;

public class MouldPartChildrenResp {
    public Long id;
    public String label;
    public List<TreeMouldInfoResp> children;
    public Boolean disabled;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<TreeMouldInfoResp> getChildren() {
        return children;
    }

    public void setChildren(List<TreeMouldInfoResp> children) {
        this.children = children;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
