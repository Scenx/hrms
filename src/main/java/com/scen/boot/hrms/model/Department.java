package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "department")
public class Department implements Serializable {
    
    private static final long serialVersionUID = -775464467302673672L;
    @Id
    private String id;
    private String name;
    private String parentId;
    private String depPath;
    private Integer enabled;
    private Integer isParent;
    
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    public String getParentId() {
        return parentId;
    }
    
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    
    
    public String getDepPath() {
        return depPath;
    }
    
    public void setDepPath(String depPath) {
        this.depPath = depPath;
    }
    
    
    public Integer getEnabled() {
        return enabled;
    }
    
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
    
    
    public Integer getIsParent() {
        return isParent;
    }
    
    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }
    
}
