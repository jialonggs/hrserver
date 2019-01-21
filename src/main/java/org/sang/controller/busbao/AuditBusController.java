package org.sang.controller.busbao;

import org.sang.bean.BusinessBaoJia;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.Role;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.BusInfoResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.BusinessBaoJiaService;
import org.sang.service.SendMessageService;
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
@RequestMapping(value = "/audit/bus")
public class AuditBusController extends BaseController{

    @Autowired
    BusinessBaoJiaService businessBaoJiaService;

    @Autowired
    SendMessageService sendMessageService;


    /**
     * 审核商务报价列表
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
        List<BusinessBaoJia> auditbusbaojialist = new ArrayList<>();
        PageBean<BusinessBaoJia> list = businessBaoJiaService.getAuditBusinessbaoJiaList(pageInfoEntity, audit);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            auditbusbaojialist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("auditbusbaojialist", auditbusbaojialist);
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
        BusInfoResp busInfoResp = businessBaoJiaService.getById(id);
        map.put("businfo", busInfoResp);
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
        BusinessBaoJia businessBaoJia = businessBaoJiaService.getById(id);
        String remark = "";
        if(null != businessBaoJia.getRejectRemark()){
            remark = businessBaoJia.getRejectRemark()+"|" +rejectRemark;
        }else{
            remark = rejectRemark;
        }
        int i = businessBaoJiaService.auditBus(id, audit, auditId, auditName, remark, businessBaoJia.getProjectId());
        if(i>0){
            String msg = "";
            if(audit == 1){
                msg = "您提交的商务报价单 ，审核通过";
            }else {
                msg = "您提交的商务报价单 ，被驳回";
            }
            String title = "商务报价单审核";
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
