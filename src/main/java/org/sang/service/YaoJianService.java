package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.YaoJian;
import org.sang.bean.YuBaoJia;
import org.sang.bean.responseEntity.YaoJianOrderResp;
import org.sang.mapper.OrderMapper;
import org.sang.mapper.YaoJianMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class YaoJianService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    YaoJianMapper yaoJianMapper;


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<Order> getYubaoJiaList(PageInfoEntity pageInfoEntity, Boolean yaoJian) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<Order> list = orderMapper.getUnYaoJianList(yaoJian);
        PageInfo page = new PageInfo(list);
        PageBean<Order> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    /**
     *
     * @param pageInfoEntity
     * @return
     */
    public PageBean<YaoJianOrderResp> getAddedList(PageInfoEntity pageInfoEntity) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<YaoJianOrderResp> list = yaoJianMapper.getAddedList();
        PageInfo page = new PageInfo(list);
        PageBean<YaoJianOrderResp> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    @Transactional
    public int addYaoJian(YaoJian yaoJian){
        int i = yaoJianMapper.addYaoJian(yaoJian);
        if(i>0){
            int k = orderMapper.updateOrderYaoJian(yaoJian.getOrderId());
            return k;
        }else{
            return -1;
        }
    }
}
