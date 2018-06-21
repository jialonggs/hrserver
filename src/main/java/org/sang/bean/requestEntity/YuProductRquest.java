package org.sang.bean.requestEntity;

import org.sang.bean.YuProduct;

import java.util.List;

public class YuProductRquest {
    private Integer yuBaoJiaId;
    private String yuProducts;

    public String getYuProducts() {
        return yuProducts;
    }

    public void setYuProducts(String yuProducts) {
        this.yuProducts = yuProducts;
    }

    public Integer getYuBaoJiaId() {
        return yuBaoJiaId;
    }

    public void setYuBaoJiaId(Integer yuBaoJiaId) {
        this.yuBaoJiaId = yuBaoJiaId;
    }
}
