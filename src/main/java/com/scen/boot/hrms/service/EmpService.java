package com.scen.boot.hrms.service;

import com.scen.boot.hrms.model.Employee;
import com.scen.boot.hrms.model.Nation;
import com.scen.boot.hrms.model.Politicsstatus;

import java.text.ParseException;
import java.util.List;

/**
 * @author Scen
 * @date 2019/11/16 13:26
 */
public interface EmpService {
    
    List<Nation> getAllNations();
    
    List<Politicsstatus> getAllPolitics();
    
    int addEmp(Employee employee);
    
    Long getMaxWorkID();
    
    List<com.scen.boot.hrms.dto.Employee> getEmployeeByPage(
            Integer page,
            Integer size,
            String keywords,
            String politicId,
            String nationId,
            String posId,
            String jobLevelId,
            String engageForm,
            String departmentId,
            String beginDateScope
    ) throws ParseException;
    
    
    Long getCountByKeywords(
            String keywords,
            String politicId,
            String nationId,
            String posId,
            String jobLevelId,
            String engageForm,
            String departmentId,
            String beginDateScope
    ) throws ParseException;
    
    
    int updateEmp(Employee employee);
    
    
    boolean deleteEmpById(String ids);
    
    
    List<com.scen.boot.hrms.dto.Employee> getAllEmployees();
    
    int addEmps(List<Employee> emps);
    
    
    List<com.scen.boot.hrms.dto.Employee> getEmployeeListShort(Integer page, Integer size);
}
