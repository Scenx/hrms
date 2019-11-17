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
    
    
    @Select("select * from hr where id =#{hrId}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "id", property = "roles", many = @Many(select = "com.scen.boot.hrms.dao.HrDAO.getRolesByHrId"))
    })
    com.scen.boot.hrms.dto.Hr getHrById(String hrId);
    
    @Select("<script>" +
            "select h.* from ((`hr` `h` left join `hr_role`\n" +
            "        `h_r` on ((`h`.`id` = `h_r`.`hrid`))) left join `role` `r` on ((`h_r`.`rid` = `r`.`id`))) where h.`id` not\n" +
            "        in(select h_r.`hrid` from hr_role h_r,role r where h_r.`rid`=r.`id` and r.`nameZh`='系统管理员')\n" +
            "        <if test=\"keywords!='all' and keywords!=''\">\n" +
            "            and h.`name` like concat('%',#{keywords},'%')\n" +
            "        </if>\n" +
            "group by h.`id`" +
            "        order by h.`id` limit 10" +
            "</script>")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "id", property = "roles", many = @Many(select = "com.scen.boot.hrms.dao.HrDAO.getRolesByHrId"))
    })
    List<com.scen.boot.hrms.dto.Hr> getHrsByKeywords(String keywords);
}
