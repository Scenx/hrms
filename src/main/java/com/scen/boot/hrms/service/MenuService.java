package com.scen.boot.hrms.service;

import com.scen.boot.hrms.dto.Menu;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/14 18:44
 */
public interface MenuService {
    
    List<Menu> getAllMenu();
    
    List<Menu> getMenusByHrId();
    
    List<Menu> menuTree();
    
    List<Integer> getMenusByRid(String rid);
}
