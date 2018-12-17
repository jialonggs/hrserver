package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.*;
import org.sang.bean.responseEntity.OrderAffterOffice;
import org.sang.bean.responseEntity.OrderShouhou;
import org.sang.bean.responseEntity.QualityOrderResp;
import org.sang.mapper.OrderMapper;
import org.sang.mapper.SHBaoGaoMapper;
import org.sang.mapper.ShXzOrderMapper;
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

    @Autowired
    private ShXzOrderMapper shXzOrderMapper;


    public PageBean<OrderAffterOffice> getOrderAffterOffice(PageInfoEntity pageInfoEntity, Integer userId){
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<OrderAffterOffice> list = orderMapper.getOrderAffterOffice(userId);
        PageInfo page = new PageInfo(list);
        PageBean<OrderAffterOffice> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    public PageBean<OrderShouhou> getAfterOrders(PageInfoEntity pageInfoEntity, Integer userId, Integer status){
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<OrderShouhou> list = shouHouMapper.getAfterOrdersList(status);
        PageInfo page = new PageInfo(list);
        PageBean<OrderShouhou> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    @Transactional
    public Boolean addShouHou(ShouHou shouHou){
        shouHou.setStatus(2);
        int i = shouHouMapper.updateShouHou(shouHou);

//        int y = orderMapper.updateAfterStatus(shouHou.getOrderId());
        if(i > 0){
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

//    @Transactional
//    public Boolean addBaoGao(SHBaoGao shBaoGao){
//        int i = shBaoGaoMapper.add(shBaoGao);
//        int y = shouHouMapper.updateShouHouStatus(shBaoGao.getOrderId(),2);
//        if(i > 0 & y>0){
//            return true;
//        }else{
//            return false;
//        }
//    }


//    @Transactional
//    public Boolean toSale(Integer afterStatus, Integer  orderId){
//        int i = orderMapper.updateAfterStatus(afterStatus, orderId);
//        ShouHou  shouHou = new ShouHou();
//        shouHou.setOrderId(orderId);
//        shouHou.setStatus(0);
//        int y = shouHouMapper.add(shouHou);
//        if(i>0 && y>0){
//            return true;
//        }else{
//            return  false;
//        }
//    }

    @Transactional
    public Boolean addShXz(ShXzOrder shXzOrder){
        int id = shXzOrderMapper.addShXzOrder(shXzOrder);
        ShouHou checkShouHou = shouHouMapper.getShouHouByOrderId(shXzOrder.getOrderId());
        if(null == checkShouHou){
            ShouHou shouHou = new ShouHou();
            shouHou.setStatus(0);
            shouHou.setXzId(shXzOrder.getId());
            shouHou.setOrderId(shXzOrder.getOrderId());
            shouHou.setDanwei(shXzOrder.getDanWei());
            shouHou.setAddress(shXzOrder.getAddress());
            shouHou.setAddUserId(shXzOrder.getAddUserId());
            shouHou.setAddUserName(shXzOrder.getAddUserName());
            int addShou = shouHouMapper.add(shouHou);
        }else{
            // 需要更新
            if(checkShouHou.getShId()>0){
                int updateResult = shouHouMapper.updateXzOrBg(checkShouHou.getId(), id, null);
            }
        }
        int i = orderMapper.updateAfterStatus(1, shXzOrder.getOrderId());
        if(id > 0){
            return  true;
        }else{
            return  false;
        }
    }


    // 代替到待分配中
    @Transactional
    public Boolean addSh(SHBaoGao shBaoGao){

        int addBaogao = shBaoGaoMapper.add(shBaoGao);
        int  pdateBGIdStatus = shouHouMapper.updateBGIdStatus(shBaoGao.getOrderId(), shBaoGao.getId(), 1);
        int i = orderMapper.updateAfterStatus(2, shBaoGao.getOrderId());
        if(addBaogao>0){
            return  true;
        }else{
            return false;
        }
    }

    public Boolean updateShXz(ShXzOrder shXzOrder){
        int updateRe = shXzOrderMapper.updateSh(shXzOrder);
        if(updateRe>0){
            return true;
        }else {
            return false;
        }
    }
}
