package org.sang.bean.responseEntity;

import org.sang.bean.Order;
import org.sang.bean.TechCard;
import org.sang.bean.WenLi;

public class TechAdded extends TechCard{

    private WenLi wenli;

    private Order order;

    public WenLi getWenli() {
        return wenli;
    }

    public void setWenli(WenLi wenli) {
        this.wenli = wenli;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
