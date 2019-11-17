package com.scen.boot.hrms.dao;

import com.scen.boot.hrms.basedao.BaseDAO;
import com.scen.boot.hrms.model.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/14 18:01
 */
public interface RoleDAO extends BaseDAO<Role> {
    
    @Select("SELECT * FROM role where id!=6")
    List<Role> roles();
}
