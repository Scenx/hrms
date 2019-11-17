package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.JoblevelDAO;
import com.scen.boot.hrms.model.Joblevel;
import com.scen.boot.hrms.service.JobLevelService;
import com.scen.boot.hrms.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Scen
 * @date 2019/11/16 14:35
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class JobLevelServiceImpl implements JobLevelService {
    
    private final JoblevelDAO joblevelDAO;
    
    private final SnowflakeIdWorker snowflakeIdWorker;
    
    public JobLevelServiceImpl(
            JoblevelDAO joblevelDAO,
            SnowflakeIdWorker snowflakeIdWorker
    ) {
        this.joblevelDAO = joblevelDAO;
        this.snowflakeIdWorker = snowflakeIdWorker;
    }
    
    @Override
    public int addJobLevel(Joblevel joblevel) {
        Example example = new Example(Joblevel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", joblevel.getName());
        int jcount = joblevelDAO.selectCountByExample(example);
        if (jcount > 0) {
            return -1;
        }
        joblevel.setId(snowflakeIdWorker.nextId());
        joblevel.setEnabled(1);
        joblevel.setCreateDate(new Date());
        return joblevelDAO.insert(joblevel);
    }
    
    @Override
    public List<Joblevel> getAllJobLevels() {
        return joblevelDAO.getAllJobLevels();
    }
    
    @Override
    public boolean deleteJobLevelById(String ids) {
        String[] split = ids.split(",");
        Example example = new Example(Joblevel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", Arrays.asList(split));
        return joblevelDAO.deleteByExample(example) == split.length;
    }
    
    @Override
    public int updateJobLevel(Joblevel joblevel) {
        Example example = new Example(Joblevel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", joblevel.getName());
        int jcount = joblevelDAO.selectCountByExample(example);
        if (jcount > 0) {
            return -1;
        }
        return joblevelDAO.updateByPrimaryKeySelective(joblevel);
    }
}
