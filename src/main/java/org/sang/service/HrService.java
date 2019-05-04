package org.sang.service;

import org.sang.bean.AppPic;
import org.sang.bean.Hr;
import org.sang.bean.Role;
import org.sang.bean.responseEntity.UserInfoResp;
import org.sang.common.HrUtils;
import org.sang.mapper.AppPicMapper;
import org.sang.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@Transactional
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;

    @Autowired
    AppPicMapper appPicMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(s);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return hr;
    }



//    public int hrReg(String username, String password,String name,String phone,String userface,String empId,String remark) {
//        //如果用户名存在，返回错误
//        if (hrMapper.loadUserByUsername(username) != null) {
//            return -1;
//        }
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encode = encoder.encode(password);
//        return hrMapper.hrReg(username, encode,name,phone,userface,empId,remark);
//    }
public Long hrReg(Hr hr) {
    //如果用户名存在，返回错误
    String username = hr.getUsername();
    if (hrMapper.loadUserByUsername(username) != null) {
        return null;
    }
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String password = hr.getPassword();
    String encode = encoder.encode(password);
    hr.setPassword(encode);
    hrMapper.hrReg(hr);
    return hr.getId();
}

    public List<Hr> getHrsByKeywords(String keywords) {
        return hrMapper.getHrsByKeywords(keywords);
    }

    public int updateHr(Hr hr) {
        return hrMapper.updateHr(hr);
    }

    public int updateHrRoles(Long hrId, Long[] rids) {
        int i = hrMapper.deleteRoleByHrId(hrId);
        return hrMapper.addRolesForHr(hrId, rids);
    }

    public Hr getHrById(Long hrId) {
        return hrMapper.getHrById(hrId);
    }

    public UserInfoResp getHrByUserInfo(Long userId){
        return hrMapper.getUserInfo(userId);
    }

    public int deleteHr(Long hrId) {
        return hrMapper.deleteHr(hrId);
    }

    public List<Hr> getAllHrExceptAdmin() {
        return hrMapper.getAllHr(HrUtils.getCurrentHr().getId());
    }
    public List<Hr> getAllHr() {
        return hrMapper.getAllHr(null);
    }


    public List<Hr> getHrByPage(Integer page, Integer size, String keywords) {
        int start = (page - 1) * size;
        return hrMapper.getHrsByKeywords(start, size, keywords);
    }


    public List<Hr> getAllHrs() {
        return hrMapper.getAllHrs();
    }

    public Long getCountByKeywords(String keywords) {
        return hrMapper.getCountByKeywords(keywords);
    }

    public List<Hr> getByRole(String roleName) {
        return hrMapper.getByRole(roleName);
    }

    public Boolean updatePassword( String newPassword, Long userId){
        int i = hrMapper.updatePassword(newPassword, userId);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean addPrivate(String privateStr, Long userId){
        int i = hrMapper.updatePrivateStr(privateStr, userId);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }


    public Boolean addPic(String picUrls){
        AppPic select = appPicMapper.getAppPic();
        if(null == select){
            AppPic newApp = new AppPic();
            newApp.setUrl(picUrls);
            appPicMapper.addPicUrl(newApp);
        }else{
            appPicMapper.updatePicUrl(select.getId(), picUrls);
        }

        return  true;
    }

    public AppPic geAppPic(){
        return  appPicMapper.getAppPic();
    }

    public Boolean isHavePower(Long userId, String[] roles) {
        UserInfoResp userInfoResp = this.getHrByUserInfo(userId);
        Boolean flag = false;
        if (null != userInfoResp) {
            List<Role> userRoles = userInfoResp.getRoles();
            if(null != userRoles && !userRoles.isEmpty()) {
                for (Role role : userRoles) {
                    for (String roleName : roles) {
                        if (role.getName().equals(roleName)) {
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

}
