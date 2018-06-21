package org.sang.controller.work;

import com.alibaba.fastjson.JSONObject;
import org.sang.bean.Flow;
import org.sang.bean.FlowSteps;
import org.sang.bean.Step;
import org.sang.bean.YuProduct;
import org.sang.bean.requestEntity.YuProductRquest;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.FlowStepsResp;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.FlowService;
import org.sang.service.FlowStepsService;
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
@RequestMapping(value = "/work/flow")
public class FlowController extends BaseController{
    @Autowired
    FlowService flowService;

    @Autowired
    FlowStepsService flowStepsService;


    /**
     * 添加流程基本信息
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponseEntity addWuliao(Flow flow){
        if(null == flow  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        Long i = flowService.addFlow(flow);
        if (i > 0) {
            map.put("id", i);
            return  succResult(map);
        } else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 添加步骤与流程关系
     * @param
     * @return
     */
    @RequestMapping(value = "/add/steps", method = RequestMethod.POST)
    public BaseResponseEntity addProduct(String  steps) {
        if(null == steps ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }

        List<FlowSteps> list = new ArrayList<>();
        String[] strings = steps.split("\\|");

        for (String item : strings) {
            FlowSteps flowSteps = JSONObject.parseObject(item, FlowSteps.class);
            list.add(flowSteps);
        }
        int i = flowStepsService.addFlowSteps(list);
        if(i > 0){
            return succResult();
        }else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    /**
     * 获取默认流程
     */
    @RequestMapping(value = "/list/steps", method = RequestMethod.GET)
    public BaseResponseEntity selectAll() {
        List<FlowStepsResp> list = new ArrayList<>();
        list = flowService.selectALL();
        Map<String, Object> map = new HashMap<>();
        map.put("flowlist",list);
       return  succResult(map);
    }



}
