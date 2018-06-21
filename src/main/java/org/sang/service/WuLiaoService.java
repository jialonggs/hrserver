package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.WuLiao;
import org.sang.mapper.WuLiaoMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WuLiaoService {

    @Autowired
    WuLiaoMapper wuLiaoMapper;

    public Long addWuLiao(WuLiao wuLiao){
        return wuLiaoMapper.addWuLiao(wuLiao);
    }

    public List<Order> getOrderList(Long userId){
        return wuLiaoMapper.getOrderList(userId);
    }


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<WuLiao> getWuLiaoList(PageInfoEntity pageInfoEntity, Long addUserId) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<WuLiao> list = wuLiaoMapper.getWuLiaoList(addUserId);
        PageInfo page = new PageInfo(list);
        PageBean<WuLiao> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }



    public PageBean<WuLiao> getWuLiaoListByStatus(PageInfoEntity pageInfoEntity, Integer status) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<WuLiao> list = wuLiaoMapper.getWuLiaoListByStatus(status);
        PageInfo page = new PageInfo(list);
        PageBean<WuLiao> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    public int updateStatus(Long wuLiaoId, Integer status,Long principalUserId, String principalUserName){
        return wuLiaoMapper.updateStatus(wuLiaoId, status, principalUserId, principalUserName);
    }

    public WuLiao getWuLiaoById(Long id){
        return wuLiaoMapper.getWuLiaoById(id);
    }
}
