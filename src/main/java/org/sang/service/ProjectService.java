package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.Project;
import org.sang.bean.responseEntity.ProjectListResp;
import org.sang.mapper.ProjectMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
