package org.sang.controller.project;

import org.sang.bean.PageInfoEntity;
import org.sang.bean.Project;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.ProjectListResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.ProjectService;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/project/list")
public class ProjectController extends BaseController{

    @Autowired
    ProjectService projectService;

    @Value("${project.added.month}")
    private String projectAddedMonth;

    /**
     * 查询项目列表
     * @return
     */
    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getShouMoList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<ProjectListResp> projectlist = new ArrayList<>();
        PageBean<ProjectListResp> list = projectService.getShouMoListByPage(pageInfoEntity);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){

            projectlist = list.getItems();
            for (ProjectListResp projectListResp : projectlist){
                if(null != projectListResp.getOrders() && !projectListResp.getOrders().isEmpty() && !projectListResp.getOrders().equals("")){
                    projectListResp.setOrderNums(projectListResp.getOrders().size());
                }else {
                    projectListResp.setOrderNums(0);
                }
            }
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("projectlist", projectlist);
        return succResult(map);
    }


    /**
     * 查询项目列表（默认两个月内的项目）
     * @return
     */
    @RequestMapping(value = "/added", method = RequestMethod.GET)
    public BaseResponseEntity getShouMoList(@RequestParam("userId") Long userId) {
        Map<String, Object> map = new HashMap<>();
        List<Project> projectlist = new ArrayList<>();
        projectlist = projectService.getAdded(userId,Integer.parseInt(projectAddedMonth));
        map.put("addedProject", projectlist);
        return succResult(map);
    }


    /**
     * 添加项目信息
     * @param project
     * @return
     */
    @RequestMapping(value = "/add/project", method = RequestMethod.POST)
    public BaseResponseEntity addShouMo(Project project) {
        Map<String, Object> map = new HashMap<>();
        Long i = projectService.addProject(project);
        if (i >= 1) {
            map.put("id",1);
            return  succResult(map);
        } else {
            map.put("id",-1);
            return succResult(map);
        }
    }


    /**
     * 根据uid 查询项目
     * @return
     */
    @RequestMapping(value = "/byuid", method = RequestMethod.GET)
    public BaseResponseEntity getShouMoList(@RequestParam(value = "uid") Integer uid) {
        Map<String, Object> map = new HashMap<>();
        List<Project> list = projectService.getProjectListByUid(uid);
        if (null == list || list.size()==0){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
        map.put("projectlist", list);
        return succResult(map);
    }




}
