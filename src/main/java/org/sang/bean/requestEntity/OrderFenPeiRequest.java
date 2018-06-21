package org.sang.bean.requestEntity;

import org.sang.bean.Hr;
import org.sang.bean.responseEntity.FlowStepsResp;

import java.util.List;

public class OrderFenPeiRequest {

    private Long orderId;
    private String orderName;
    private Long addUserId;
    private String addUserName;
    private Integer nanDuXiShu;

    private List<YgaRquest> ygas;
    private List<Hr> qualityUsers;
    private FlowStepsResp flow;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(Long addUserId) {
        this.addUserId = addUserId;
    }

    public String getAddUserName() {
        return addUserName;
    }

    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    public Integer getNanDuXiShu() {
        return nanDuXiShu;
    }

    public void setNanDuXiShu(Integer nanDuXiShu) {
        this.nanDuXiShu = nanDuXiShu;
    }

    public List<YgaRquest> getYgas() {
        return ygas;
    }

    public void setYgas(List<YgaRquest> ygas) {
        this.ygas = ygas;
    }

    public void setFlow(FlowStepsResp flow) {
        this.flow = flow;
    }

    public List<Hr> getQualityUsers() {
        return qualityUsers;
    }

    public void setQualityUsers(List<Hr> qualityUsers) {
        this.qualityUsers = qualityUsers;
    }


    public FlowStepsResp getFlow() {
        return flow;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return "OrderFenPeiRequest{" +
                "orderId=" + orderId +
                ", addUserId=" + addUserId +
                ", addUserName='" + addUserName + '\'' +
                ", nanDuXiShu=" + nanDuXiShu +
                ", ygas=" + ygas +
                ", qualityUsers=" + qualityUsers +
                ", flow=" + flow +
                '}';
    }
}
