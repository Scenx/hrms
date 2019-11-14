package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "oplog")
public class Oplog implements Serializable {
    
    private static final long serialVersionUID = 7546166061495607492L;
    @Id
    private Long id;
    private Date addDate;
    private String operate;
    private Long hrid;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
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
    
    
    public Long getHrid() {
        return hrid;
    }
    
    public void setHrid(Long hrid) {
        this.hrid = hrid;
    }
    
}
