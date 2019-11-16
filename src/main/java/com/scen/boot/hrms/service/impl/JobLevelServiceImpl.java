package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.JoblevelDAO;
import com.scen.boot.hrms.model.Joblevel;
import com.scen.boot.hrms.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/16 14:35
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class JobLevelServiceImpl implements JobLevelService {
    
    private final JoblevelDAO joblevelDAO;
    
    public JobLevelServiceImpl(
            JoblevelDAO joblevelDAO
    ) {
        this.joblevelDAO = joblevelDAO;
    }
    
    @Override
    public int addJobLevel(Joblevel joblevel) {
        return 0;
    }
    
    @Override
    public List<Joblevel> getAllJobLevels() {
        return joblevelDAO.getAllJobLevels();
    }
    
    @Override
    public boolean deleteJobLevelById(String ids) {
        return false;
    }
    
    @Override
    public int updateJobLevel(Joblevel joblevel) {
        return 0;
    }
}
