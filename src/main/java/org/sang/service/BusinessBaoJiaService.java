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
    public PageBean<BusinessBaoJia> getBusinessbaoJiaList(PageInfoEntity pageInfoEntity, Integer addUserId) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<BusinessBaoJia> list = businessBaoJiaMapper.getBusinessBaoJiaList(addUserId);
        PageInfo page = new PageInfo(list);
        PageBean<BusinessBaoJia> pageData = new PageBean<>();
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

    public int auditBus(Long id, Integer audit, Long auditId, String auditName, String rejectRemark){
        return  businessBaoJiaMapper.auditBus(id, audit, auditId, auditName, rejectRemark);
    }


    public List<Project> getProjectListByAddUserId(Long addUserId){
        List<ProjectListResp> list = projectMapper.getProjectListByUserId(addUserId);
        if(null == list || list.isEmpty()){
            return null;
        }
        List<Project> listResp = new ArrayList<>();
        for(ProjectListResp projectListResp : list){
            if(null != projectListResp.getBusinessBaoJia()){
                continue;
            }
            Project project = new Project();
            project.setId(projectListResp.getId());
            project.setProjectName(projectListResp.getProjectName());
            listResp.add(project);
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
}
