package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "role")
public class Role implements Serializable {
    
    private static final long serialVersionUID = -297802995776901866L;
    @Id
    private String id;
    private String name;
    private String nameZh;
    
    
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
    
    
    public String getNameZh() {
        return nameZh;
    }
    
    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
    
}
