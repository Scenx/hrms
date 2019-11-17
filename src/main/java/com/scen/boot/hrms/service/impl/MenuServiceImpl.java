package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.MenuDAO;
import com.scen.boot.hrms.dto.Menu;
import com.scen.boot.hrms.service.MenuService;
import com.scen.boot.hrms.utils.HrUtils;
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
    
    @Override
    public List<Menu> getMenusByHrId() {
        return menuDAO.getMenusByHrId(HrUtils.getCurrentHr().getId());
    }
    
    @Override
    public List<Menu> menuTree() {
        return menuDAO.menuTree();
    }
    
    @Override
    public List<Integer> getMenusByRid(String rid) {
        return menuDAO.getMenusByRid(rid);
    }
}
