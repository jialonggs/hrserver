package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.BusBaoJia;
import java.util.List;

public interface BusBaoJiaMapper {

    List<BusBaoJia> getBusBaoJiaList(@Param("addUserId") Integer addUserId);

    int addBusBaoJia(BusBaoJia busBaoJia);

    List<BusBaoJia> getAuditBusBaoJiaList(@Param("audit") Integer audit);

}
