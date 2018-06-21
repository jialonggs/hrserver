package org.sang.bean.responseEntity;

import org.sang.bean.BusinessBaoJia;
import org.sang.bean.BusinessProduct;

import java.util.List;

public class BusInfoResp extends BusinessBaoJia{
    private List<BusinessProduct> businessProductList;

    public List<BusinessProduct> getBusinessProductList() {
        return businessProductList;
    }

    public void setBusinessProductList(List<BusinessProduct> businessProductList) {
        this.businessProductList = businessProductList;
    }
}
