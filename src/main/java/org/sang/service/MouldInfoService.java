package org.sang.service;

import org.sang.bean.MouldInfo;
import org.sang.bean.ShouMoList;
import org.sang.bean.responseEntity.MouldPartChildrenResp;
import org.sang.bean.responseEntity.MouldPartTreeResp;
import org.sang.bean.responseEntity.ShouMoListResp;
import org.sang.bean.responseEntity.TreeMouldInfoResp;
import org.sang.mapper.MouldInfoMapper;
import org.sang.mapper.ShouMoListMapper;
import org.sang.utils.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MouldInfoService {

    @Autowired
    MouldInfoMapper mouldInfoMapper;

    @Autowired
    ShouMoListMapper shouMoListMapper;

    public int addMouldInfo (MouldInfo mouldInfo){
        return mouldInfoMapper.addMouldInfo(mouldInfo);
    }

    public List<MouldInfo> getMouldInfoList (Long shouMoId){
        return mouldInfoMapper.getMouldInfoByShouMoId(shouMoId);
    }

    public int updateMouldInfo(MouldInfo mouldInfo){
        return mouldInfoMapper.updateMouldInfo(mouldInfo);
    }

    public MouldInfo getMouldById(Long id){
        return mouldInfoMapper.getMouldById(id);
    }


    public List<MouldInfo> getMouldOfDay(Integer days) throws Exception{
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         Calendar endTime = Calendar.getInstance();
         endTime.add(Calendar.DATE, -days);
         String end = sdf.format(endTime.getTime());
         Date begainTime = sdf.parse(end);
         Date nowTime = new Date();
         List<MouldInfo> list = mouldInfoMapper.getMouldByTime(begainTime, nowTime);
         return list;

    }

    public List<MouldInfo> selectBy(String mouldName, String addUserName){
        return mouldInfoMapper.selectBy(mouldName, addUserName);
    }

    public List<MouldPartTreeResp> getCollectInfosByTime(Integer days) {
        return this.getByTime(days);
    }

    public List<MouldPartTreeResp> getByTime( Integer days){
        List<MouldPartTreeResp> reslist = new ArrayList<>();
        for(int i= 0;i<days; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar nowTime =  Calendar.getInstance();
            Calendar endTime = Calendar.getInstance();
            // 结束时间
            nowTime.add(Calendar.DATE ,-i);
            nowTime.set(Calendar.HOUR,0);
            nowTime.set(Calendar.MINUTE,0);
            nowTime.set(Calendar.SECOND,0);
            nowTime.set(Calendar.MILLISECOND,0);
            String begainTime = sdf.format(nowTime.getTime());

            endTime.add(Calendar.DATE ,-i);
            endTime.set(Calendar.HOUR,23);
            endTime.set(Calendar.MINUTE,59);
            endTime.set(Calendar.SECOND,59);
            endTime.set(Calendar.MILLISECOND,59);
            String endTime1 = sdf.format(endTime.getTime());

            // 获取当天的收模列表 --按批次排序
            List<ShouMoListResp> list = shouMoListMapper.getShouMoByTime2(begainTime, endTime1);
            if(null !=list && list.size()>0){
                List<MouldPartChildrenResp> resps = new ArrayList<>();
                for (ShouMoListResp shouMoList : list) {

                    Long id = shouMoList.getId();
                    String  companyName = shouMoList.getClientCompanyName();

                    // 获取该批次中所有模具列表 按时间排序
                    List<MouldInfo> partList = shouMoList.getMouldInfos();
                    if(partList != null && partList.size()>0){
                        List<TreeMouldInfoResp> treeMouldInfoResps = new ArrayList<>();
                        for (MouldInfo part: partList){
                            TreeMouldInfoResp treeMouldInfoResp = new TreeMouldInfoResp();
                            treeMouldInfoResp.setDisabled(part.getSelected());
                            treeMouldInfoResp.setLabel(part.getMouldName());
                            treeMouldInfoResp.setId(part.getId());
                            treeMouldInfoResp.setCollectPartinfoEntity(part);
                            treeMouldInfoResps.add(treeMouldInfoResp);
                        }
                        MouldPartChildrenResp mouldPartChildrenResp = new MouldPartChildrenResp();
                        if(companyName == null || companyName.isEmpty()){
                            companyName = "无";
                        }
                        mouldPartChildrenResp.setLabel(shouMoList.getBatch()+ "(" +companyName+")");
                        mouldPartChildrenResp.setId(shouMoList.getId());
                        mouldPartChildrenResp.setDisabled(true);
                        // 设置本批次下所有的模具节点
                        mouldPartChildrenResp.setChildren(treeMouldInfoResps);
                        resps.add(mouldPartChildrenResp);

                    }
                }
                // 设置该天
                if(null != resps &&resps.size()>0){
                    MouldPartTreeResp mouldPartTreeResp = new MouldPartTreeResp();
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    String label = sdf1.format(nowTime.getTime());
                    mouldPartTreeResp.setId(i+"");
                    mouldPartTreeResp.setLabel(label);
                    mouldPartTreeResp.setDisabled(true);
                    mouldPartTreeResp.setChildren(resps);
                    reslist.add(mouldPartTreeResp);
                }
            }
        }
        return reslist;

    }
}
