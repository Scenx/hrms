package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "politicsstatus")
public class Politicsstatus implements Serializable {
    
    private static final long serialVersionUID = -3251427632804105908L;
    @Id
    private String id;
    private String name;
    
    
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
    
}
