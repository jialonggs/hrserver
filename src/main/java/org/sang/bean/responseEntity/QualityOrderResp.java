package org.sang.bean.responseEntity;

import org.sang.bean.Order;
import org.sang.bean.QualityOrderUser;

public class QualityOrderResp extends QualityOrderUser{
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
