package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.Project;
import org.sang.bean.requestEntity.AddFuKuanRequest;
import org.sang.bean.responseEntity.ProjectListResp;
import org.sang.mapper.ProjectMapper;
import org.sang.utils.DateFormatUtil;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<ProjectListResp> getShouMoListByPage(PageInfoEntity pageInfoEntity) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<ProjectListResp> list = projectMapper.getProjectList();
        PageInfo page = new PageInfo(list);
        PageBean<ProjectListResp> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    /**
     * 获取最近添加项目列表
     * @param userId
     * @param month
     * @return
     */
    public List<Project> getAdded(Long userId, Integer month) {
        Date endTime = new Date();
        Calendar beginTime = Calendar.getInstance();
        beginTime.add(Calendar.MONTH, -month);
        Date beginAt = beginTime.getTime();
        String endTimeString = DateFormatUtil.dateToString(endTime, DateFormatUtil.YYYY_MM_DD);
        String beginTimeString = DateFormatUtil.dateToString(beginAt, DateFormatUtil.YYYY_MM_DD);
        return  projectMapper.getAdded(userId, beginTimeString, endTimeString);
    }

    public Project getByProjectById(Long projectId){
        return projectMapper.getProjectById(projectId);
    }



    /**
     *添加项目基础信息
     * @param project
     * @return
     */
    public Long addProject(Project project) {
        projectMapper.addProject(project);
        return project.getId();
    }

    /**
     *根据uid查询项目列表
     */

    public List<Project> getProjectListByUid(Integer uid){
        return projectMapper.getByUid(uid);
    }


    public List<Project> getProjectListByAddUserId(Long addUserId){
        List<ProjectListResp> list = projectMapper.getProjectListByUserId(addUserId);
        if(null == list || list.isEmpty()){
            return null;
        }
        List<Project> listResp = new ArrayList<>();
        for(ProjectListResp projectListResp : list){
            if(null != projectListResp.getBusinessBaoJia() || null != projectListResp.getYuBaoJia()){
                continue;
            }
            Project project = new Project();
            project.setId(projectListResp.getId());
            project.setProjectName(projectListResp.getProjectName());
            listResp.add(project);
        }
        return listResp;
    }

//    public Project getByProjectId()


    /**
     * 分页查询 所有的待财务确认的项目
     * @param pageInfoEntity
     * @return
     */
    public PageBean<ProjectListResp> getFinanceProject(PageInfoEntity pageInfoEntity, Integer financeStatus, Long unitId) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<ProjectListResp> list = null;
        if(financeStatus!=null && financeStatus.equals(3)){
             list = projectMapper.getOverceFinanceProject(unitId);
        }else{
            list = projectMapper.getFinanceProject(unitId);
        }

        PageInfo page = new PageInfo(list);
        PageBean<ProjectListResp> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    public Boolean addFuKuan(AddFuKuanRequest addFuKuanRequest){
        if((addFuKuanRequest.getFinanceStatus()+"").equals("1")){
            addFuKuanRequest.setFinanceTime(null);
            addFuKuanRequest.setFinanceBiLi(0+"");
            addFuKuanRequest.setFinanceJinE(0+"");
            addFuKuanRequest.setFinanceRemark("");
            addFuKuanRequest.setFinanceStatus(0);
        }else{
            if(addFuKuanRequest.getFinanceBiLi().equals("100")){
                addFuKuanRequest.setFinanceStatus(3);
            }else{
                addFuKuanRequest.setFinanceStatus(2);
            }
        }
        int i = projectMapper.addFuKuan(addFuKuanRequest);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
}
