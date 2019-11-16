package com.scen.boot.hrms.service;

import com.scen.boot.hrms.dto.SysMsg;
import com.scen.boot.hrms.model.Msgcontent;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/15 12:08
 */
public interface SysMsgService {
    
    
    boolean sendMsg(Msgcontent msg);
    
    
    List<SysMsg> getSysMsgByPage(Integer page, Integer size);
    
    
    boolean markRead(String flag);
}
