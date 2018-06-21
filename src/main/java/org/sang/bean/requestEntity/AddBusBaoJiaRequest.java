package org.sang.bean.requestEntity;

import org.sang.bean.BusinessBaoJia;
import org.sang.bean.BusinessProduct;

import java.util.List;

public class AddBusBaoJiaRequest {
    BusinessBaoJia businessBaoJia;
    List<BusinessProduct> businessProductList;

    public BusinessBaoJia getBusinessBaoJia() {
        return businessBaoJia;
    }

    public void setBusinessBaoJia(BusinessBaoJia businessBaoJia) {
        this.businessBaoJia = businessBaoJia;
    }

    public List<BusinessProduct> getBusinessProductList() {
        return businessProductList;
    }

    public void setBusinessProductList(List<BusinessProduct> businessProductList) {
        this.businessProductList = businessProductList;
    }
}
