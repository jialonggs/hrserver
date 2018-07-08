package org.sang.controller.finance;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.BusinessBaoJia;
import org.sang.bean.Order;
import org.sang.bean.PageInfoEntity;
import org.sang.bean.Project;
import org.sang.bean.requestEntity.AddFuKuanRequest;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.BusinessBaoJiaService;
import org.sang.service.OrderService;
import org.sang.service.ProjectService;
import org.sang.service.StorageService;
import org.sang.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/finance/")
public class FinanceController extends BaseController{

    @Autowired
    OrderService orderService;

    @Autowired
    StorageService storageService;

    @Autowired
    ProjectService projectService;

    @Autowired
    BusinessBaoJiaService businessBaoJiaService;

    /**
     * 查询项目列表
     * @return
     */
    @RequestMapping(value = "/auth/listbypage", method = RequestMethod.GET)
    public BaseResponseEntity getOrdersList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                                            @RequestParam(value = "financeStatus",required = false) Integer financeStatus) {


        Map<String, Object> map = new HashMap<>();
        PageInfoEntity pageInfoEntity = new PageInfoEntity();
        pageInfoEntity.setCurrentPage(page);
        pageInfoEntity.setPagesize(size);
        List<Project> orderslist = new ArrayList<>();
        PageBean<Project> list = projectService.getFinanceProject(pageInfoEntity, financeStatus);
        if(null != list && list.getItems()!=null && list.getItems().size() !=0){
            orderslist = list.getItems();
            map.put("count",list.getPageInfo().getTotal());
        }
        map.put("putorderlist", orderslist);
        return succResult(map);
    }

    @RequestMapping(value = "/auth/add", method = RequestMethod.POST)
    public BaseResponseEntity addFuKuan(@RequestBody AddFuKuanRequest addFuKuanRequest){
        if(null == addFuKuanRequest){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }

        if(null == addFuKuanRequest.getFinanceTime()){
            addFuKuanRequest.setFinanceTime(new Date());
        }

        Boolean result = projectService.addFuKuan(addFuKuanRequest);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    @RequestMapping(value = "/auth/unpay", method = RequestMethod.POST)
    public BaseResponseEntity updateWeiFuKuan(@Param("financeStatus") Integer financeStatus,
    @Param("projectId") Long projectId){
        if(null == financeStatus || null == projectId){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        AddFuKuanRequest addFuKuanRequest = new AddFuKuanRequest();
        addFuKuanRequest.setFinanceStatus(1);
        addFuKuanRequest.setProjectId(projectId);
        Boolean result = projectService.addFuKuan(addFuKuanRequest);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }


    /**
     * 添加预报价产品信息
     * @param
     * @return
     */
    @RequestMapping(value = "/auth/get/order/business", method = RequestMethod.GET)
    public BaseResponseEntity addProjectProduct(@RequestParam("projectId") Long projectId){
        if(null == projectId) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }


        BusinessBaoJia i = businessBaoJiaService.getProjectBuInfo(projectId);

        if(i != null){
            return succResult(i);
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

}
