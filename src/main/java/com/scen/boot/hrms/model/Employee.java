package com.scen.boot.hrms.model;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "employee")
public class Employee implements Serializable {
    
    private static final long serialVersionUID = 8658714873944544720L;
    @Id
    private Long id;
    private String name;
    private String gender;
    private Date birthday;
    private String idCard;
    private String wedlock;
    private Long nationId;
    private String nativePlace;
    private Long politicId;
    private String email;
    private String phone;
    private String address;
    private Long departmentId;
    private Long jobLevelId;
    private Long posId;
    private String engageForm;
    private String tiptopDegree;
    private String specialty;
    private String school;
    private Date beginDate;
    private String workState;
    private String workID;
    private Double contractTerm;
    private Date conversionTime;
    private Date notWorkDate;
    private Date beginContract;
    private Date endContract;
    private Integer workAge;
    
    
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
    
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    
    public String getIdCard() {
        return idCard;
    }
    
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    
    
    public String getWedlock() {
        return wedlock;
    }
    
    public void setWedlock(String wedlock) {
        this.wedlock = wedlock;
    }
    
    
    public Long getNationId() {
        return nationId;
    }
    
    public void setNationId(Long nationId) {
        this.nationId = nationId;
    }
    
    
    public String getNativePlace() {
        return nativePlace;
    }
    
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }
    
    
    public Long getPoliticId() {
        return politicId;
    }
    
    public void setPoliticId(Long politicId) {
        this.politicId = politicId;
    }
    
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    
    public Long getDepartmentId() {
        return departmentId;
    }
    
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    
    
    public Long getJobLevelId() {
        return jobLevelId;
    }
    
    public void setJobLevelId(Long jobLevelId) {
        this.jobLevelId = jobLevelId;
    }
    
    
    public Long getPosId() {
        return posId;
    }
    
    public void setPosId(Long posId) {
        this.posId = posId;
    }
    
    
    public String getEngageForm() {
        return engageForm;
    }
    
    public void setEngageForm(String engageForm) {
        this.engageForm = engageForm;
    }
    
    
    public String getTiptopDegree() {
        return tiptopDegree;
    }
    
    public void setTiptopDegree(String tiptopDegree) {
        this.tiptopDegree = tiptopDegree;
    }
    
    
    public String getSpecialty() {
        return specialty;
    }
    
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    
    
    public String getSchool() {
        return school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }
    
    
    public Date getBeginDate() {
        return beginDate;
    }
    
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
    
    
    public String getWorkState() {
        return workState;
    }
    
    public void setWorkState(String workState) {
        this.workState = workState;
    }
    
    
    public String getWorkID() {
        return workID;
    }
    
    public void setWorkID(String workID) {
        this.workID = workID;
    }
    
    
    public Double getContractTerm() {
        return contractTerm;
    }
    
    public void setContractTerm(Double contractTerm) {
        this.contractTerm = contractTerm;
    }
    
    
    public Date getConversionTime() {
        return conversionTime;
    }
    
    public void setConversionTime(Date conversionTime) {
        this.conversionTime = conversionTime;
    }
    
    
    public Date getNotWorkDate() {
        return notWorkDate;
    }
    
    public void setNotWorkDate(Date notWorkDate) {
        this.notWorkDate = notWorkDate;
    }
    
    
    public Date getBeginContract() {
        return beginContract;
    }
    
    public void setBeginContract(Date beginContract) {
        this.beginContract = beginContract;
    }
    
    
    public Date getEndContract() {
        return endContract;
    }
    
    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }
    
    
    public Integer getWorkAge() {
        return workAge;
    }
    
    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }
    
}
