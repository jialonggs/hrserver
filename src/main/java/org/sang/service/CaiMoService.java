package org.sang.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.CaiMoList;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.responseEntity.CaiMoListResp;
import org.sang.mapper.CaiMoMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaiMoService {

    @Autowired
    CaiMoMapper caiMoMapper;


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<CaiMoListResp> getShouMoListByPage(PageInfoEntity pageInfoEntity) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<CaiMoListResp> list = caiMoMapper.getCaiMoList();
        PageInfo page = new PageInfo(list);
        PageBean<CaiMoListResp> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    /**
     *
     * @param caiMoList
     * @return
     */
    public int addCaiMo(CaiMoList caiMoList){
        return caiMoMapper.addCaiMo(caiMoList);
    }

    public int updateCaiMoList(CaiMoList caiMoList){
        return caiMoMapper.updateCaiMo(caiMoList);
    }
}
