package org.sang.controller.work;

import org.sang.bean.Step;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.config.ErrCodeMsg;
import org.sang.controller.BaseController;
import org.sang.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/work/step")
public class StepController extends BaseController{

    @Autowired
    StepService stepService;

    /**
     * 添加步骤
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponseEntity addWuliao(Step step){
        if(null == step  ) {
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Map<String, Object> map = new HashMap<>();
        int i = stepService.addStep(step);
        if (i > 0) {
            return  succResult();
        } else {
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }



    /**
     * 获取步骤列表
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResponseEntity getStepsList(){
        List<Step> list = stepService.getStepsList();
        Map<String, Object> map = new HashMap<>();
        map.put("steplist", list);
        return succResult(map);
    }


    /**
     * 删除步骤
     * @param id
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public BaseResponseEntity delStep(@RequestParam("id") Long id){
        int i = stepService.delStep(id);
        if(i>0){
            return succResult();
        }else {
            return  badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

}
