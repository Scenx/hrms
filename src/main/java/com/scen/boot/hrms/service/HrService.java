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
}
