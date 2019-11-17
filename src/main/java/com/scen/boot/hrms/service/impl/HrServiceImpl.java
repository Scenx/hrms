package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.HrDAO;
import com.scen.boot.hrms.dao.HrRoleDAO;
import com.scen.boot.hrms.dto.Hr;
import com.scen.boot.hrms.model.HrRole;
import com.scen.boot.hrms.service.HrService;
import com.scen.boot.hrms.utils.HrUtils;
import com.scen.boot.hrms.utils.SnowflakeIdWorker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/14 19:28
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HrServiceImpl implements HrService {
    
    private final HrDAO hrDAO;
    private final HrRoleDAO hrRoleDAO;
    private final SnowflakeIdWorker snowflakeIdWorker;
    
    public HrServiceImpl(
            HrDAO hrDAO,
            HrRoleDAO hrRoleDAO,
            SnowflakeIdWorker snowflakeIdWorker
    ) {
        this.hrDAO = hrDAO;
        this.hrRoleDAO = hrRoleDAO;
        this.snowflakeIdWorker = snowflakeIdWorker;
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
    
    @Override
    public Hr getHrById(String hrId) {
        return hrDAO.getHrById(hrId);
    }
    
    @Override
    public int deleteHr(String hrId) {
        return hrDAO.deleteByPrimaryKey(hrId);
    }
    
    @Override
    public int updateHr(com.scen.boot.hrms.model.Hr hr) {
        return hrDAO.updateByPrimaryKeySelective(hr);
    }
    
    @Override
    public int updateHrRoles(String hrId, String[] rids) {
        Example example = new Example(HrRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("hrid", hrId);
        hrRoleDAO.deleteByExample(example);
        HrRole hrRole = new HrRole();
        hrRole.setHrid(hrId);
        for (String rid : rids) {
            hrRole.setId(snowflakeIdWorker.nextId());
            hrRole.setRid(rid);
            hrRoleDAO.insert(hrRole);
        }
        return rids.length;
    }
    
    @Override
    public List<Hr> getHrsByKeywords(String keywords) {
        return hrDAO.getHrsByKeywords(keywords);
    }
    
    @Override
    public int hrReg(String username, String password) {
        //如果用户名存在，返回错误
        if (hrDAO.loadUserByUsername(username) != null) {
            return -1;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        com.scen.boot.hrms.model.Hr hr = new com.scen.boot.hrms.model.Hr();
        hr.setId(snowflakeIdWorker.nextId());
        hr.setUsername(username);
        hr.setPassword(password);
        hr.setEnabled(1);
        return hrDAO.insert(hr);
    }
}
