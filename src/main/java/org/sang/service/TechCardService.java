package org.sang.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sang.bean.Order;
import org.sang.bean.TechCard;
import org.sang.mapper.OrderMapper;
import org.sang.mapper.TechCardMapper;
import org.sang.utils.DoubleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechCardService {

    @Autowired
    TechCardMapper techCardMapper;

    @Autowired
    OrderMapper orderMapper;


    /**
     *添加技术卡信息
     * @param
     * @return
     */
    @Transactional
    public Boolean addTech(TechCard techCard) {
        Long techId = techCardMapper.addTech(techCard);
        if(techId > 0){
            Order order = orderMapper.getOrderInfoById(techCard.getOrderId());
            Double nanDu = DoubleUtil.m2(Double.parseDouble(techCard.getNanDuXiShu()));
            // 工作面积 = 实际面积 * 难度系数 * 倍数
            Double beiShu = Double.parseDouble(order.getBeiShu());
            Double workArge = beiShu * nanDu * order.getRealityArea();
            int i = orderMapper.updateOrderTech(techCard.getOrderId(), DoubleUtil.m2(workArge));
            if(i> 0){
                return  true;
            }else {
                return false;
            }
        }else {

            return false;
        }
    }

    public TechCard getByOrderId(Long orderId){
        return  techCardMapper.getByOrderId(orderId);
    }


    public Boolean updateTechCard(TechCard techCard){
        int i = techCardMapper.updateTechCard(techCard);
        if(i>0){
            return true;
        }else {
            return  false;
        }
    }


}
