package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.HrDAO;
import com.scen.boot.hrms.dto.Hr;
import com.scen.boot.hrms.service.HrService;
import com.scen.boot.hrms.utils.HrUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/14 19:28
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HrServiceImpl implements HrService {
    
    private final HrDAO hrDAO;
    
    public HrServiceImpl(HrDAO hrDAO) {
        this.hrDAO = hrDAO;
    }
    
    
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrDAO.loadUserByUsername(s);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return hr;
    }
    
    
    @Override
    public List<Hr> getAllHrExceptAdmin() {
        return hrDAO.getAllHr(HrUtils.getCurrentHr().getId());
    }
}
