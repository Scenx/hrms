package com.scen.boot.hrms.utils;


import com.scen.boot.hrms.dto.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by
 */
public class HrUtils {
    public static Hr getCurrentHr() {
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
