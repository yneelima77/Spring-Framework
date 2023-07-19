package com.springSecurity.userRegistration.myServices;

import com.springSecurity.userRegistration.model.Role;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {

    public void saveRole(Role role);
    public Role findRoleByRoleName(String name);
    public List<Role> getAllRoles();
    public List<Role> getRolesByUser(long id);

}
