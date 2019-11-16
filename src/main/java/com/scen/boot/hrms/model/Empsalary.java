package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "empsalary")
public class Empsalary implements Serializable {
    
    private static final long serialVersionUID = 2029866713886401769L;
    @Id
    private String id;
    private String eid;
    private String sid;
    
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getEid() {
        return eid;
    }
    
    public void setEid(String eid) {
        this.eid = eid;
    }
    
    
    public String getSid() {
        return sid;
    }
    
    public void setSid(String sid) {
        this.sid = sid;
    }
    
}
