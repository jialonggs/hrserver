package org.sang.service;

import org.sang.bean.LanMo;
import org.sang.mapper.LanMoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanMoService {

    @Autowired
    LanMoMapper lanMoMapper;

    public Long addLanMo(LanMo lanMo){
        lanMoMapper.addLanMo(lanMo);
        return lanMo.getId();
    }

    public List<LanMo> getByTechId(Long techId){
        return lanMoMapper.getByTechId(techId);
    }

    public Boolean updateLanMo(LanMo lanMo){
        int i = lanMoMapper.updateLanMo(lanMo);
        if(i>0){
            return true;
        }else {
            return  false;
        }
    }

    public Boolean delLanMo(Long id){
        int i = lanMoMapper.delLanMo(id);
        if(i>0){
            return true;
        }else {
            return  false;
        }
    }
}
