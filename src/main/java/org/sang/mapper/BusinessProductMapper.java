package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.BusinessProduct;

import java.util.List;

@Mapper
public interface BusinessProductMapper {
    int addBusinessProduct(@Param("product") List<BusinessProduct> busProducts);

    List<BusinessProduct> getByBusId(@Param("yuBaoJiaId") Long yuBaoJiaId);

    int delProduct(@Param("id") Long id);

    int updateYuProduct(@Param("yuProduct") BusinessProduct  yuProduct);

    List<BusinessProduct> getByYuBaoJiaId (@Param("yuBaoJiaId") Long yuBaoJiaId);
}
