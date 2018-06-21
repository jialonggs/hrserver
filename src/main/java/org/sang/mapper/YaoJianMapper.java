package org.sang.mapper;

import org.sang.bean.YaoJian;
import org.sang.bean.responseEntity.YaoJianOrderResp;

import java.util.List;

public interface YaoJianMapper {

    int addYaoJian(YaoJian yaoJian);

     List<YaoJianOrderResp> getAddedList();
}
