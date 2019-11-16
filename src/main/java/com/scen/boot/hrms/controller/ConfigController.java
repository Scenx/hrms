package com.scen.boot.hrms.controller;

import com.scen.boot.hrms.dto.Hr;
import com.scen.boot.hrms.dto.Menu;
import com.scen.boot.hrms.service.MenuService;
import com.scen.boot.hrms.utils.HrUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 这是一个只要登录就能访问的Controller
 * 主要用来获取一些配置信息
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    
    private final MenuService menuService;
    
    public ConfigController(MenuService menuService) {
        this.menuService = menuService;
    }
    
    @RequestMapping("/sysmenu")
    public List<Menu> sysmenu() {
        return menuService.getMenusByHrId();
    }

    @RequestMapping("/hr")
    public Hr currentUser() {
        return HrUtils.getCurrentHr();
    }
}
