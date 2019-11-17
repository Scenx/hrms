package com.scen.boot.hrms.service;

import com.scen.boot.hrms.model.Role;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/17 13:15
 */
public interface RoleService {
    
    List<Role> roles();
    
    int addNewRole(String role, String roleZh);
    
    int deleteRoleById(String rid);
}
