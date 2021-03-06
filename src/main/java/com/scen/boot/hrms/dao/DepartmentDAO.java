package com.scen.boot.hrms.dao;

import com.scen.boot.hrms.basedao.BaseDAO;
import com.scen.boot.hrms.model.Department;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/14 17:55
 */
public interface DepartmentDAO extends BaseDAO<Department> {
    
    
    
    List<com.scen.boot.hrms.dto.Department> getDepByPid(String pid);
    
    @Select("select * from department WHERE enabled=true")
    List<com.scen.boot.hrms.dto.Department> getAllDeps();
    
    
    
    int addDep(Department department);
}
