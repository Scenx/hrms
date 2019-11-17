package com.scen.boot.hrms.service;

import com.scen.boot.hrms.model.Empsalary;
import com.scen.boot.hrms.model.Salary;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/17 12:01
 */
public interface SalaryService {
    
    
    int addSalary(Salary salary);
    
    List<Salary> getAllSalary();
    
    int updateSalary(Salary salary);
    
    
    boolean deleteSalary(String ids);
    
    
    int updateEmpSalary(Empsalary empsalary);
}
