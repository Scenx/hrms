package com.scen.boot.hrms.dao;

import com.scen.boot.hrms.basedao.BaseDAO;
import com.scen.boot.hrms.model.Joblevel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/14 17:58
 */
public interface JoblevelDAO extends BaseDAO<Joblevel> {
    
    
    @Select("select * from joblevel WHERE enabled=true;")
    List<Joblevel> getAllJobLevels();
}
