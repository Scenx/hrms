package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "oplog")
public class Oplog implements Serializable {
    
    private static final long serialVersionUID = 7546166061495607492L;
    @Id
    private String id;
    private Date addDate;
    private String operate;
    private String hrid;
    
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    
    public Date getAddDate() {
        return addDate;
    }
    
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
    
    
    public String getOperate() {
        return operate;
    }
    
    public void setOperate(String operate) {
        this.operate = operate;
    }
    
    
    public String getHrid() {
        return hrid;
    }
    
    public void setHrid(String hrid) {
        this.hrid = hrid;
    }
    
}
