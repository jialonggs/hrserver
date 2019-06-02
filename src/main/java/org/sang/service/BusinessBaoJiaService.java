package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.*;
import org.sang.bean.requestEntity.AddBusBaoJiaRequest;
import org.sang.bean.responseEntity.BusInfoResp;
import org.sang.bean.responseEntity.ProjectListResp;
import org.sang.mapper.BusinessBaoJiaMapper;
import org.sang.mapper.BusinessProductMapper;
import org.sang.mapper.ProjectMapper;
import org.sang.mapper.YuBaoJiaMapper;
import org.sang.utils.DoubleUtil;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessBaoJiaService {

    @Autowired
    BusinessBaoJiaMapper businessBaoJiaMapper;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    BusinessProductMapper businessProductMapper;


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<BusInfoResp> getBusinessbaoJiaList(PageInfoEntity pageInfoEntity, Integer addUserId) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<BusInfoResp> list = businessBaoJiaMapper.getBusinessBaoJiaList(addUserId);
        PageInfo page = new PageInfo(list);
        PageBean<BusInfoResp> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<BusinessBaoJia> getAuditBusinessbaoJiaList(PageInfoEntity pageInfoEntity, Integer audit) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<BusinessBaoJia> list = businessBaoJiaMapper.getAuditBusinessBaoJiaList(audit);
        PageInfo page = new PageInfo(list);
        PageBean<BusinessBaoJia> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    public Long addBusinessBaoJia(BusinessBaoJia businessBaoJia){
        businessBaoJiaMapper.addBusinessBaoJia(businessBaoJia);
        return businessBaoJia.getId();

    }

    public BusInfoResp getById(Long id){
        return businessBaoJiaMapper.getById(id);
    }

    @Transactional
    public int auditBus(Long id, Integer audit, Long auditId, String auditName, String rejectRemark,Long projectId){
        // 修改审核状态
        if(audit == 1){
            // 修改该报价金额
            BusinessBaoJia businessBaoJia = businessBaoJiaMapper.getById(id);
            businessBaoJia.getFinalBaoJia();
            projectMapper.updateProjectBus(projectId,audit,businessBaoJia.getFinalBaoJia());
        }
        return  businessBaoJiaMapper.auditBus(id, audit, auditId, auditName, rejectRemark);
    }


    public List<ProjectListResp> getProjectListByAddUserId(Long addUserId){
        List<ProjectListResp> list = projectMapper.getProjectListByUserId(addUserId);
//        if(null == list || list.isEmpty()){
//            return null;
//        }
//        return list;
        List<ProjectListResp> listResp = new ArrayList<>();
        for(ProjectListResp projectListResp : list){
            if(null != projectListResp.getBusinessBaoJia()){
                continue;
            }
            listResp.add(projectListResp);
        }
        return listResp;
    }


    public int aginAudit(BusinessBaoJia businessBaoJia){
        // 简单添加
        if(businessBaoJia.getSubmitType() == 0){
            businessBaoJia.setTotal(null);
            businessBaoJia.setNoTaxTotal(null);
        }
        return businessBaoJiaMapper.aginAudit(businessBaoJia);

    }

    @Transactional
    public Boolean addBusinessBaoJia2(AddBusBaoJiaRequest addBusBaoJiaRequest){
        BusinessBaoJia businessBaoJia = addBusBaoJiaRequest.getBusinessBaoJia();
        businessBaoJia.setTotal(DoubleUtil.m2(businessBaoJia.getTotal()));
        businessBaoJia.setNoTaxTotal(DoubleUtil.m2(businessBaoJia.getNoTaxTotal()));
        if(businessBaoJia.getFinalBaoJia() == null){
            businessBaoJia.setFinalBaoJia(businessBaoJia.getTotal());
            businessBaoJia.setNoTaxfinalBaoJia(businessBaoJia.getNoTaxTotal());
        }
        long id = businessBaoJiaMapper.addBusinessBaoJia(businessBaoJia);
        if(id <= 0){
            return false;
        }
        if(businessBaoJia.getSubmitType() == 0){
            List<BusinessProduct> businessProducts = addBusBaoJiaRequest.getBusinessProductList();
            for(BusinessProduct businessProduct : businessProducts){
                businessProduct.setYuBaoJiaId(businessBaoJia.getId());
            }
            businessProductMapper.addBusinessProduct(businessProducts);
        }
        return true;

    }


    public BusinessBaoJia getProjectBuInfo(Long projectId){
        BusinessBaoJia businessBaoJia = businessBaoJiaMapper.getBusinessBaoJiaByProjectId(projectId);
        return businessBaoJia;
    }

    public Boolean updateFinalBaoJia(Long id, Double tax, Double finalBaoJia ){
        Double tax1= tax / 100 + 1;
        Double noTaxfinalBaoJia = DoubleUtil.m2(finalBaoJia / tax1);
        int i = businessBaoJiaMapper.updateFinalBaoJia(id, finalBaoJia, noTaxfinalBaoJia);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
}
