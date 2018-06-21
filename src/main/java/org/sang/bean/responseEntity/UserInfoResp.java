package org.sang.bean.responseEntity;

import org.sang.bean.Employee;
import org.sang.bean.Hr;
import org.sang.bean.Role;

import java.util.List;

public class UserInfoResp  extends Hr{

    private Employee employee;

    private List<Role> roles;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public List<Role> getRoles() {
        return roles;
    }

    @Override
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
