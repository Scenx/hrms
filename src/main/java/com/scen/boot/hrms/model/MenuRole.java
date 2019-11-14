package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "menu_role")
public class MenuRole implements Serializable {
    
    private static final long serialVersionUID = -2395693412262641981L;
    @Id
    private Long id;
    private Long mid;
    private Long rid;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    
    public Long getMid() {
        return mid;
    }
    
    public void setMid(Long mid) {
        this.mid = mid;
    }
    
    
    public Long getRid() {
        return rid;
    }
    
    public void setRid(Long rid) {
        this.rid = rid;
    }
    
}
