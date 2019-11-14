package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "salary")
public class Salary implements Serializable {
    
    private static final long serialVersionUID = -6152536943334031515L;
    @Id
    private Long id;
    private Integer basicSalary;
    private Integer bonus;
    private Integer lunchSalary;
    private Integer trafficSalary;
    private Integer allSalary;
    private Integer pensionBase;
    private Double pensionPer;
    private Date createDate;
    private Integer medicalBase;
    private Double medicalPer;
    private Integer accumulationFundBase;
    private Double accumulationFundPer;
    private String name;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    
    public Integer getBasicSalary() {
        return basicSalary;
    }
    
    public void setBasicSalary(Integer basicSalary) {
        this.basicSalary = basicSalary;
    }
    
    
    public Integer getBonus() {
        return bonus;
    }
    
    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
    
    
    public Integer getLunchSalary() {
        return lunchSalary;
    }
    
    public void setLunchSalary(Integer lunchSalary) {
        this.lunchSalary = lunchSalary;
    }
    
    
    public Integer getTrafficSalary() {
        return trafficSalary;
    }
    
    public void setTrafficSalary(Integer trafficSalary) {
        this.trafficSalary = trafficSalary;
    }
    
    
    public Integer getAllSalary() {
        return allSalary;
    }
    
    public void setAllSalary(Integer allSalary) {
        this.allSalary = allSalary;
    }
    
    
    public Integer getPensionBase() {
        return pensionBase;
    }
    
    public void setPensionBase(Integer pensionBase) {
        this.pensionBase = pensionBase;
    }
    
    
    public Double getPensionPer() {
        return pensionPer;
    }
    
    public void setPensionPer(Double pensionPer) {
        this.pensionPer = pensionPer;
    }
    
    
    public Date getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    
    public Integer getMedicalBase() {
        return medicalBase;
    }
    
    public void setMedicalBase(Integer medicalBase) {
        this.medicalBase = medicalBase;
    }
    
    
    public Double getMedicalPer() {
        return medicalPer;
    }
    
    public void setMedicalPer(Double medicalPer) {
        this.medicalPer = medicalPer;
    }
    
    
    public Integer getAccumulationFundBase() {
        return accumulationFundBase;
    }
    
    public void setAccumulationFundBase(Integer accumulationFundBase) {
        this.accumulationFundBase = accumulationFundBase;
    }
    
    
    public Double getAccumulationFundPer() {
        return accumulationFundPer;
    }
    
    public void setAccumulationFundPer(Double accumulationFundPer) {
        this.accumulationFundPer = accumulationFundPer;
    }
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
