package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.RoleDAO;
import com.scen.boot.hrms.model.Role;
import com.scen.boot.hrms.service.RoleService;
import com.scen.boot.hrms.utils.SnowflakeIdWorker;
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
    
    private final SnowflakeIdWorker snowflakeIdWorker;
    
    public RoleServiceImpl(
            RoleDAO roleDAO,
            SnowflakeIdWorker snowflakeIdWorker
    ) {
        this.roleDAO = roleDAO;
        this.snowflakeIdWorker = snowflakeIdWorker;
    }
    
    @Override
    public List<Role> roles() {
        return roleDAO.roles();
    }
    @Override
    public int addNewRole(String role, String roleZh) {
        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }
        Role roleI = new Role();
        roleI.setId(snowflakeIdWorker.nextId());
        roleI.setName(role);
        roleI.setNameZh(roleZh);
        return roleDAO.insert(roleI);
    }
    
    @Override
    public int deleteRoleById(String rid) {
        return roleDAO.deleteByPrimaryKey(rid);
    }
}
