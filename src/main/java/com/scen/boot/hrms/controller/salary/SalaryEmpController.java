package com.scen.boot.hrms.controller.salary;

import com.scen.boot.hrms.dto.Employee;
import com.scen.boot.hrms.dto.ScenResult;
import com.scen.boot.hrms.model.Empsalary;
import com.scen.boot.hrms.model.Salary;
import com.scen.boot.hrms.service.EmpService;
import com.scen.boot.hrms.service.SalaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by
 */
@RestController
@RequestMapping("/salary/sobcfg")
public class SalaryEmpController {
    private final SalaryService salaryService;
    private final EmpService empService;
    
    public SalaryEmpController(SalaryService salaryService, EmpService empService) {
        this.salaryService = salaryService;
        this.empService = empService;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ScenResult updateEmpSalary(Empsalary empsalary) {
        if (salaryService.updateEmpSalary(empsalary) == 1) {
            return ScenResult.ok(null,"修改成功!");
        }
        return ScenResult.build(500,"修改失败!");
    }
    
    @RequestMapping(value = "/salaries", method = RequestMethod.GET)
    public List<Salary> salaries() {
        return salaryService.getAllSalary();
    }
    
    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public Map<String, Object> getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) throws ParseException {
        Map<String, Object> map = new HashMap<>(2);
        List<Employee> employeeByPage = empService.getEmployeeListShort(page, size);
        Long count = empService.getCountByKeywords("", null, null, null, null, null, null, null);
        map.put("emps", employeeByPage);
        map.put("count", count);
        return map;
    }
}
