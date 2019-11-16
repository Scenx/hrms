package com.scen.boot.hrms.dao;

import com.scen.boot.hrms.basedao.BaseDAO;
import com.scen.boot.hrms.model.Employee;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * @author Scen
 * @date 2019/11/14 17:56
 */
public interface EmployeeDAO extends BaseDAO<Employee> {
    
    
    @Select("SELECT workID from employee where id=(select max(id) from employee)")
    Long getMaxWorkID();
    
    List<com.scen.boot.hrms.dto.Employee> getEmployeeList(String keywords, String politicId, String nationId, String posId, String jobLevelId, String engageForm, String departmentId, Date startBeginDate, Date endBeginDate);
    
    @Select("<script>" +
            "SELECT count(*) FROM employee e WHERE e.name LIKE concat('%',#{keywords},'%')\n" +
            "        <if test=\"engageForm!=null and engageForm!=''\">\n" +
            "            AND e.engageForm=#{engageForm}\n" +
            "        </if>\n" +
            "        <if test=\"politicId!=null and politicId!=''\">\n" +
            "            AND e.politicId=#{politicId}\n" +
            "        </if>\n" +
            "        <if test=\"nationId!=null and nationId!=''\">\n" +
            "            AND e.nationId=#{nationId}\n" +
            "        </if>\n" +
            "        <if test=\"posId!=null and posId!=''\">\n" +
            "            AND e.posId=#{posId}\n" +
            "        </if>\n" +
            "        <if test=\"jobLevelId!=null and jobLevelId!=''\">\n" +
            "            AND e.jobLevelId=#{jobLevelId}\n" +
            "        </if>\n" +
            "        <if test=\"departmentId!=null and departmentId!=''\">\n" +
            "            AND e.departmentId=#{departmentId}\n" +
            "        </if>\n" +
            "        <if test=\"startBeginDate!=null and endBeginDate!=null\">\n" +
            "            AND e.beginDate BETWEEN #{startBeginDate} AND #{endBeginDate}\n" +
            "        </if>"+
            "</script>")
    Long getCountByKeywords(String keywords, String politicId, String nationId, String posId, String jobLevelId, String engageForm, String departmentId, Date startBeginDate, Date endBeginDate);
}
