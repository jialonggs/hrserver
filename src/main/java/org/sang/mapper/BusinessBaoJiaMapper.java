package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.BusinessBaoJia;
import org.sang.bean.YuBaoJia;
import org.sang.bean.responseEntity.BusInfoResp;

import java.util.List;

@Mapper
public interface BusinessBaoJiaMapper {

    int aginAudit(@Param("yuBaoJia") BusinessBaoJia businessBaoJia);

    List<BusInfoResp> getBusinessBaoJiaList(@Param("addUserId") Integer addUserId);

    int addBusinessBaoJia(BusinessBaoJia yuBaoJia);

    List<BusinessBaoJia> getAuditBusinessBaoJiaList(@Param("audit") Integer audit);

    int updateBusinessBaoJia(@Param("yuBaoJiaId") Long yuBaoJiaId, @Param("total") Double total, @Param("noTaxTotal") Double noTaxTotal);

    int updateFinalBaoJia(@Param("yuBaoJiaId") Long id, @Param("finalBaoJia") Double finalBaoJia, @Param("noTaxfinalBaoJia") Double noTaxfinalBaoJia);

    BusinessBaoJia getBusinessBaoJiaByProjectId(@Param("projectId") Long projectId);

    BusInfoResp getById(@Param("id") Long id);

    int auditBus(@Param("id") Long id, @Param("audit") Integer audit, @Param("auditId") Long auditId, @Param("auditName") String auditName, @Param("rejectRemark") String rejectRemark);
}
