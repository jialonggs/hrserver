package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.Hr;
import org.sang.bean.Role;
import org.sang.bean.responseEntity.UserInfoResp;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
public interface HrMapper {
    Hr loadUserByUsername(String username);

    List<Role> getRolesByHrId(Long id);

//    int hrReg(@Param("username") String username, @Param("password") String password,
//              @Param("name") String name, @Param("phone") String phone, @Param("userface") String userface, @Param("empId") String empId,
//              @Param("remark") String remark);
    int hrReg(Hr hr);

    List<Hr> getHrsByKeywords(@Param("keywords") String keywords);

    List<Hr> getAllHrs();

    int updateHr(Hr hr);

    int deleteRoleByHrId(Long hrId);

    int addRolesForHr(@Param("hrId") Long hrId, @Param("rids") Long[] rids);

    Hr getHrById(Long hrId);

    int deleteHr(Long hrId);

    List<Hr> getAllHr(@Param("currentId") Long currentId);

    List<Hr> getHrsByKeywords(@Param("start") Integer start, @Param("size") Integer size, @Param("keywords") String keywords);

    Long getCountByKeywords(@Param("keywords") String keywords);

    List<Hr> getByRole(@Param("roleName") String roleName);

    UserInfoResp getUserInfo(@Param("userId") Long userId);

    int updatePassword(@Param("password") String password, @Param("userId") Long userId);

    int updatePrivateStr(@Param("privateStr") String privateStr, @Param("userId") Long userId);


}
