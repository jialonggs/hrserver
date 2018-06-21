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

    /**
     * 更新控制单
     * @param controlOrderFrom
     * @return
     */
    public Boolean updateControlOrderFrom(ControlOrderFrom controlOrderFrom){
        int i = controlOrderFromMapper.updateControlOrderFrom(controlOrderFrom);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
}
