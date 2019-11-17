package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.MenuRoleDAO;
import com.scen.boot.hrms.service.MenuRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Scen
 * @date 2019/11/17 13:17
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuRoleServiceImpl implements MenuRoleService {
    
    private final MenuRoleDAO menuRoleDAO;
    
    public MenuRoleServiceImpl(MenuRoleDAO menuRoleDAO) {
        this.menuRoleDAO = menuRoleDAO;
    }
    
    @Override
    public int updateMenuRole(String rid, Integer[] mids) {
        return 0;
    }
}
