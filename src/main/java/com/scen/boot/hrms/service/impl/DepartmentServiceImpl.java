package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.DepartmentDAO;
import com.scen.boot.hrms.dao.EmployeeDAO;
import com.scen.boot.hrms.model.Department;
import com.scen.boot.hrms.model.Employee;
import com.scen.boot.hrms.service.DepartmentService;
import com.scen.boot.hrms.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/16 14:29
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentServiceImpl implements DepartmentService {
    
    private final DepartmentDAO departmentDAO;
    
    private final EmployeeDAO employeeDAO;
    
    private final SnowflakeIdWorker snowflakeIdWorker;
    
    public DepartmentServiceImpl(
            DepartmentDAO departmentDAO,
            SnowflakeIdWorker snowflakeIdWorker,
            EmployeeDAO employeeDAO
    ) {
        this.departmentDAO = departmentDAO;
        this.snowflakeIdWorker = snowflakeIdWorker;
        this.employeeDAO = employeeDAO;
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
        Example example = new Example(Employee.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("departmentId", did);
        int ecount = employeeDAO.selectCountByExample(example);
        if (ecount > 0) {
            return -1;
        }
        Department oldDepartment = departmentDAO.selectByPrimaryKey(did);
    
        Example example1 = new Example(Department.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("id", did);
        criteria1.andEqualTo("isParent", 0);
        int result = departmentDAO.deleteByExample(example1);
        Example example2 = new Example(Department.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("parentId", oldDepartment.getParentId());
        int pcount = departmentDAO.selectCountByExample(example2);
        if (pcount == 0) {
            Department parentDepartment = new Department();
            parentDepartment.setId(oldDepartment.getParentId());
            parentDepartment.setIsParent(0);
            departmentDAO.updateByPrimaryKeySelective(parentDepartment);
        }
        return result;
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
