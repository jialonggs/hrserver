package org.sang.bean.requestEntity;

import org.sang.bean.YuBaoJia;
import org.sang.bean.YuProduct;

import java.util.List;

public class AddYuBaoJiaRequest {

    YuBaoJia yuBaoJia;
    List<YuProduct> yuProductList;

    public YuBaoJia getYuBaoJia() {
        return yuBaoJia;
    }

    public void setYuBaoJia(YuBaoJia yuBaoJia) {
        this.yuBaoJia = yuBaoJia;
    }

    public List<YuProduct> getYuProductList() {
        return yuProductList;
    }

    public void setYuProductList(List<YuProduct> yuProductList) {
        this.yuProductList = yuProductList;
    }
}
