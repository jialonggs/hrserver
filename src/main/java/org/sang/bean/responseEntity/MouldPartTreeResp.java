package org.sang.bean.responseEntity;


import java.util.List;

public class MouldPartTreeResp {
    public String id;
    public String label;
    public List<MouldPartChildrenResp> children;
    public Boolean disabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<MouldPartChildrenResp> getChildren() {
        return children;
    }

    public void setChildren(List<MouldPartChildrenResp> children) {
        this.children = children;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
