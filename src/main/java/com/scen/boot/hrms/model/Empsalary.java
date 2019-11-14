package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "empsalary")
public class Empsalary implements Serializable {
    
    private static final long serialVersionUID = 2029866713886401769L;
    @Id
    private Long id;
    private Long eid;
    private Long sid;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    
    public Long getEid() {
        return eid;
    }
    
    public void setEid(Long eid) {
        this.eid = eid;
    }
    
    
    public Long getSid() {
        return sid;
    }
    
    public void setSid(Long sid) {
        this.sid = sid;
    }
    
}
