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
        List<MouldInfo> mouldInfoList = new ArrayList<>();
        String picUrls = mouldInfo.getPicUrls();
        if (null != picUrls) {
            String[] picArray = picUrls.split("\\|");
            for (int i=0; i < picArray.length; i++) {
                MouldInfo mouldInfo1 = new MouldInfo();
                mouldInfo1.setUpdateTime(new Date());
                mouldInfo1.setAddUserId(mouldInfo.getAddUserId());
                mouldInfo1.setAddUserName(mouldInfo.getAddUserName());
                mouldInfo1.setCreateTime(new Date());
                mouldInfo1.setMouldNum(1);
                mouldInfo1.setPicUrls(picArray[i]);
                mouldInfo1.setMouldName("模具");
                mouldInfo1.setOrderId(mouldInfo.getOrderId());
                mouldInfo1.setRemark(mouldInfo.getRemark());
                mouldInfo1.setSelected(false);
                mouldInfo1.setSelectId(mouldInfo.getSelectId());
                mouldInfo1.setShouMoId(mouldInfo.getShouMoId());
                mouldInfo1.setStatus(mouldInfo.getStatus());
                mouldInfo1.setDeleted(false);
                mouldInfoList.add(mouldInfo1);
            }
            // 批量添加

        }
        return mouldInfoMapper.addMoulds(mouldInfoList);
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

    public List<MouldPartTreeResp> getCaiMould(Integer days){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar endTime =  Calendar.getInstance();
        Calendar begainTime = Calendar.getInstance();
        // 结束时间
        endTime.set(Calendar.HOUR_OF_DAY,23);
        endTime.set(Calendar.MINUTE,59);
        endTime.set(Calendar.SECOND,59);
        endTime.set(Calendar.MILLISECOND,59);
        String endTime1 = sdf.format(endTime.getTime());

        begainTime.add(Calendar.DATE ,-days);
        begainTime.set(Calendar.HOUR_OF_DAY,0);
        begainTime.set(Calendar.MINUTE,0);
        begainTime.set(Calendar.SECOND,0);
        begainTime.set(Calendar.MILLISECOND,0);
        String begainTime1 = sdf.format(begainTime.getTime());


        List<ShouMoListResp> list = shouMoListMapper.getCaiMoMoulds(begainTime1, endTime1);
        // List<MouldInfo> unSelect = mouldInfoMapper.getUnSelect(begainTime1);
        List<MouldPartTreeResp> resp = new ArrayList<>();
        if(null != list && list.size()>0){
            resp = this.toFilter(days, list);
        }
//        if(null != unSelect && unSelect.size()>0){
//            resp = this.filterUnselect(unSelect, resp);
//        }
        return resp;
    }

    public List<MouldPartTreeResp> getByTimeNew(Integer days){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar endTime =  Calendar.getInstance();
        Calendar begainTime = Calendar.getInstance();
        // 结束时间
        endTime.set(Calendar.HOUR_OF_DAY,23);
        endTime.set(Calendar.MINUTE,59);
        endTime.set(Calendar.SECOND,59);
        endTime.set(Calendar.MILLISECOND,59);
        String endTime1 = sdf.format(endTime.getTime());

        begainTime.add(Calendar.DATE ,-days);
        begainTime.set(Calendar.HOUR_OF_DAY,0);
        begainTime.set(Calendar.MINUTE,0);
        begainTime.set(Calendar.SECOND,0);
        begainTime.set(Calendar.MILLISECOND,0);
        String begainTime1 = sdf.format(begainTime.getTime());


        List<ShouMoListResp> list = shouMoListMapper.getShouMoByTime2(begainTime1, endTime1);
        List<MouldInfo> unSelect = mouldInfoMapper.getUnSelect(begainTime1);
        List<MouldPartTreeResp> resp = new ArrayList<>();
        if(null != list && list.size()>0){
            resp = this.toFilter(days, list);
        }
        if(null != unSelect && unSelect.size()>0){
            resp = this.filterUnselect(unSelect, resp);
        }
        return resp;
    }

    public List<MouldPartTreeResp> filterUnselect(List<MouldInfo> unSelectResp, List<MouldPartTreeResp> select){
        List<MouldPartChildrenResp> resps = new ArrayList<>();
      //  for (ShouMoListResp shouMoListResp : unSelectResp) {

                if(unSelectResp != null && unSelectResp.size()>0){
                    List<TreeMouldInfoResp> treeMouldInfoResps = new ArrayList<>();
                    for (MouldInfo part: unSelectResp){
                        TreeMouldInfoResp treeMouldInfoResp = new TreeMouldInfoResp();
                        treeMouldInfoResp.setDisabled(part.getSelected());
                        treeMouldInfoResp.setLabel(part.getMouldName());
                        treeMouldInfoResp.setId(part.getId());
                        treeMouldInfoResp.setCollectPartinfoEntity(part);
                        treeMouldInfoResps.add(treeMouldInfoResp);
                    }
                    MouldPartChildrenResp mouldPartChildrenResp = new MouldPartChildrenResp();

                    mouldPartChildrenResp.setLabel("请校验");
                    mouldPartChildrenResp.setId(10000000L);
                    mouldPartChildrenResp.setDisabled(true);
                    // 设置本批次下所有的模具节点
                    mouldPartChildrenResp.setChildren(treeMouldInfoResps);
                    resps.add(mouldPartChildrenResp);
                }
        //}

        if(null != resps && resps.size()>0){
            MouldPartTreeResp mouldPartTreeResp = new MouldPartTreeResp();
            mouldPartTreeResp.setLabel("历史未被选择集合");
            mouldPartTreeResp.setId((select.size() + 1 )+"");
            mouldPartTreeResp.setDisabled(true);
            mouldPartTreeResp.setChildren(resps);
            select.add(mouldPartTreeResp);
        }
        return select;

    }



    public List<MouldPartTreeResp> toFilter( Integer days, List<ShouMoListResp> list){
        List<MouldPartTreeResp> reslist = new ArrayList<>();
        for(int i= 0;i<days; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar nowTime =  Calendar.getInstance();
            Calendar endTime = Calendar.getInstance();
            // 结束时间
            nowTime.add(Calendar.DATE ,-i);
            nowTime.set(Calendar.HOUR_OF_DAY,0);
            nowTime.set(Calendar.MINUTE,0);
            nowTime.set(Calendar.SECOND,0);
            nowTime.set(Calendar.MILLISECOND,0);
            String begainTime = sdf.format(nowTime.getTime());

            endTime.add(Calendar.DATE ,-i);
            endTime.set(Calendar.HOUR_OF_DAY,23);
            endTime.set(Calendar.MINUTE,59);
            endTime.set(Calendar.SECOND,59);
            endTime.set(Calendar.MILLISECOND,59);
            String endTime1 = sdf.format(endTime.getTime());

            // 获取当天的收模列表 --按批次排序
                List<MouldPartChildrenResp> resps = new ArrayList<>();
                for (ShouMoListResp shouMoList : list) {
                    Date createTime = shouMoList.getCreateTime();
                    Calendar compareTime = Calendar.getInstance();
                    compareTime.setTime(createTime);
                    if ((compareTime.getTimeInMillis() - endTime.getTimeInMillis()) <= 0 && (compareTime.getTimeInMillis()-nowTime.getTimeInMillis()) >=0) {

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
        return reslist;
    }

    public List<MouldInfo> getMouldOrderId(Long orderId){
        return  mouldInfoMapper.getByOrderId(orderId);
    }
}
