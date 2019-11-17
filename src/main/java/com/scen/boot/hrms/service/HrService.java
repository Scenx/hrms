package com.scen.boot.hrms.service;

import com.scen.boot.hrms.dto.Hr;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/14 19:28
 */
public interface HrService extends UserDetailsService {
    
    
    List<Hr> getAllHrExceptAdmin();
    
    
    Hr getHrById(String hrId);
    
    int deleteHr(String hrId);
    
    
    int updateHr(com.scen.boot.hrms.model.Hr hr);
    
    
    int updateHrRoles(String hrId, String[] rids);
    
    
    List<Hr> getHrsByKeywords(String keywords);
    
    
    int hrReg(String username, String password);
}
