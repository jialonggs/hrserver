package org.sang.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.ShouMoList;
import org.sang.mapper.ShouMoListMapper;
import org.sang.utils.DateFormatUtil;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ShouMoService {

    @Autowired
    ShouMoListMapper shouMoListMapper;

    public List<ShouMoList> getShouMoList() {
        return shouMoListMapper.getShouMoList();
    }

    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<ShouMoList> getShouMoListByPage(PageInfoEntity pageInfoEntity) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<ShouMoList> list = shouMoListMapper.getShouMoList();
        PageInfo page = new PageInfo(list);
        PageBean<ShouMoList> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }


    /**
     *
     * @param dateTime
     * @return
     */
    public Integer getMaxBatch (String dateTime){
        String begainTime = DateFormatUtil.stringToString(dateTime, DateFormatUtil.YYYY_MM_DD);
        Date dayOfTime = DateFormatUtil.stringToDate(begainTime,DateFormatUtil.YYYY_MM_DD);
        Calendar endTime = DateFormatUtil.dateToCalendar(dayOfTime);
        endTime.add(Calendar.DATE, 1);
        Date endOfTime = endTime.getTime();
        String endTimeString = DateFormatUtil.dateToString(endOfTime, DateFormatUtil.YYYY_MM_DD);
        List<ShouMoList> list = shouMoListMapper.getShouMoByTime(begainTime, endTimeString);
        if( list == null ){
            return 0;
        }else {
            return  list.size();
        }
    }

    /**
     *
     * @param shouMoList
     * @return
     */
    public Long addBaseInfo(ShouMoList shouMoList) {
        shouMoListMapper.createShouMo(shouMoList);
        return shouMoList.getId();
    }


    public int updateShouMo(ShouMoList shouMoList) {
        Date updateTime = new Date();
        shouMoList.setUpdateTime(updateTime);
        return shouMoListMapper.updateShouMo(shouMoList);
    }

    public ShouMoList getById(Integer id) {
        return shouMoListMapper.getById(id);
    }

}
