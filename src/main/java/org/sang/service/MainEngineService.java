package org.sang.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.Car;
import org.sang.bean.MainEngine;
import org.sang.bean.PageInfoEntity;
import org.sang.mapper.MainEngineMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainEngineService {

    @Autowired
    MainEngineMapper mainEngineMapper;

    public MainEngine getByName(String name){
        return  mainEngineMapper.getByName(name);
    }

    public MainEngine getById(Long id){
        return  mainEngineMapper.getById(id);
    }


    public Boolean addMainEngine(String name, String addUserName, String addUserId ,String remark){
        MainEngine mainEngine = new MainEngine();
        mainEngine.setName(name);
        mainEngine.setAddUserName(addUserName);
        mainEngine.setAddUserId(addUserId);
        mainEngine.setRemark(remark);
        int i = mainEngineMapper.addMainEngine(mainEngine);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<MainEngine> getEngineList(PageInfoEntity pageInfoEntity) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<MainEngine> list = mainEngineMapper.getEngineList();
        PageInfo page = new PageInfo(list);
        PageBean<MainEngine> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    public Boolean updateEngine(String name, String updateUserId, Long id, String remark){
        MainEngine mainEngine = mainEngineMapper.getById(id);
        if(null == mainEngine) {
            return false;
        }
        mainEngine.setName(name);
        mainEngine.setRemark(remark);
        int i = mainEngineMapper.updateEngine(mainEngine);
        if(i > 0){
            return  true;
        }else{
            return  false;
        }
    }

    public List<MainEngine> getAll(){
        return mainEngineMapper.getEngineList();
    }
}
