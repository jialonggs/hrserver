package org.sang.bean.requestEntity;

import org.sang.bean.ProcessUnit;

import java.util.List;

public class UnitRequest  extends ProcessUnit{
    private Long[] carIds;

    public Long[] getCarIds() {
        return carIds;
    }

    public void setCarIds(Long[] carIds) {
        this.carIds = carIds;
    }
}
