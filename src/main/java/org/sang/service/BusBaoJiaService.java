package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.BusBaoJia;
import org.sang.bean.PageInfoEntity;
import org.sang.mapper.BusBaoJiaMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BusBaoJiaService {

    @Autowired
    BusBaoJiaMapper baoJiaMapper;

    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<BusBaoJia> getBusBaoJiaList(PageInfoEntity pageInfoEntity, Integer addUserId) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<BusBaoJia> list = baoJiaMapper.getBusBaoJiaList(addUserId);
        PageInfo page = new PageInfo(list);
        PageBean<BusBaoJia> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    /**
     * 根据状态分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<BusBaoJia> getAuditBusBaoJiaList(PageInfoEntity pageInfoEntity, Integer audit) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<BusBaoJia> list = baoJiaMapper.getAuditBusBaoJiaList(audit);
        PageInfo page = new PageInfo(list);
        PageBean<BusBaoJia> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    public Long addBusBaoJia(BusBaoJia busBaoJia){
        baoJiaMapper.addBusBaoJia(busBaoJia);
        return busBaoJia.getId();

    }
}
