package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "menu_role")
public class MenuRole implements Serializable {
    
    private static final long serialVersionUID = -2395693412262641981L;
    @Id
    private String id;
    private Integer mid;
    private String rid;
    
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    
    public Integer getMid() {
        return mid;
    }
    
    public void setMid(Integer mid) {
        this.mid = mid;
    }
    
    
    public String getRid() {
        return rid;
    }
    
    public void setRid(String rid) {
        this.rid = rid;
    }
    
}
