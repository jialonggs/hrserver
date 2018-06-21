package org.sang.controller;

import org.sang.bean.Hr;
import org.sang.bean.responseEntity.BaseResponseEntity;
import org.sang.bean.responseEntity.UserInfoResp;
import org.sang.config.ErrCodeMsg;
import org.sang.mapper.HrMapper;
import org.sang.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.util.resources.cldr.mg.LocaleNames_mg;

/**
 * Created by sang on 2017/12/29.
 */
@RestController
@RequestMapping("/personnel")
public class PersonnelController extends  BaseController{

    @Autowired
    HrService hrService;

    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public BaseResponseEntity getUserInfo(@RequestParam("userId") Long userId) {
        if(null == userId){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        UserInfoResp userInfoResp = hrService.getHrByUserInfo(userId);
        if(userInfoResp!=null){
            return succResult(userInfoResp);
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    @RequestMapping(value = "/update/password",method = RequestMethod.POST)
    public BaseResponseEntity updateUserPassword(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword,
                                                 @RequestParam("userId") Long userId){
        if(null == oldPassword || newPassword == null || null == userId){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Hr hr = hrService.getHrById(userId);
        if(null == hr){
            return badResult(ErrCodeMsg.SELECT_NULL);
        }
        String md5Password = hr.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(oldPassword, md5Password)){
            return badResult(ErrCodeMsg.OLD_PASSWORD_ERROR);
        }
        String newEncode = encoder.encode(newPassword);
        Boolean result = hrService.updatePassword( newEncode, userId);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

    @RequestMapping(value = "/add/private",method = RequestMethod.POST)
    public BaseResponseEntity updateUserPrivateStr(@RequestParam("privateStr") String privateStr,
                                                 @RequestParam("userId") Long userId,
                                                   @RequestParam("password") String password){
        if(null == privateStr ||  null == userId){
            return badResult(ErrCodeMsg.ARGS_MISSING);
        }
        Hr hr = hrService.getHrById(userId);
        if(null == hr){
            return badResult(ErrCodeMsg.SELECT_NULL);
        }
        String md5Password = hr.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(password, md5Password)){
            return badResult(ErrCodeMsg.OLD_PASSWORD_ERROR);
        }
        Boolean result = hrService.addPrivate( privateStr, userId);
        if(result){
            return succResult();
        }else{
            return badResult(ErrCodeMsg.COMMON_FAIL);
        }
    }

}
