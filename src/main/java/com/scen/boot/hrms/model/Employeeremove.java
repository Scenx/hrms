package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Table(name = "employeeremove")
public class Employeeremove implements Serializable {
    
    private static final long serialVersionUID = -8458728989507417274L;
    @Id
    private String id;
    private String eid;
    private String afterDepId;
    private String afterJobId;
    private Date removeDate;
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
    
    
    public String getAfterDepId() {
        return afterDepId;
    }
    
    public void setAfterDepId(String afterDepId) {
        this.afterDepId = afterDepId;
    }
    
    
    public String getAfterJobId() {
        return afterJobId;
    }
    
    public void setAfterJobId(String afterJobId) {
        this.afterJobId = afterJobId;
    }
    
    
    public Date getRemoveDate() {
        return removeDate;
    }
    
    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
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
