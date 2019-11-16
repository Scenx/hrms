package com.scen.boot.hrms.service;

import com.scen.boot.hrms.model.Joblevel;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/16 14:34
 */
public interface JobLevelService {
    int addJobLevel(Joblevel joblevel);
    
    List<Joblevel> getAllJobLevels();
    
    
    boolean deleteJobLevelById(String ids);
    
    
    int updateJobLevel(Joblevel joblevel);
}
