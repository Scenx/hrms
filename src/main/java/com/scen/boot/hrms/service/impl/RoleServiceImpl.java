package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.RoleDAO;
import com.scen.boot.hrms.model.Role;
import com.scen.boot.hrms.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/17 13:15
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {
    
    private final RoleDAO roleDAO;
    
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
    
    @Override
    public List<Role> roles() {
        return roleDAO.roles();
    }
    @Override
    public int addNewRole(String role, String roleZh) {
        return 0;
    }
    
    @Override
    public int deleteRoleById(String rid) {
        return 0;
    }
}
