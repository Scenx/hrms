package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "employeeec")
public class Employeeec implements Serializable {
    
    private static final long serialVersionUID = 6054668257798063528L;
    @Id
    private String id;
    private String eid;
    private Date ecDate;
    private String ecReason;
    private Integer ecPoint;
    private Integer ecType;
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
    
    
    public Date getEcDate() {
        return ecDate;
    }
    
    public void setEcDate(Date ecDate) {
        this.ecDate = ecDate;
    }
    
    
    public String getEcReason() {
        return ecReason;
    }
    
    public void setEcReason(String ecReason) {
        this.ecReason = ecReason;
    }
    
    
    public Integer getEcPoint() {
        return ecPoint;
    }
    
    public void setEcPoint(Integer ecPoint) {
        this.ecPoint = ecPoint;
    }
    
    
    public Integer getEcType() {
        return ecType;
    }
    
    public void setEcType(Integer ecType) {
        this.ecType = ecType;
    }
    
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
}
