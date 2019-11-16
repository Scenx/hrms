package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "politicsstatus")
public class Politicsstatus implements Serializable {
    
    private static final long serialVersionUID = -3251427632804105908L;
    @Id
    private String id;
    private String name;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
    
        Politicsstatus that = (Politicsstatus) o;
        
        return Objects.equals(name, that.name);
    }
    
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
    
    public Politicsstatus(String name) {
        
        this.name = name;
    }
    
    public Politicsstatus() {
    
    }
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
