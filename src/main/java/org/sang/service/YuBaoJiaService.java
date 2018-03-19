package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.YuBaoJia;
import org.sang.mapper.YuBaoJiaMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YuBaoJiaService {

    @Autowired
    YuBaoJiaMapper yuBaoJiaMapper;


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<YuBaoJia> getYubaoJiaList(PageInfoEntity pageInfoEntity, Integer addUserId) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<YuBaoJia> list = yuBaoJiaMapper.getYuBaoJiaList(addUserId);
        PageInfo page = new PageInfo(list);
        PageBean<YuBaoJia> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    public Long addYuBaoJia(YuBaoJia yuBaoJia){
        yuBaoJiaMapper.addYuBaoJia(yuBaoJia);
        return yuBaoJia.getId();

    }
}
