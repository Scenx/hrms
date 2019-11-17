package com.scen.boot.hrms.controller.salary;

import com.scen.boot.hrms.dto.ScenResult;
import com.scen.boot.hrms.model.Salary;
import com.scen.boot.hrms.service.SalaryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 工资账套配置
 */
@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    private final SalaryService salaryService;
    
    public SalaryController(
            SalaryService salaryService
    ) {
        this.salaryService = salaryService;
    }
    
    @RequestMapping(value = "/salary", method = RequestMethod.POST)
    public ScenResult addSalaryCfg(Salary salary) {
        if (salaryService.addSalary(salary) == 1) {
            return ScenResult.ok(null, "添加成功!");
        }
        return ScenResult.build(500, "添加失败!");
    }
    
    @RequestMapping(value = "/salary", method = RequestMethod.GET)
    public List<Salary> salaries() {
        return salaryService.getAllSalary();
    }
    
    @RequestMapping(value = "/salary", method = RequestMethod.PUT)
    public ScenResult updateSalary(Salary salary) {
        if (salaryService.updateSalary(salary) == 1) {
            return ScenResult.ok(null, "更新成功!");
        }
        return ScenResult.build(500, "更新失败!");
    }
    
    @RequestMapping(value = "/salary/{ids}", method = RequestMethod.DELETE)
    public ScenResult deleteSalary(@PathVariable String ids) {
        if (salaryService.deleteSalary(ids)) {
            return ScenResult.ok(null, "删除成功!");
        }
        return ScenResult.build(500, "删除失败!");
    }
    
}
