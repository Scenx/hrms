package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.EmpsalaryDAO;
import com.scen.boot.hrms.dao.SalaryDAO;
import com.scen.boot.hrms.model.Empsalary;
import com.scen.boot.hrms.model.Salary;
import com.scen.boot.hrms.service.SalaryService;
import com.scen.boot.hrms.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;

/**
 * @author Scen
 * @date 2019/11/17 12:02
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SalaryServiceImpl implements SalaryService {
    
    private final SalaryDAO salaryDAO;
    private final EmpsalaryDAO empsalaryDAO;
    private final SnowflakeIdWorker snowflakeIdWorker;
    
    public SalaryServiceImpl(
            SalaryDAO salaryDAO,
            SnowflakeIdWorker snowflakeIdWorker,
            EmpsalaryDAO empsalaryDAO
    ) {
        this.salaryDAO = salaryDAO;
        this.snowflakeIdWorker = snowflakeIdWorker;
        this.empsalaryDAO = empsalaryDAO;
    }
    
    
    @Override
    public int addSalary(Salary salary) {
        salary.setId(snowflakeIdWorker.nextId());
        return salaryDAO.insert(salary);
    }
    
    @Override
    public List<Salary> getAllSalary() {
        return salaryDAO.selectAll();
    }
    
    @Override
    public int updateSalary(Salary salary) {
        return salaryDAO.updateByPrimaryKeySelective(salary);
    }
    
    @Override
    public boolean deleteSalary(String ids) {
        String[] split = ids.split(",");
        Example example = new Example(Salary.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", Arrays.asList(split));
        return salaryDAO.deleteByExample(example)== split.length;
    }
    
    @Override
    public int updateEmpSalary(Empsalary empsalary) {
        Example example = new Example(Empsalary.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("eid", empsalary.getEid());
        empsalaryDAO.deleteByExample(example);
        empsalary.setId(snowflakeIdWorker.nextId());
        return empsalaryDAO.insert(empsalary);
    }
}
