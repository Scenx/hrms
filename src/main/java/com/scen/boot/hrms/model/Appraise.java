package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "appraise")
public class Appraise implements Serializable {
    
    private static final long serialVersionUID = 7860620688449759900L;
    @Id
    private String id;
    private String eid;
    private Date appDate;
    private String appResult;
    private String appContent;
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
    
    
    public Date getAppDate() {
        return appDate;
    }
    
    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }
    
    
    public String getAppResult() {
        return appResult;
    }
    
    public void setAppResult(String appResult) {
        this.appResult = appResult;
    }
    
    
    public String getAppContent() {
        return appContent;
    }
    
    public void setAppContent(String appContent) {
        this.appContent = appContent;
    }
    
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
}
