package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "sysmsg")
public class Sysmsg implements Serializable {
    
    private static final long serialVersionUID = 4323635544909864467L;
    @Id
    private String id;
    private String mid;
    private Integer type;
    private String hrid;
    private Integer state;
    
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getMid() {
        return mid;
    }
    
    public void setMid(String mid) {
        this.mid = mid;
    }
    
    
    public Integer getType() {
        return type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    
    public String getHrid() {
        return hrid;
    }
    
    public void setHrid(String hrid) {
        this.hrid = hrid;
    }
    
    
    public Integer getState() {
        return state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }
    
}
