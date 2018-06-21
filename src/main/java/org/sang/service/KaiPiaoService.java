package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.FaMo;
import org.sang.bean.KaiPiao;
import org.sang.bean.PageInfoEntity;
import org.sang.mapper.KaiPiaoMapper;
import org.sang.mapper.ProjectMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KaiPiaoService {

    @Autowired
    KaiPiaoMapper kaiPiaoMapper;

    @Autowired
    ProjectMapper projectMapper;

    @Transactional
    public Boolean addKaiPiao(KaiPiao kaiPiao){
        int i = kaiPiaoMapper.addKaiPiao(kaiPiao);
        int y = projectMapper.updateKiPiaoStatus(kaiPiao.getProjectId(), kaiPiao.getId(), 1);
        if(i > 0 && y>0){
            return true;
        }else{
            return false;
        }

    }


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<KaiPiao> getKaiPiaoList(PageInfoEntity pageInfoEntity, Integer status) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<KaiPiao> list = kaiPiaoMapper.getKaiPiaoList(status);
        PageInfo page = new PageInfo(list);
        PageBean<KaiPiao> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    @Transactional
    public int auditKaiPiao(Long id, Integer status, Integer auditId, String auditName, String auditRemark){
        String strStatus = status +"";
        String shangWuRemark = "";
        String jingLiRemark = "";
        String caiWuRemark = "";
        String auditShangId ="";
        String auditShangName="";
        String auditJingId = "";
        String auditJingName="";
        String auditFinanceId="";
        String auditFinanceName="";
        if(strStatus.equals("-1") || strStatus.equals("1")){
            shangWuRemark = auditRemark;
            auditShangId = auditId+"";
            auditShangName = auditName+"";
        }
        if(strStatus.equals("-2") || strStatus.equals("-2")){
            jingLiRemark = auditRemark;
            auditJingId= auditId+"";
            auditJingName = auditName+"";
        }
        if(strStatus.equals("-3") || strStatus.equals("-3")){
            caiWuRemark = auditRemark;
            auditFinanceId= auditId+"";
            auditFinanceName= auditName+"";
        }
        int i = kaiPiaoMapper.aduitKaiPiao(id, status, auditShangId, auditShangName,
                auditJingId, auditJingName, auditFinanceId, auditFinanceName, shangWuRemark, jingLiRemark, caiWuRemark);

        return i;
    }


    @Transactional
    public Boolean checkKaiPiao(KaiPiao kaiPiao){
        int i = kaiPiaoMapper.updateKaiPiao(kaiPiao);
        if(i > 0){
            return true;
        }else{
            return false;
        }
    }
}
