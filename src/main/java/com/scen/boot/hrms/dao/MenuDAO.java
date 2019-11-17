package com.scen.boot.hrms.dao;

import com.scen.boot.hrms.basedao.BaseDAO;
import com.scen.boot.hrms.model.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/14 17:58
 */
public interface MenuDAO extends BaseDAO<Menu> {
    
    
    
    
    List<com.scen.boot.hrms.dto.Menu> getAllMenu();
    
    
    List<com.scen.boot.hrms.dto.Menu> getMenusByHrId(String hrId);
    
    List<com.scen.boot.hrms.dto.Menu> menuTree();
    
    @Select("SELECT mid from menu_role WHERE rid=#{rid}")
    List<Integer> getMenusByRid(String rid);
}
