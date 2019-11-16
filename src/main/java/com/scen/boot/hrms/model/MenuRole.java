package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "menu_role")
public class MenuRole implements Serializable {
    
    private static final long serialVersionUID = -2395693412262641981L;
    @Id
    private String id;
    private String mid;
    private String rid;
    
    
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
    
    
    public String getRid() {
        return rid;
    }
    
    public void setRid(String rid) {
        this.rid = rid;
    }
    
}
