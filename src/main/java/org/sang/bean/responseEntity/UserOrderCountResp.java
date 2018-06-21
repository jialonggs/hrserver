package org.sang.bean.responseEntity;

import org.sang.bean.FaMo;
import org.sang.bean.UserOrder;

public class UserOrderCountResp extends UserOrder{

    private CountOrderResp orderInfo;

    public CountOrderResp getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(CountOrderResp orderInfo) {
        this.orderInfo = orderInfo;
    }
}
