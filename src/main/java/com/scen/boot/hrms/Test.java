package com.scen.boot.hrms;

import com.scen.boot.hrms.utils.SnowflakeIdWorker;

/**
 * @author Scen
 * @date 2019/11/15 16:50
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new SnowflakeIdWorker().nextId());
    }
}
