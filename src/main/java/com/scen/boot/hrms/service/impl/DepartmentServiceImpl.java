package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.DepartmentDAO;
import com.scen.boot.hrms.model.Department;
import com.scen.boot.hrms.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/16 14:29
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentServiceImpl implements DepartmentService {
    
    private final DepartmentDAO departmentDAO;
    
    public DepartmentServiceImpl(
            DepartmentDAO departmentDAO
    ) {
        this.departmentDAO = departmentDAO;
    }
    
    
    @Override
    public int addDep(Department department) {
        return 0;
    }
    
    @Override
    public int deleteDep(String did) {
        return 0;
    }
    
    @Override
    public List<com.scen.boot.hrms.dto.Department> getDepByPid(String pid) {
        return departmentDAO.getDepByPid(pid);
    }
    
    @Override
    public List<com.scen.boot.hrms.dto.Department> getAllDeps() {
        return null;
    }
}
