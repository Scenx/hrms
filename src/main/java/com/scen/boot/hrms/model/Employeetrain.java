package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "employeetrain")
public class Employeetrain implements Serializable {
    
    private static final long serialVersionUID = 5399419052236865692L;
    @Id
    private String id;
    private String eid;
    private Date trainDate;
    private String trainContent;
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
    
    
    public Date getTrainDate() {
        return trainDate;
    }
    
    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }
    
    
    public String getTrainContent() {
        return trainContent;
    }
    
    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
    }
    
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
}
