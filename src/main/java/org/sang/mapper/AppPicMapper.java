package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.AppPic;
import org.sang.bean.BusBaoJia;

import java.util.List;

public interface AppPicMapper {

   AppPic getAppPic();

   int addPicUrl(AppPic appPic);

   int updatePicUrl(@Param("id") Long id, @Param("url") String url);
}
