package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Project;
import org.sang.bean.requestEntity.AddFuKuanRequest;
import org.sang.bean.responseEntity.ProjectListResp;

import java.util.Date;
import java.util.List;

@Mapper
public interface ProjectMapper {

    int addFuKuan(@Param("fuKuan")AddFuKuanRequest addFuKuanRequest);

    List<Project> getOverceFinanceProject();

    List<Project> getFinanceProject();

    List<ProjectListResp> getProjectList();

    List<ProjectListResp> getProjectListByUserId(@Param("addUserId") Long addUserId);

    int addProject(Project project);

    List<Project> getByUid(@Param("uid") Integer uid);

    List<Project> getAdded(@Param("userId") Long uid, @Param("beginTime")String beginTime, @Param("endTime") String endTime);

    int updateKiPiaoStatus(@Param("projectId") Long projectId, @Param("kaiPiaoId") Long kaiPiaoId, @Param("kaiPiaoStatus") Integer kaiPiaoStatus);

    List<Project> getByUnitId(@Param("unitId") Long unitId);

    List<Project> getByCarId(@Param("carId") Long carId);

    List<Project> getByEngineId(@Param("engineId") Long engineId);

}
