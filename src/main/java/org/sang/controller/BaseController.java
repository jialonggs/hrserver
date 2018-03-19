package org.sang.controller;

import com.alibaba.fastjson.JSONObject;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.config.ErrCodeMsg;



/**
 * @author 丁欢
 * @date 2016-07-18
 * @email
 */
public class BaseController {

    public BaseResponseEntity badResult(ErrCodeMsg err) {
        BaseResponseEntity json = new BaseResponseEntity();
        json.setCode(err.code());
        json.setMessage(err.msg());
        return json;
    }

    public BaseResponseEntity badResult(int code, String msg) {
        BaseResponseEntity json = new BaseResponseEntity();
        json.setCode(code);
        json.setMessage(msg);
        return json;
    }

    public BaseResponseEntity badResult(Object data) {
        BaseResponseEntity json = new BaseResponseEntity();
        json.setCode(107);
        json.setMessage("操作失败");
        json.setData(data);
        return json;
    }

    public BaseResponseEntity succResult(Object data) {
        BaseResponseEntity json = new BaseResponseEntity();
        json.setCode(0);
        json.setMessage("success");
        json.setData(data);
        return json;
    }

    public BaseResponseEntity succResult() {
        BaseResponseEntity json = new BaseResponseEntity();
        json.setCode(0);
        json.setMessage("success");
        json.setData("");
        return json;
    }
}
