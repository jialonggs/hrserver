package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.Order;
import org.sang.bean.WuLiao;

import java.util.List;

public interface WuLiaoMapper {

    long addWuLiao(WuLiao wuLiao);

    List<Order> getOrderList(Long userId);

    List<WuLiao> getWuLiaoList(Long userId);

    List<WuLiao> getWuLiaoListByStatus(Integer status);

    int updateStatus(@Param("wuLiaoId") Long wuLiaoId, @Param("status") Integer status,
                     @Param("principalUserId") Long principalUserId, @Param("principalUserName") String principalUserName);

    WuLiao getWuLiaoById(@Param("id") Long id);

}
