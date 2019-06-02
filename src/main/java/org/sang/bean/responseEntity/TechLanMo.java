package org.sang.bean.responseEntity;

import org.sang.bean.LanMo;
import org.sang.bean.TechCard;

import java.util.List;

public class TechLanMo  extends TechCard{

    private List<LanMo> lanMoList;

    public List<LanMo> getLanMoList() {
        return lanMoList;
    }

    public void setLanMoList(List<LanMo> lanMoList) {
        this.lanMoList = lanMoList;
    }
}
