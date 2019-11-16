package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Table(name = "joblevel")
public class Joblevel implements Serializable {
    
    private static final long serialVersionUID = 8939477481495200858L;
    @Id
    private String id;
    private String name;
    private String titleLevel;
    private Date createDate;
    private Integer enabled;
    
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
    
        Joblevel joblevel = (Joblevel) o;
        
        return Objects.equals(name, joblevel.name);
    }
    
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
    
    public Joblevel() {
    
    }
    
    public Joblevel(String name) {
        
        this.name = name;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
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
