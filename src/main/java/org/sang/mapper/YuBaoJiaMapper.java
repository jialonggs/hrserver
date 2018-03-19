package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Order;
import org.sang.bean.YuBaoJia;

import java.util.List;

@Mapper
public interface YuBaoJiaMapper {

    List<YuBaoJia> getYuBaoJiaList(@Param("addUserId") Integer addUserId);

    int addYuBaoJia(YuBaoJia yuBaoJia);
}
