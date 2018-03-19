package org.sang.bean.responseEntity;

import org.sang.bean.CaiMoList;
import org.sang.bean.MouldInfo;

public class CaiMoListResp extends CaiMoList{

    private MouldInfo mouldInfo;

    public MouldInfo getMouldInfo() {
        return mouldInfo;
    }

    public void setMouldInfo(MouldInfo mouldInfo) {
        this.mouldInfo = mouldInfo;
    }
}
