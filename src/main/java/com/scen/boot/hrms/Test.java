package com.scen.boot.hrms;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * 密码生成
 * @author Scen
 * @date 2019/11/15 16:50
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
