package com.scen.boot.hrms.dao;

import com.scen.boot.hrms.basedao.BaseDAO;
import com.scen.boot.hrms.model.Hr;
import com.scen.boot.hrms.model.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/14 17:57
 */
public interface HrDAO extends BaseDAO<Hr> {
    
    
    
    @Select("select * from hr WHERE username=#{username}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "id", property = "roles", many = @Many(select = "com.scen.boot.hrms.dao.HrDAO.getRolesByHrId"))
    })
    com.scen.boot.hrms.dto.Hr loadUserByUsername(String username);
    
    
    @Select("SELECT r.* FROM hr_role h,role r where h.rid=r.id AND h.hrid=#{id}")
    List<Role> getRolesByHrId(String id);
    
    
    @Select("<script>" +
            "select * from hr\n" +
            "   <if test=\"currentId != null and currentId != ''\">\n" +
            "            WHERE id !=#{currentId}\n" +
            "        </if>"+
            "</script>")
    List<com.scen.boot.hrms.dto.Hr> getAllHr(@Param("currentId") String currentId);
}
