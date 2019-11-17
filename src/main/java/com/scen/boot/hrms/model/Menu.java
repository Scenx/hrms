package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "menu")
public class Menu implements Serializable {
    
    private static final long serialVersionUID = -2994475231144896366L;
    @Id
    private Integer id;
    private String url;
    private String path;
    private String component;
    private String name;
    private String iconCls;
    private Integer keepAlive;
    private Integer requireAuth;
    private String parentId;
    private Integer enabled;
    
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    
    public String getComponent() {
        return component;
    }
    
    public void setComponent(String component) {
        this.component = component;
    }
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    public String getIconCls() {
        return iconCls;
    }
    
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
    
    
    public Integer getKeepAlive() {
        return keepAlive;
    }
    
    public void setKeepAlive(Integer keepAlive) {
        this.keepAlive = keepAlive;
    }
    
    
    public Integer getRequireAuth() {
        return requireAuth;
    }
    
    public void setRequireAuth(Integer requireAuth) {
        this.requireAuth = requireAuth;
    }
    
    
    public String getParentId() {
        return parentId;
    }
    
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    
    
    public Integer getEnabled() {
        return enabled;
    }
    
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
    
}
