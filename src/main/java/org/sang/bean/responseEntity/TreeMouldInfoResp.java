package org.sang.bean.responseEntity;


import org.sang.bean.MouldInfo;

public class TreeMouldInfoResp {
    public Long id;
    public String label;
    public MouldInfo collectPartinfoEntity;
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

    public MouldInfo getCollectPartinfoEntity() {
        return collectPartinfoEntity;
    }

    public void setCollectPartinfoEntity(MouldInfo collectPartinfoEntity) {
        this.collectPartinfoEntity = collectPartinfoEntity;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
