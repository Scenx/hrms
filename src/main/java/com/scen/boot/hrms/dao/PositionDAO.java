package com.scen.boot.hrms.dao;

import com.scen.boot.hrms.basedao.BaseDAO;
import com.scen.boot.hrms.model.Position;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/14 17:59
 */
public interface PositionDAO extends BaseDAO<Position> {
    
    @Select("SELECT * FROM position WHERE enabled=true ORDER BY createDate desc")
    List<Position> getAllPos();
}
