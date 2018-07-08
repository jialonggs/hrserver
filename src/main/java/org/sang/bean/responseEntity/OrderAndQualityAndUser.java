package org.sang.bean.responseEntity;

import org.sang.bean.Order;
import org.sang.bean.QualityOrderUser;
import org.sang.bean.UserOrder;

import java.util.List;

public class OrderAndQualityAndUser extends Order{

    private List<QualityOrderUser> qualityOrderUsers;
    private List<UserOrder> orderUsers;

    public List<QualityOrderUser> getQualityOrderUsers() {
        return qualityOrderUsers;
    }

    public void setQualityOrderUsers(List<QualityOrderUser> qualityOrderUsers) {
        this.qualityOrderUsers = qualityOrderUsers;
    }

    public List<UserOrder> getOrderUsers() {
        return orderUsers;
    }

    public void setOrderUsers(List<UserOrder> orderUsers) {
        this.orderUsers = orderUsers;
    }
}
