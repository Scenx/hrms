package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "hr_role")
public class HrRole implements Serializable {
    
    private static final long serialVersionUID = -3526697515882176655L;
    @Id
    private Long id;
    private Long rid;
    private Long hrid;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    
    public Long getRid() {
        return rid;
    }
    
    public void setRid(Long rid) {
        this.rid = rid;
    }
    
    
    public Long getHrid() {
        return hrid;
    }
    
    public void setHrid(Long hrid) {
        this.hrid = hrid;
    }
    
}
