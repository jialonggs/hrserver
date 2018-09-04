package org.sang.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.Car;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.ProcessUnit;
import org.sang.bean.requestEntity.UnitRequest;
import org.sang.mapper.ProcessUnitMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProcessUnitService {

    @Autowired
    ProcessUnitMapper processUnitMapper;

    /**
     * 添加加工单位
     * @param processUnit
     * @return
     */
    @Transactional
    public Boolean addUnit(UnitRequest processUnit){
        int i = processUnitMapper.addUnit(processUnit);
        if(i>0){
            int y =  processUnitMapper.addCarForUnit(processUnit.getId(), processUnit.getCarIds());
            if(y > 0){
                return true;
            }else{
                return false;
            }
        }else{
            return  false;
        }
    }

    /**
     *根据名称获取加工单位
     * @param name
     * @return
     */
    public ProcessUnit getByName(String name){
        return  processUnitMapper.getByName(name);
    }

    @Transactional
    public Boolean updateUnit(UnitRequest processUnit){
        int i = processUnitMapper.updateUnit(processUnit);
        if(i>0){
            processUnitMapper.deleteCarByUnitId(processUnit.getId());
            processUnitMapper.addCarForUnit(processUnit.getId(), processUnit.getCarIds());
            return  true;
        }else{
            return  false;
        }
    }

    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<ProcessUnit> getUnitList(PageInfoEntity pageInfoEntity) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<ProcessUnit> list = processUnitMapper.getUnitList();
        PageInfo page = new PageInfo(list);
        PageBean<ProcessUnit> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<ProcessUnit> getUnitListByCon(PageInfoEntity pageInfoEntity, String name, Long engineId, Long carId) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<ProcessUnit> list = processUnitMapper.getUnitList();
        PageInfo page = new PageInfo(list);
        PageBean<ProcessUnit> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    public List<ProcessUnit> getListByCarId(Long carId){
        return processUnitMapper.getListByCarId(carId);
    }

    public List<ProcessUnit> getAllUnitList(){
        return  processUnitMapper.getUnitList();
    }

}
