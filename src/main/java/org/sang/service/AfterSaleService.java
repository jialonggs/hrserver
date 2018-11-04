package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.SHBaoGao;
import org.sang.bean.ShouHou;
import org.sang.bean.responseEntity.OrderShouhou;
import org.sang.bean.responseEntity.QualityOrderResp;
import org.sang.mapper.OrderMapper;
import org.sang.mapper.SHBaoGaoMapper;
import org.sang.mapper.ShouHouMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AfterSaleService {

    @Autowired
    private ShouHouMapper shouHouMapper;


    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private SHBaoGaoMapper shBaoGaoMapper;

    public PageBean<Order> getAfterOrders(PageInfoEntity pageInfoEntity, Integer userId, Integer afterStatus){
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<Order> list = orderMapper.getAfterOrdersList(afterStatus);
        PageInfo page = new PageInfo(list);
        PageBean<Order> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    @Transactional
    public Boolean addShouHou(ShouHou shouHou){
        int i = shouHouMapper.add(shouHou);
        int y = orderMapper.updateAfterStatus(shouHou.getOrderId());
        if(i > 0 & y>0){
            return true;
        }else{
            return false;
        }

    }


    public PageBean<OrderShouhou> getAfterOrderShouHou(PageInfoEntity pageInfoEntity, Integer userId, Integer status){
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<OrderShouhou> list = shouHouMapper.getShouHouList(userId, status);
        PageInfo page = new PageInfo(list);
        PageBean<OrderShouhou> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    @Transactional
    public Boolean addBaoGao(SHBaoGao shBaoGao){
        int i = shBaoGaoMapper.add(shBaoGao);
        int y = shouHouMapper.updateShouHouStatus(shBaoGao.getOrderId());
        if(i > 0 & y>0){
            return true;
        }else{
            return false;
        }

    }
}
