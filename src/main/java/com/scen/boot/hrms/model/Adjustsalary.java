package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "adjustsalary")
public class Adjustsalary implements Serializable {
    
    private static final long serialVersionUID = 5195139388824823053L;
    @Id
    private String id;
    private String eid;
    private Date asDate;
    private Integer beforeSalary;
    private Integer afterSalary;
    private String reason;
    private String remark;
    
    
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
    
    
    public Date getAsDate() {
        return asDate;
    }
    
    public void setAsDate(Date asDate) {
        this.asDate = asDate;
    }
    
    
    public Integer getBeforeSalary() {
        return beforeSalary;
    }
    
    public void setBeforeSalary(Integer beforeSalary) {
        this.beforeSalary = beforeSalary;
    }
    
    
    public Integer getAfterSalary() {
        return afterSalary;
    }
    
    public void setAfterSalary(Integer afterSalary) {
        this.afterSalary = afterSalary;
    }
    
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
}
