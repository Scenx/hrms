package com.scen.boot.hrms.controller.system;

import com.scen.boot.hrms.dto.Hr;
import com.scen.boot.hrms.dto.ScenResult;
import com.scen.boot.hrms.model.Role;
import com.scen.boot.hrms.service.HrService;
import com.scen.boot.hrms.service.RoleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sang on 2018/1/2.
 */
@RestController
@RequestMapping("/system/hr")
public class SystemHrController {
    private final HrService hrService;
    private final RoleService roleService;
    
    public SystemHrController(HrService hrService, RoleService roleService) {
        this.hrService = hrService;
        this.roleService = roleService;
    }
    
    @RequestMapping("/id/{hrId}")
    public Hr getHrById(@PathVariable String hrId) {
        return hrService.getHrById(hrId);
    }

    @RequestMapping(value = "/{hrId}", method = RequestMethod.DELETE)
    public ScenResult deleteHr(@PathVariable String hrId) {
        if (hrService.deleteHr(hrId) == 1) {
            return ScenResult.ok(null,"删除成功!");
        }
        return ScenResult.build(500,"删除失败!");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ScenResult updateHr(com.scen.boot.hrms.model.Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return ScenResult.ok(null,"更新成功!");
        }
        return ScenResult.build(500,"更新失败!");
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT)
    public ScenResult updateHrRoles(String hrId, String[] rids) {
        if (hrService.updateHrRoles(hrId, rids) == rids.length) {
            return ScenResult.ok(null,"更新成功!");
        }
        return ScenResult.build(500,"更新失败!");
    }

    @RequestMapping("/{keywords}")
    public List<Hr> getHrsByKeywords(@PathVariable(required = false) String keywords) {
        return hrService.getHrsByKeywords(keywords);
    }

    @RequestMapping(value = "/roles",method = RequestMethod.GET)
    public List<Role> allRoles() {
        return roleService.roles();
    }

    @RequestMapping(value = "/hr/reg", method = RequestMethod.POST)
    public ScenResult hrReg(String username, String password) {
        int i = hrService.hrReg(username, password);
        if (i == 1) {
            return ScenResult.ok(null,"注册成功!");
        } else if (i == -1) {
            return ScenResult.build(500,"用户名重复，注册失败!");
        }
        return ScenResult.build(500,"注册失败!");
    }

}
