package org.sang.bean.responseEntity;

import org.sang.bean.FaMo;
import org.sang.bean.Order;

public class FaMoResponse extends FaMo{

    private OrderAndProject order;

    public OrderAndProject getOrder() {
        return order;
    }

    public void setOrder(OrderAndProject order) {
        this.order = order;
    }
}
