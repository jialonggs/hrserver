package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.WenLi;

import java.util.List;

@Mapper
public interface WenLiMapper {

    int addWenLis(@Param("wenlis") List<WenLi> wenlis);

    List<WenLi> getByOrderId(@Param("orderId") Long orderId);

    List<WenLi> getByOrderId2(@Param("orderId") Long orderId);

    List<WenLi> getByUnAddTech(@Param("orderId") Long orderId);

    int updateTechId(@Param("techId") Long techId, @Param("id") Long wenliId);

    WenLi getById(@Param("wenliId") Long wenliId);

    WenLi getById2(@Param("wenliId") Long wenliId);

    int updateWenLi(@Param("wenli") WenLi wenLi);

    int delWenli(@Param("wenliId") Long wenliId);
}
