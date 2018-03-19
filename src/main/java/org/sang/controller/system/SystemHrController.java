package org.sang.controller.system;

import org.sang.bean.Hr;
import org.sang.bean.RespBean;
import org.sang.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sang on 2018/1/2.
 */
@RestController
@RequestMapping("/system/hr")
public class SystemHrController {
    @Autowired
    HrService hrService;

    @RequestMapping("/id/{hrId}")
    public Hr getHrById(@PathVariable Long hrId) {
        return hrService.getHrById(hrId);
    }

    @RequestMapping(value = "/{hrId}", method = RequestMethod.DELETE)
    public RespBean deleteHr(@PathVariable Long hrId) {
        if (hrService.deleteHr(hrId) == 1) {
            return new RespBean("success", "删除成功!");
        }
        return new RespBean("error", "删除失败!");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RespBean updateHr(Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return new RespBean("success", "更新成功!");
        }
        return new RespBean("error", "更新失败!");
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT)
    public RespBean updateHrRoles(Long hrId, Long[] rids) {
        if (hrService.updateHrRoles(hrId, rids) == rids.length) {
            return new RespBean("success", "更新成功!");
        }
        return new RespBean("error", "更新失败!");
    }

    @RequestMapping("/{keywords}")
    public List<Hr> getHrsByKeywords(@PathVariable(required = false) String keywords) {
        List<Hr> hrs = hrService.getHrsByKeywords(keywords);
        return hrs;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "") String keywords) {
        Map<String, Object> map = new HashMap<>();
        List<Hr> hrByPage = hrService.getHrByPage(page, size, keywords);
        Long count = hrService.getCountByKeywords(keywords);
        map.put("hrs", hrByPage);
        map.put("count", count);
        return map;
    }


//    @RequestMapping(value = "/hr/reg", method = RequestMethod.POST)
//    public RespBean hrReg(String username, String password) {
//        int i = hrService.hrReg(username, password);
//        if (i == 1) {
//            return new RespBean("success", "注册成功!");
//        } else if (i == -1) {
//            return new RespBean("error", "用户名重复，注册失败!");
//        }
//        return new RespBean("error", "注册失败!");
//    }

    /**
     * 添加操作人员
     * @param hr
     * @return
     */
    @RequestMapping(value = "/hr/register", method = RequestMethod.PUT)
    public Map<String, Object> hrRegister(Hr hr) {
        Map<String, Object> map = new HashMap<>();
        Long i = hrService.hrReg(hr);
        if(i== null){
            map.put("id",-1);
            return map;
        }
        if (i >= 1) {
            map.put("id",i);
            return  map;
        }
        map.put("id",-2);
        return map;
    }

}
