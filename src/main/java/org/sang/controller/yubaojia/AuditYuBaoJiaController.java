package org.sang.controller.yubaojia;

import org.sang.bean.PageInfoEntity;
import org.sang.bean.YuBaoJia;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.YuBaoJiaInfoResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.SendMessageService;
import org.sang.service.YuBaoJiaService;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/audit/per")
public class AuditYuBaoJiaController extends BaseController{

    @Autowired
    YuBaoJiaService yuBaoJiaService;

    @Autowired
    SendMessageService sendMessageService;

    /**
     * 审核预报价列表
     * @return
     */
    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getYuBaoJiaList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                              @RequestParam(value = "audit") Integer audit) {
        if(null == audit ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<YuBaoJia> audityubaojialist = new ArrayList<>();
        PageBean<YuBaoJia> list = yuBaoJiaService.getAuditYubaoJiaList(pageInfoEntity, audit);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            audityubaojialist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("audityubaojialist", audityubaojialist);
        return succResult(map);
    }


    /**
     * 获取详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public BaseResponseEntity getInfoById(@RequestParam("id") Long id){
        if(null == id ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        YuBaoJiaInfoResp yuInfoResp = yuBaoJiaService.getById(id);
        map.put("yuinfo", yuInfoResp);
        return succResult(map);

    }

    /**
     * 审核操作
     * @param id
     * @param audit
     * @return
     */
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public  BaseResponseEntity checkShangwu(@RequestParam("id") Long id,@RequestParam("audit") Integer audit,
                                            @RequestParam("auditId") Long auditId,
                                            @RequestParam("auditName") String auditName,
                                            @RequestParam("addUserId") Long addUserId,
                                            @RequestParam("rejectRemark") String rejectRemark){
        if(null == id  || null == audit) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        YuBaoJia yuBaoJia = yuBaoJiaService.getById(id);
        String remark = "";
        if(null != yuBaoJia.getRejectRemark()){
            remark = yuBaoJia.getRejectRemark()+"|" +rejectRemark;
        }else{
            remark = rejectRemark;
        }
//        Long auditItem = Long.parseLong(auditId+"");
        int i = yuBaoJiaService.auditYu(id, audit, auditId, auditName, remark);
        if(i>0){
            String msg = "";
            if(audit == 1){
                msg = "您提交的预报价单 ，审核通过";
            }else {
                msg = "您提交的预报价单 ，被驳回";
            }
            String title = "预报价单审核";
            List<Long> ids = new ArrayList<>();
            ids.add(addUserId);
            sendMessageService.toSendByIds(msg,title, ids);
            // 发送信息
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }

    }
}
