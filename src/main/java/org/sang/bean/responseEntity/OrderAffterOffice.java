package org.sang.bean.responseEntity;

import org.sang.bean.Order;
import org.sang.bean.ShouHou;

public class OrderAffterOffice extends Order{

    private ShouHou shouHou;


    public ShouHou getShouHou() {
        return shouHou;
    }

    public void setShouHou(ShouHou shouHou) {
        this.shouHou = shouHou;
    }
}
