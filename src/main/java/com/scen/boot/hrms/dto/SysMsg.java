package com.scen.boot.hrms.dto;

import com.scen.boot.hrms.model.Msgcontent;

/**
 * Created by
 */
public class SysMsg {
    private String id;
    private String mid;
    private Integer type;
    private String hrid;
    private Integer state;
    private Msgcontent msgcontent;
    
    public Msgcontent getMsgcontent() {
        return msgcontent;
    }
    
    public void setMsgcontent(Msgcontent msgcontent) {
        this.msgcontent = msgcontent;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getHrid() {
        return hrid;
    }

    public void setHrid(String hrid) {
        this.hrid = hrid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
