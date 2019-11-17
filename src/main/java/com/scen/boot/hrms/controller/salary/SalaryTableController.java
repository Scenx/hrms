package com.scen.boot.hrms.controller.salary;

import com.scen.boot.hrms.dto.Department;
import com.scen.boot.hrms.service.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by
 */
@RestController
@RequestMapping("/salary/table")
public class SalaryTableController {
    private final DepartmentService departmentService;
    
    public SalaryTableController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    
    @RequestMapping("/deps")
    public List<Department> departments() {
        return departmentService.getAllDeps();
    }
}
