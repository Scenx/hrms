package com.scen.boot.hrms;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.scen.boot.hrms.dao")
public class HrmsApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(HrmsApplication.class, args);
    }
    
}
