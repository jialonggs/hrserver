package org.sang.bean.responseEntity;

import org.sang.bean.Order;
import org.sang.bean.QualityOrderUser;
import org.sang.bean.UserOrder;

import java.util.List;

public class QualityOrderResp extends QualityOrderUser{
    private Boolean isHaveAuth;
    private Order order;

    private List<UserOrder> orderUsers;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<UserOrder> getOrderUsers() {
        return orderUsers;
    }

    public void setOrderUsers(List<UserOrder> orderUsers) {
        this.orderUsers = orderUsers;
    }

    public Boolean getHaveAuth() {
        return isHaveAuth;
    }

    public void setHaveAuth(Boolean haveAuth) {
        isHaveAuth = haveAuth;
    }
}
