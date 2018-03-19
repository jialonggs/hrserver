package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Project;
import org.sang.bean.responseEntity.ProjectListResp;

import java.util.List;

@Mapper
public interface ProjectMapper {

    List<ProjectListResp> getProjectList();

    int addProject(Project project);

    List<Project> getByUid(@Param("uid") Integer uid);

}
