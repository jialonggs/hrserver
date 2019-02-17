package org.sang.controller.kaipiao;

import org.sang.bean.FaMo;
import org.sang.bean.KaiPiao;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.Project;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.KaiPiaoService;
import org.sang.service.ProjectService;
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
@RequestMapping("/kai/piao")
public class KaiPiaoController extends BaseController{

    @Autowired
    KaiPiaoService kaiPiaoService;

    @Autowired
    ProjectService projectService;


    /**
     * 添加项目开票申请
     * @param kaiPiao
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponseEntity addKaiPiao(KaiPiao kaiPiao){
        if (null == kaiPiao){
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
        //校验是否所有金钱已开票
        Project project = projectService.getByProjectById(kaiPiao.getProjectId());
        if(null == project){
            return badResult(ErrCodeMsg.PROJECT_IS_NULL_ERROR);
        }
        if(Integer.parseInt(project.getFinanceBiLi()) < 100){
            // 设置开票类型
            kaiPiao.setKaiPiaoType(1);
        }
        if(project.getNeedKaiPiao() == 0){
            return badResult(ErrCodeMsg.PROJECT_NEED_KAIPIAO_ERROR);
        }
        if(( project.getNeedKaiPiao() - Double.parseDouble(kaiPiao.getJinE())) < 0){
            return badResult(ErrCodeMsg.PROJECT_KAIPIAO_MONEY);
        }
        Boolean result = kaiPiaoService.addKaiPiao(kaiPiao,project);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 开票列表
     * @return
     */
    @RequestMapping(value = "/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getYuBaoJiaList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                              @RequestParam(value = "status") Integer status, @RequestParam(value = "type",required = false) Integer type) {
        if(null == status ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<KaiPiao> famolist = new ArrayList<>();
        PageBean<KaiPiao> list = kaiPiaoService.getKaiPiaoList(pageInfoEntity, status, type);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            famolist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("famolist", famolist);
        return succResult(map);
    }


//    @RequestMapping(value = "/check", method = RequestMethod.POST)
//    public  BaseResponseEntity checkShangwu(@RequestParam("id") Long id,@RequestParam("status") Integer status,
//                                            @RequestParam("auditId") Integer auditId,
//                                            @RequestParam("auditName") String auditName,
//                                            @RequestParam(value = "auditRemark",required = false) String auditRemark){
//        if(null == id  || null == status) {
//            return badResult(ErrCodeMsg.ARGS_MISSING);
//        }
//        int i = kaiPiaoService.auditKaiPiao(id, status, auditId, auditName, auditRemark);
//        if(i>0){
//            return succResult();
//        }else {
//            return badResult(ErrCodeMsg.COMMON_FAIL);
//        }
//    }


    /**
     *
     * @param kaiPiao
     * @return
     */
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public  BaseResponseEntity checkShangwu(KaiPiao kaiPiao){
        if(null == kaiPiao  || null == kaiPiao) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Boolean i = kaiPiaoService.checkKaiPiao(kaiPiao);
        if(i){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


}
