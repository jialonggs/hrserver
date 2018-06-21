package org.sang.bean.responseEntity;

import org.sang.bean.FaMo;
import org.sang.bean.Order;

public class FaMoResponse extends FaMo{

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
