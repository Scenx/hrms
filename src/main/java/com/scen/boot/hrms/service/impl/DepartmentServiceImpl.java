package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.DepartmentDAO;
import com.scen.boot.hrms.model.Department;
import com.scen.boot.hrms.service.DepartmentService;
import com.scen.boot.hrms.utils.SnowflakeIdWorker;
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
    
    private final SnowflakeIdWorker snowflakeIdWorker;
    
    public DepartmentServiceImpl(
            DepartmentDAO departmentDAO,
            SnowflakeIdWorker snowflakeIdWorker
    ) {
        this.departmentDAO = departmentDAO;
        this.snowflakeIdWorker = snowflakeIdWorker;
    }
    
    
    @Override
    public int addDep(Department department) {
        Department parentDepartment = departmentDAO.selectByPrimaryKey(department.getParentId());
        department.setId(snowflakeIdWorker.nextId());
        department.setEnabled(1);
        department.setIsParent(0);
        department.setDepPath(parentDepartment.getDepPath()+"."+department.getId());
        
        parentDepartment.setIsParent(1);
        departmentDAO.updateByPrimaryKeySelective(parentDepartment);
        
        return departmentDAO.insert(department);
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
        return departmentDAO.getAllDeps();
    }
    
    @Override
    public Department getDepById(String departmentId) {
        return departmentDAO.selectByPrimaryKey(departmentId);
    }
}
