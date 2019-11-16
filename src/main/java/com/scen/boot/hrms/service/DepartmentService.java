package com.scen.boot.hrms.service;

import com.scen.boot.hrms.model.Department;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/16 14:29
 */
public interface DepartmentService {
    
    int addDep(Department department);
    
    int deleteDep(String did);
    
    List<com.scen.boot.hrms.dto.Department> getDepByPid(String pid);
    
    List<com.scen.boot.hrms.dto.Department> getAllDeps();
    
    Department getDepById(String departmentId);
}
