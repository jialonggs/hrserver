package org.sang.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.CaiMoList;
import org.sang.bean.MouldInfo;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.requestEntity.CaiMoListRequest;
import org.sang.bean.responseEntity.CaiMoListResp;
import org.sang.mapper.CaiMoMapper;
import org.sang.mapper.MouldInfoMapper;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaiMoService {

    @Autowired
    CaiMoMapper caiMoMapper;

    @Autowired
    MouldInfoMapper mouldInfoMapper;


    /**
     * 分页查询
     * @param pageInfoEntity
     * @return
     */
    public PageBean<CaiMoListResp> getShouMoListByPage(PageInfoEntity pageInfoEntity) {
        PageHelper.startPage(pageInfoEntity.getCurrentPage(),pageInfoEntity.getPagesize());
        List<CaiMoListResp> list = caiMoMapper.getCaiMoList();
        PageInfo page = new PageInfo(list);
        PageBean<CaiMoListResp> pageData = new PageBean<>();
        pageData.setItems(list);
        pageData.setPageInfo(page);
        return  pageData;
    }

    /**
     *
     * @param caiMoList
     * @return
     */
    public int addCaiMo(CaiMoList caiMoList){
        return caiMoMapper.addCaiMo(caiMoList);
    }

    /**
     *
     * @param caiMoListRequest
     * @return
     */
    public int addCaiMoNew(CaiMoListRequest caiMoListRequest){
        String mouldString = caiMoListRequest.getMouldString();
        String[] mouldIdArray = mouldString.split(",");
        List<CaiMoList> caiMoListList = new ArrayList<>();
        List<MouldInfo> mouldInfoList = new ArrayList<>();
        for (int i =0; i< mouldIdArray.length; i++) {
            CaiMoList caiMoList = new CaiMoList();
            MouldInfo mouldInfo = new MouldInfo();
            caiMoList.setAddUserId(caiMoListRequest.getAddUserId());
            caiMoList.setAddUserName(caiMoListRequest.getAddUserName());
            caiMoList.setCreateTime(caiMoListRequest.getCreateTime());
            caiMoList.setDeleted(false);
            caiMoList.setPicUrls(caiMoListRequest.getPicUrls());
            caiMoList.setRemark(caiMoListRequest.getRemark());
            caiMoList.setMouldId(Long.parseLong(mouldIdArray[i]));
            caiMoList.setWuSiWenNum(caiMoListRequest.getWuSiWenNum());
            caiMoList.setYouSiWenNum(caiMoListRequest.getYouSiWenNum());
            caiMoListList.add(caiMoList);
            //
            mouldInfo.setId(Long.parseLong(mouldIdArray[i]));
            mouldInfoList.add(mouldInfo);
        }

        // 更新状态
        mouldInfoMapper.updateCaiStatus(mouldInfoList);
        return caiMoMapper.addCaiMoList(caiMoListList);

    }

    public int updateCaiMoList(CaiMoList caiMoList){
        return caiMoMapper.updateCaiMo(caiMoList);
    }
}
