package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.MenuDAO;
import com.scen.boot.hrms.dto.Menu;
import com.scen.boot.hrms.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/14 18:44
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService {
    
    private final MenuDAO menuDAO;
    
    
    public MenuServiceImpl(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }
    
    @Override
    public List<Menu> getAllMenu(){
        return menuDAO.getAllMenu();
    }
}
