package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.KaiPiao;

import java.util.List;

public interface KaiPiaoMapper {

    int updateKaiPiao(@Param("kaipiao") KaiPiao kaiPiao);

    int addKaiPiao(KaiPiao kaiPiao);

    List<KaiPiao> getKaiPiaoList(@Param("status") Integer status);

    int aduitKaiPiao(@Param("id")Long id,@Param("status")Integer status, @Param("auditShangId")String  auditShangId, @Param("auditShangName")String auditShangName,
                     @Param("auditJingId")String  auditJingId, @Param("auditJingName")String auditJingName,
                     @Param("auditFinanceId")String  auditFinanceId, @Param("auditFinanceName")String auditFinanceName,
                     @Param("shangWuRemark") String  shangWuRemark, @Param("jingLiRemark") String jingLiRemark, @Param("caiWuRemark") String caiWuRemark);
}
