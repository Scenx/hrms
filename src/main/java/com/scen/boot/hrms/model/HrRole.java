package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "hr_role")
public class HrRole implements Serializable {
    
    private static final long serialVersionUID = -3526697515882176655L;
    @Id
    private String id;
    private String rid;
    private String hrid;
    
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getRid() {
        return rid;
    }
    
    public void setRid(String rid) {
        this.rid = rid;
    }
    
    
    public String getHrid() {
        return hrid;
    }
    
    public void setHrid(String hrid) {
        this.hrid = hrid;
    }
    
}
