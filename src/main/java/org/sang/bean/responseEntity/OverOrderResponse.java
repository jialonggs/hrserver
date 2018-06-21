package org.sang.bean.responseEntity;

import org.sang.bean.Order;
import org.sang.bean.QualityOrderUser;

import java.util.List;

public class OverOrderResponse extends Order{
    List<QualityOrderUser> qualityOrderUsers;

    public List<QualityOrderUser> getQualityOrderUsers() {
        return qualityOrderUsers;
    }

    public void setQualityOrderUsers(List<QualityOrderUser> qualityOrderUsers) {
        this.qualityOrderUsers = qualityOrderUsers;
    }
}
