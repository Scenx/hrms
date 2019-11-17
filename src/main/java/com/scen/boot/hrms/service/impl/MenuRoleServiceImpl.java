package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.MenuRoleDAO;
import com.scen.boot.hrms.model.MenuRole;
import com.scen.boot.hrms.service.MenuRoleService;
import com.scen.boot.hrms.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author Scen
 * @date 2019/11/17 13:17
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuRoleServiceImpl implements MenuRoleService {
    
    private final MenuRoleDAO menuRoleDAO;
    
    private final SnowflakeIdWorker snowflakeIdWorker;
    
    public MenuRoleServiceImpl(
            MenuRoleDAO menuRoleDAO,
            SnowflakeIdWorker snowflakeIdWorker
    ) {
        this.menuRoleDAO = menuRoleDAO;
        this.snowflakeIdWorker = snowflakeIdWorker;
    }
    
    @Override
    public int updateMenuRole(String rid, Integer[] mids) {
        Example example = new Example(MenuRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("rid", rid);
        menuRoleDAO.deleteByExample(example);
        if (mids.length == 0) {
            return 0;
        }
        MenuRole menuRole = new MenuRole();
        menuRole.setRid(rid);
        for (Integer mid : mids) {
            menuRole.setId(snowflakeIdWorker.nextId());
            menuRole.setMid(mid);
            menuRoleDAO.insert(menuRole);
        }
        return mids.length;
    }
}
