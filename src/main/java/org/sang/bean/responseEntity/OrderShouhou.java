package org.sang.bean.responseEntity;

import org.sang.bean.Order;
import org.sang.bean.SHBaoGao;
import org.sang.bean.ShXzOrder;
import org.sang.bean.ShouHou;

public class OrderShouhou extends ShouHou{
    private Order order;
    private SHBaoGao shBaoGao;
    private ShXzOrder shXzOrder;




    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public SHBaoGao getShBaoGao() {
        return shBaoGao;
    }

    public void setShBaoGao(SHBaoGao shBaoGao) {
        this.shBaoGao = shBaoGao;
    }

    public ShXzOrder getShXzOrder() {
        return shXzOrder;
    }

    public void setShXzOrder(ShXzOrder shXzOrder) {
        this.shXzOrder = shXzOrder;
    }
}
