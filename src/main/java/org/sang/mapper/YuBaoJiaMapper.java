package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.YuBaoJia;
import org.sang.bean.responseEntity.YuBaoJiaInfoResp;

import java.util.List;

@Mapper
public interface YuBaoJiaMapper {

    int updateFinalBaoJia(@Param("yuBaoJiaId") Long id, @Param("finalBaoJia") Double finalBaoJia, @Param("noTaxfinalBaoJia") Double noTaxfinalBaoJia);

    int aginAudit(@Param("yuBaoJia") YuBaoJia yuBaoJia);

    List<YuBaoJia> getYuBaoJiaList(@Param("addUserId") Integer addUserId);

    long addYuBaoJia(YuBaoJia yuBaoJia);

    List<YuBaoJia> getAuditYuBaoJiaList(@Param("audit") Integer audit);

    YuBaoJia getByProjectId(@Param("projectId") Long projectId);

    YuBaoJiaInfoResp getById(@Param("id") Long id);

    int updateYuBaoJia(@Param("yuBaoJiaId") Long yuBaoJiaId, @Param("total") Double total, @Param("noTaxTotal") Double noTaxTotal);

    int auditYu(@Param("id") Long id, @Param("audit") Integer audit, @Param("auditId") Long auditId, @Param("auditName") String auditName, @Param("rejectRemark") String rejectRemark);
}
