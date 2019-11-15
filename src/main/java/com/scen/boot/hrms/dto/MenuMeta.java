package com.scen.boot.hrms.dto;

import java.io.Serializable;

/**
 * Created by
 */
public class MenuMeta implements Serializable {
    
    private static final long serialVersionUID = 4822540338963305872L;
    private boolean keepAlive;
    private boolean requireAuth;

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public boolean isRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
