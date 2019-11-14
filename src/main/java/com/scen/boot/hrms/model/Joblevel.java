package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "joblevel")
public class Joblevel implements Serializable {
    
    private static final long serialVersionUID = 8939477481495200858L;
    @Id
    private Long id;
    private String name;
    private String titleLevel;
    private Date createDate;
    private Integer enabled;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    public String getTitleLevel() {
        return titleLevel;
    }
    
    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }
    
    
    public Date getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    
    public Integer getEnabled() {
        return enabled;
    }
    
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
    
}
