package com.scen.boot.hrms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.scen.boot.hrms.dao")
@EnableCaching
public class HrmsApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(HrmsApplication.class, args);
    }
    
}
