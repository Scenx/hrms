package com.scen.boot.hrms.service.impl;

import com.github.pagehelper.PageHelper;
import com.scen.boot.hrms.dao.EmployeeDAO;
import com.scen.boot.hrms.dao.NationDAO;
import com.scen.boot.hrms.dao.PoliticsstatusDAO;
import com.scen.boot.hrms.model.Employee;
import com.scen.boot.hrms.model.Nation;
import com.scen.boot.hrms.model.Politicsstatus;
import com.scen.boot.hrms.service.EmpService;
import com.scen.boot.hrms.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Scen
 * @date 2019/11/16 13:26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmpServiceImpl implements EmpService {
    private final EmployeeDAO employeeDAO;
    private final NationDAO nationDAO;
    private final PoliticsstatusDAO politicsstatusDAO;
    private final SnowflakeIdWorker snowflakeIdWorker;
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    SimpleDateFormat birthdayFormat = new SimpleDateFormat("yyyy-MM-dd");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");
    
    public EmpServiceImpl(
            EmployeeDAO employeeDAO,
            NationDAO nationDAO,
            PoliticsstatusDAO politicsstatusDAO,
            SnowflakeIdWorker snowflakeIdWorker
    ) {
        this.employeeDAO = employeeDAO;
        this.nationDAO = nationDAO;
        this.politicsstatusDAO = politicsstatusDAO;
        this.snowflakeIdWorker = snowflakeIdWorker;
    }
    
    
    @Override
    public List<Nation> getAllNations() {
        return nationDAO.selectAll();
    }
    
    @Override
    public List<Politicsstatus> getAllPolitics() {
        return politicsstatusDAO.selectAll();
    }
    
    @Override
    public int addEmp(Employee employee) {
        employee.setWorkState("在职");
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        double contractTerm = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 + Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(contractTerm / 12)));
        employee.setId(snowflakeIdWorker.nextId());
        return employeeDAO.insert(employee);
    }
    
    @Override
    public Long getMaxWorkID() {
        Long maxWorkID = employeeDAO.getMaxWorkID();
        return maxWorkID == null ? 0 : maxWorkID;
    }
    
    @Override
    public List<com.scen.boot.hrms.dto.Employee> getEmployeeByPage(Integer page, Integer size, String keywords, String politicId, String nationId, String posId, String jobLevelId, String engageForm, String departmentId, String beginDateScope) throws ParseException {
        Date startBeginDate = null;
        Date endBeginDate = null;
        if (beginDateScope != null && beginDateScope.contains(",")) {
                String[] split = beginDateScope.split(",");
                startBeginDate = birthdayFormat.parse(split[0]);
                endBeginDate = birthdayFormat.parse(split[1]);
        }
        PageHelper.startPage(page, size, false);
        return employeeDAO.getEmployeeList(keywords, politicId, nationId, posId, jobLevelId, engageForm, departmentId, startBeginDate, endBeginDate);
    }
    
    @Override
    public Long getCountByKeywords(String keywords, String politicId, String nationId, String posId, String jobLevelId, String engageForm, String departmentId, String beginDateScope) throws ParseException {
        Date startBeginDate = null;
        Date endBeginDate = null;
        if (beginDateScope != null && beginDateScope.contains(",")) {
                String[] split = beginDateScope.split(",");
                startBeginDate = birthdayFormat.parse(split[0]);
                endBeginDate = birthdayFormat.parse(split[1]);
        }
        return employeeDAO.getCountByKeywords(keywords, politicId, nationId, posId, jobLevelId, engageForm, departmentId, startBeginDate, endBeginDate);
    }
    
    @Override
    public int updateEmp(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        double contractTerm = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 + Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(contractTerm / 12)));
        return employeeDAO.updateByPrimaryKeySelective(employee);
    }
    
    @Override
    public boolean deleteEmpById(String ids) {
        String[] split = ids.split(",");
        Example example = new Example(Employee.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", Arrays.asList(split));
        return employeeDAO.deleteByExample(example) == split.length;
    }
    
    @Override
    public List<com.scen.boot.hrms.dto.Employee> getAllEmployees() {
        return employeeDAO.getEmployeeList("",null,null,null,null,null,null,null,null);
    }
    
    @Override
    public int addEmps(List<Employee> emps) {
        return 0;
    }
    
    @Override
    public List<com.scen.boot.hrms.dto.Employee> getEmployeeListShort(Integer page, Integer size) {
        return null;
    }
    
    
}
