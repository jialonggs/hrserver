package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.*;
import org.sang.bean.requestEntity.AddYuBaoJiaRequest;
import org.sang.bean.responseEntity.ProjectListResp;
import org.sang.bean.responseEntity.YuBaoJiaInfoResp;
import org.sang.mapper.ProjectMapper;
import org.sang.mapper.YuBaoJiaMapper;
import org.sang.mapper.YuProductMapper;
import org.sang.utils.DoubleUtil;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class YuBaoJiaService {

    @Autowired
    YuBaoJiaMapper yuBaoJiaMapper;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    YuProductMapper yuProductMapper;


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<YuBaoJiaInfoResp> getYubaoJiaList(PageInfoEntity pageInfoEntity, Integer addUserId) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<YuBaoJiaInfoResp> list = yuBaoJiaMapper.getYuBaoJiaList(addUserId);
        PageInfo page = new PageInfo(list);
        PageBean<YuBaoJiaInfoResp> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<YuBaoJia> getAuditYubaoJiaList(PageInfoEntity pageInfoEntity, Integer audit) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<YuBaoJia> list = yuBaoJiaMapper.getAuditYuBaoJiaList(audit);
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

    @Transactional
    public Boolean addYuBaoJia2(AddYuBaoJiaRequest yuBaoJiaRequest){
        YuBaoJia yuBaoJia = yuBaoJiaRequest.getYuBaoJia();
        yuBaoJia.setTotal(DoubleUtil.m2(yuBaoJia.getTotal()));
        yuBaoJia.setNoTaxTotal(DoubleUtil.m2(yuBaoJia.getNoTaxTotal()));
        if(yuBaoJia.getFinalBaoJia() == null){
            yuBaoJia.setFinalBaoJia(yuBaoJia.getTotal());
            yuBaoJia.setNoTaxfinalBaoJia(yuBaoJia.getNoTaxTotal());
        }
        long id = yuBaoJiaMapper.addYuBaoJia(yuBaoJia);
        if(id <= 0){
            return false;
        }
        if(yuBaoJia.getSubmitType() == 0){
            List<YuProduct> yuProducts = yuBaoJiaRequest.getYuProductList();
            for(YuProduct yuProduct : yuProducts){
                yuProduct.setYuBaoJiaId(yuBaoJia.getId());
            }
            yuProductMapper.addYuProduct(yuProducts);
        }
        return true;

    }

    public YuBaoJiaInfoResp getById(Long id){
        return yuBaoJiaMapper.getById(id);
    }

    public int auditYu(Long id, Integer audit, Long auditId, String auditName, String rejectRemark){
        return  yuBaoJiaMapper.auditYu(id, audit, auditId, auditName, rejectRemark);
    }

    public YuBaoJia getByProjectId(Long projectId){
        return yuBaoJiaMapper.getByProjectId(projectId);
    }


    public List<ProjectListResp> getProjectListByAddUserId(Long addUserId){
        List<ProjectListResp> list = projectMapper.getProjectListByUserId(addUserId);
//        if(null == list || list.isEmpty()){
//            return null;
//        }
//        return list;
        List<ProjectListResp> listResp = new ArrayList<>();
        for(ProjectListResp projectListResp : list){
            if(null != projectListResp.getYuBaoJia()){
                continue;
            }
            listResp.add(projectListResp);
        }
        return listResp;
    }

    public int aginAudit(YuBaoJia yuBaoJia){
        // 简单添加
        if(yuBaoJia.getSubmitType() == 0){
            yuBaoJia.setTotal(null);
            yuBaoJia.setNoTaxTotal(null);
        }
        return yuBaoJiaMapper.aginAudit(yuBaoJia);

    }

    public Boolean updateFinalBaoJia(Long id, Double tax, Double finalBaoJia ){
        Double tax1= tax / 100 + 1;
        Double noTaxfinalBaoJia = DoubleUtil.m2(finalBaoJia / tax1);
        int i = yuBaoJiaMapper.updateFinalBaoJia(id, finalBaoJia, noTaxfinalBaoJia);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
}
