package org.sang.bean.responseEntity;

import org.sang.bean.*;

import java.util.List;

public class TechAdded extends TechCard{

    private WenLi wenli;

    private TechTyeOrder techTyeOrder;

    public TechTyeOrder getTechTyeOrder() {
        return techTyeOrder;
    }

    public void setTechTyeOrder(TechTyeOrder techTyeOrder) {
        this.techTyeOrder = techTyeOrder;
    }

    public WenLi getWenli() {
        return wenli;
    }

    public void setWenli(WenLi wenli) {
        this.wenli = wenli;
    }


}
