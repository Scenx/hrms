package com.scen.boot.hrms.controller.system;

import com.scen.boot.hrms.dto.Menu;
import com.scen.boot.hrms.dto.ScenResult;
import com.scen.boot.hrms.model.Department;
import com.scen.boot.hrms.model.Joblevel;
import com.scen.boot.hrms.model.Position;
import com.scen.boot.hrms.model.Role;
import com.scen.boot.hrms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by
 */
@RestController
@RequestMapping("/system/basic")
public class SystemBasicController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuRoleService menuRoleService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private JobLevelService jobLevelService;
    
    @RequestMapping(value = "/role/{rid}", method = RequestMethod.DELETE)
    public ScenResult deleteRole(@PathVariable String rid) {
        if (roleService.deleteRoleById(rid) == 1) {
            return ScenResult.ok(null, "删除成功!");
        }
        return ScenResult.build(500, "删除失败!");
    }
    
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public ScenResult addNewRole(String role, String roleZh) {
        if (roleService.addNewRole(role, roleZh) == 1) {
            return ScenResult.ok(null, "添加成功!");
        }
        return ScenResult.build(500, "添加失败!");
    }
    
    @RequestMapping(value = "/menuTree/{rid}", method = RequestMethod.GET)
    public Map<String, Object> menuTree(@PathVariable Long rid) {
        Map<String, Object> map = new HashMap<>(2);
        List<Menu> menus = menuService.menuTree();
        map.put("menus", menus);
        List<Integer> selMids = menuService.getMenusByRid(rid);
        map.put("mids", selMids);
        return map;
    }
    
    @RequestMapping(value = "/updateMenuRole", method = RequestMethod.PUT)
    public ScenResult updateMenuRole(String rid, Integer[] mids) {
        if (menuRoleService.updateMenuRole(rid, mids) == mids.length) {
            return ScenResult.ok(null, "更新成功!");
        }
        return ScenResult.build(500, "更新失败!");
    }
    
    @RequestMapping("/roles")
    public List<Role> allRoles() {
        return roleService.roles();
    }
    
    @RequestMapping(value = "/dep", method = RequestMethod.POST)
    public Map<String, Object> addDep(Department department) {
        Map<String, Object> map = new HashMap<>(2);
        if (departmentService.addDep(department) == 1) {
            map.put("status", "success");
            map.put("msg", "添加成功");
            map.put("data", department);
            return map;
        }
        map.put("status", "error");
        map.put("msg", "添加失败!");
        return map;
    }
    
    @RequestMapping(value = "/dep/{did}", method = RequestMethod.DELETE)
    public ScenResult deleteDep(@PathVariable String did) {
        int result = departmentService.deleteDep(did);
        if (result == 1) {
            return ScenResult.ok(null, "删除成功!");
        } else if (result == -1) {
            return ScenResult.build(500, "该部门下暂有员工，禁止删除!");
        }
        return ScenResult.build(500, "删除失败!");
    }
    
    @RequestMapping(value = "/dep/{pid}", method = RequestMethod.GET)
    public List<com.scen.boot.hrms.dto.Department> getDepByPid(@PathVariable String pid) {
        return departmentService.getDepByPid(pid);
    }
    
    @RequestMapping(value = "/deps", method = RequestMethod.GET)
    public List<com.scen.boot.hrms.dto.Department> getAllDeps() {
        return departmentService.getAllDeps();
    }
    
    @RequestMapping(value = "/position", method = RequestMethod.POST)
    public ScenResult addPos(Position pos) {
        int result = positionService.addPos(pos);
        if (result == 1) {
            return ScenResult.ok(null, "添加成功!");
        } else if (result == -1) {
            return ScenResult.build(500, "职位名重复，添加失败!");
        }
        return ScenResult.build(500, "添加失败!");
    }
    
    @RequestMapping(value = "/positions", method = RequestMethod.GET)
    public List<Position> getAllPos() {
        return positionService.getAllPos();
    }
    
    @RequestMapping("/position/{pids}")
    public ScenResult deletePosById(@PathVariable String pids) {
        if (positionService.deletePosById(pids)) {
            return ScenResult.ok(null, "删除成功!");
        }
        return ScenResult.build(500, "删除失败!");
    }
    
    @RequestMapping(value = "/position", method = RequestMethod.PUT)
    public ScenResult updatePosById(Position position) {
        if (positionService.updatePosById(position) == 1) {
            return ScenResult.ok(null, "修改成功!");
        }
        return ScenResult.build(500, "修改失败!");
    }
    
    @RequestMapping(value = "/joblevel", method = RequestMethod.POST)
    public ScenResult addJobLevel(Joblevel joblevel) {
        int result = jobLevelService.addJobLevel(joblevel);
        if (result == 1) {
            return ScenResult.ok(null, "添加成功!");
        } else if (result == -1) {
            return ScenResult.build(500, "职称名重复，添加失败!");
        }
        return ScenResult.build(500, "添加失败!");
    }
    
    @RequestMapping(value = "/joblevels", method = RequestMethod.GET)
    public List<Joblevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }
    
    @RequestMapping(value = "/joblevel/{ids}", method = RequestMethod.DELETE)
    public ScenResult deleteJobLevelById(@PathVariable String ids) {
        if (jobLevelService.deleteJobLevelById(ids)) {
            return ScenResult.ok(null, "删除成功!");
        }
        return ScenResult.build(500, "删除失败!");
    }
    
    @RequestMapping(value = "/joblevel", method = RequestMethod.PUT)
    public ScenResult updateJobLevel(Joblevel joblevel) {
        if (jobLevelService.updateJobLevel(joblevel) == 1) {
            return ScenResult.ok(null, "修改成功!");
        }
        return ScenResult.build(500, "修改失败!");
    }
}
