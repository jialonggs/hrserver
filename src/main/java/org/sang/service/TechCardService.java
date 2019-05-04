package org.sang.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.TechCard;
import org.sang.bean.responseEntity.TechAdded;
import org.sang.mapper.OrderMapper;
import org.sang.mapper.TechCardMapper;
import org.sang.mapper.WenLiMapper;
import org.sang.utils.DoubleUtil;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TechCardService {

    @Autowired
    TechCardMapper techCardMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    WenLiMapper wenLiMapper;




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
            Integer techNum = order.getTechNum();
            Double nanDu = DoubleUtil.m2(Double.parseDouble(techCard.getNanDuXiShu()));
            // 工作面积 = 实际面积 * 难度系数 * 倍数
            // Double beiShu = Double.parseDouble(order.getBeiShu());
            Double workArge = nanDu * order.getRealityArea();
            int i = orderMapper.updateOrderTech(techCard.getOrderId(), DoubleUtil.m2(workArge), techNum-1);

            int y = wenLiMapper.updateTechId(techCard.getOrderId(), techCard.getWenliId());

            if(i> 0){
                return  true;
            }else {
                return false;
            }
        }else {

            return false;
        }
    }

    /**
     * 分页查询未提交工艺卡列表
     * @param pageInfoEntity
     * @return
     */
    public PageBean<TechAdded> getOrdersAddedTech(PageInfoEntity pageInfoEntity, String wenli, Long orderId) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        if(null == wenli || wenli.isEmpty()){
            wenli = null;
        }
        List<TechAdded> list = techCardMapper.getAll(wenli, orderId);
        PageInfo page = new PageInfo(list);
        PageBean<TechAdded> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    public TechCard getByOrderId(Long orderId){
        return  techCardMapper.getByTechId(orderId);
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
