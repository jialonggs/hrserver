package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.CaiMoList;
import org.sang.bean.responseEntity.CaiMoListResp;

import java.util.List;


public interface CaiMoMapper {
    List<CaiMoListResp> getCaiMoList();

    int addCaiMo(CaiMoList caiMoList);

    int updateCaiMo(@Param("caiMo") CaiMoList caiMoList);
}
