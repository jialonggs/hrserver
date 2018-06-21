package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.YuProduct;
import java.util.List;

@Mapper
public interface YuProductMapper {

    int addYuProduct(@Param("product") List<YuProduct> yuProducts);

    List<YuProduct> getByYuBaoJiaId (@Param("yuBaoJiaId") Long yuBaoJiaId);

    int updateYuProduct(@Param("yuProduct") YuProduct  yuProduct);

    int delProduct(@Param("id") Long id);
}
