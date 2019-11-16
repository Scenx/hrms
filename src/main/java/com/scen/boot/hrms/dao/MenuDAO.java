package com.scen.boot.hrms.dao;

import com.scen.boot.hrms.basedao.BaseDAO;
import com.scen.boot.hrms.model.Menu;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/14 17:58
 */
public interface MenuDAO extends BaseDAO<Menu> {
    
    
    
    
    List<com.scen.boot.hrms.dto.Menu> getAllMenu();
    
    
    List<com.scen.boot.hrms.dto.Menu> getMenusByHrId(String hrId);
}
