package com.scen.boot.hrms.dao;

import com.scen.boot.hrms.basedao.BaseDAO;
import com.scen.boot.hrms.dto.SysMsg;
import com.scen.boot.hrms.model.Sysmsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/14 18:02
 */
public interface SysmsgDAO extends BaseDAO<Sysmsg> {
    
    
    List<SysMsg> getSysMsg(@Param("hrid") String hrid);
    
    
    int markRead(@Param("flag") String flag, @Param("hrid") String hrid);
    
    
}
