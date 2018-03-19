package org.sang.service;

import org.sang.bean.ControlOrderFrom;
import org.sang.mapper.ControlOrderFromMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControlOrderFromService {

    @Autowired
    ControlOrderFromMapper controlOrderFromMapper;

    /**
     *添加控制单
     * @param controlOrderFrom
     * @return
     */
    public Long addControlOrderFrom(ControlOrderFrom controlOrderFrom) {
        controlOrderFromMapper.addControlOrderFrom(controlOrderFrom);
        return controlOrderFrom.getId();
    }
}
