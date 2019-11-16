package com.scen.boot.hrms.controller;

import com.scen.boot.hrms.dto.ScenResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by
 */
@RestController
public class RegLoginController {
    
    @RequestMapping("/login_p")
    public ScenResult login() {
        return ScenResult.build(500,"尚未登录，请登录!");
    }
    @GetMapping("/employee/advanced/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/employee/basic/hello")
    public String basicHello() {
        return "basicHello";
    }
}
