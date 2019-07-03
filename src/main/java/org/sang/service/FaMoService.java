package org.sang.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.FaMo;
import org.sang.bean.FaMoInfo;
import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.responseEntity.FaMoOrder;
import org.sang.bean.responseEntity.FaMoResponse;
import org.sang.mapper.FaMoInfoMapper;
import org.sang.mapper.FaMoMapper;
import org.sang.mapper.OrderMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FaMoService {

    @Autowired
    FaMoMapper faMoMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    FaMoInfoMapper faMoInfoMapper;



    @Transactional
    public Boolean addFaMo(FaMo faMo){
        // 全款发模
        if(faMo.getFaMoType() == 2){
            faMo.setStatus("2");
        }
        int i = faMoMapper.addFaMo(faMo);
        if(i>0){
            orderMapper.updateFaMoStatus( 1, faMo.getOrderId());
            return true;
        }else{
            return false;
        }
    }

    public Boolean updateFaMo(FaMo faMo){
        faMo.setStatus(0+"");
        int i = faMoMapper.updateFaMo(faMo);
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
    public PageBean<FaMo> getAllFaMo(PageInfoEntity pageInfoEntity, Integer status) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<FaMo> list = faMoMapper.getAllFaMo(status);
        PageInfo page = new PageInfo(list);
        PageBean<FaMo> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<FaMoOrder> getZhunBei(PageInfoEntity pageInfoEntity, Integer addUserId, Integer storageStatus, Integer faMoStatus) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<FaMoOrder> list = orderMapper.getNeedFaMo(addUserId, storageStatus, faMoStatus);
        PageInfo page = new PageInfo(list);
        PageBean<FaMoOrder> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<FaMo> getWait(PageInfoEntity pageInfoEntity, Integer addUserId) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<FaMo> list = faMoMapper.getWaitFaMo(addUserId);
        PageInfo page = new PageInfo(list);
        PageBean<FaMo> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<FaMo> getByStatus(PageInfoEntity pageInfoEntity, Integer status) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<FaMo> list = faMoMapper.getAllFaMo(status);
        PageInfo page = new PageInfo(list);
        PageBean<FaMo> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    public FaMoResponse getById(Long id){
        return faMoMapper.getFaMo(id);
    }

    @Transactional
    public int auditFaMo(Long id, Integer status, Integer auditId, String auditName){
        int i = 0;
        if(status == -1 || status == 1){
           i = faMoMapper.aduitFaMo(id, status+"", auditId, auditName,null,null);
        }else{
            i = faMoMapper.aduitFaMo(id, status+"", null, null, auditId, auditName);
        }
        return i;
    }

    /**
     *
     * @param faMoInfo
     * @return
     */
    @Transactional
    public Boolean addFaMoInfo(FaMoInfo faMoInfo){
        try {
            String ids = faMoInfo.getIds();
            String[] orderIds = ids.split(",");
            int i = faMoInfoMapper.addFaMoInfo(faMoInfo);
            if( i>0 ){
                for(String id : orderIds){
                    Integer inId = Integer.parseInt(id);
                    faMoMapper.updateFaMoStatus(inId, 3, faMoInfo.getId());
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    public Boolean queRen(Integer id, Integer cheJian){
        FaMo faMo = faMoMapper.getById(Long.parseLong(id+""));
        orderMapper.updateFaMoOverStatus(faMo.getOrderId(), 1);
        int i = faMoMapper.queRen(id, cheJian);
        if (i>0) {
            return true;
        } else {
            return  false;
        }
    }
}
