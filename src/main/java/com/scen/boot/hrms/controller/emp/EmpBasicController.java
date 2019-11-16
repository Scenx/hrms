package com.scen.boot.hrms.controller.emp;

import com.scen.boot.hrms.dto.Employee;
import com.scen.boot.hrms.dto.ScenResult;
import com.scen.boot.hrms.model.Position;
import com.scen.boot.hrms.service.DepartmentService;
import com.scen.boot.hrms.service.EmpService;
import com.scen.boot.hrms.service.JobLevelService;
import com.scen.boot.hrms.service.PositionService;
import com.scen.boot.hrms.utils.EmailRunnable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * Created by sang on 2018/1/12.
 */
@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {
    private final EmpService empService;
    private final DepartmentService departmentService;
    private final PositionService positionService;
    private final JobLevelService jobLevelService;
    private final ExecutorService executorService;
    private final TemplateEngine templateEngine;
    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private  String emailAddress;
    
    public EmpBasicController(
            EmpService empService,
            DepartmentService departmentService,
            PositionService positionService,
            JobLevelService jobLevelService,
            ExecutorService executorService,
            TemplateEngine templateEngine,
            JavaMailSender javaMailSender
    ) {
        this.empService = empService;
        this.departmentService = departmentService;
        this.positionService = positionService;
        this.jobLevelService = jobLevelService;
        this.executorService = executorService;
        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;
    }
    
    @RequestMapping(value = "/basicdata", method = RequestMethod.GET)
    public Map<String, Object> getAllNations() {
        Map<String, Object> map = new HashMap<>(6);
        map.put("nations", empService.getAllNations());
        map.put("politics", empService.getAllPolitics());
        map.put("deps", departmentService.getDepByPid("-1"));
        map.put("positions", positionService.getAllPos());
        map.put("joblevels", jobLevelService.getAllJobLevels());
        map.put("workID", String.format("%08d", empService.getMaxWorkID() + 1));
        return map;
    }

    @RequestMapping("/maxWorkID")
    public String maxWorkID() {
        return String.format("%08d", empService.getMaxWorkID() + 1);
    }
    
    
    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public Map<String, Object> getEmployeeByPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "") String keywords,
            String politicId, String nationId, String posId,
            String jobLevelId, String engageForm,
            String departmentId, String beginDateScope) throws ParseException {
        Map<String, Object> map = new HashMap<>(2);
        List<Employee> employeeByPage = empService.getEmployeeByPage(page, size,
                keywords,politicId, nationId, posId, jobLevelId, engageForm,
                departmentId, beginDateScope);
        Long count = empService.getCountByKeywords(keywords, politicId, nationId,
                posId,jobLevelId, engageForm, departmentId, beginDateScope);
        map.put("emps", employeeByPage);
        map.put("count", count);
        return map;
    }
    
    
    @RequestMapping(value = "/exportEmp", method = RequestMethod.GET)
    public ScenResult exportEmp() {
        List<Employee> allEmployees = empService.getAllEmployees();
        return ScenResult.ok(allEmployees, "要导出自行实行easyexcel的BaseRowModel");
    }
    
    
    @RequestMapping(value = "/importEmp", method = RequestMethod.POST)
    public ScenResult importEmp(MultipartFile file) {
        return ScenResult.build(500,"要批量导入自行实现easyexcel的解析");
    }
    
    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public ScenResult updateEmp(com.scen.boot.hrms.model.Employee employee) {
        if (empService.updateEmp(employee) == 1) {
            return ScenResult.ok(null,"更新成功!");
        }
        return ScenResult.build(500,"更新失败!");
    }
    
    
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public ScenResult addEmp(com.scen.boot.hrms.model.Employee employee) {
        if (empService.addEmp(employee) == 1) {
            Employee employeeSend = new Employee();
            BeanUtils.copyProperties(employee,employeeSend);
            List<Position> allPos = positionService.getAllPos();
            for (Position allPo : allPos) {
                if (allPo.getId().equals(employee.getPosId())) {
                    employeeSend.setPosName(allPo.getName());
                }
            }
            executorService.execute(new EmailRunnable(employeeSend,
                    javaMailSender, templateEngine,emailAddress));
            return ScenResult.ok(null,"添加成功!");
        }
        return ScenResult.build(500,"添加失败!");
    }
    
    
    
    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    public ScenResult deleteEmpById(@PathVariable String ids) {
        if (empService.deleteEmpById(ids)) {
            return ScenResult.ok(null,"删除成功!");
        }
        return ScenResult.build(500,"删除失败!");
    }
}
