package com.scen.boot.hrms.service;

import com.scen.boot.hrms.model.Position;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/16 14:33
 */
public interface PositionService {
    
    int addPos(Position pos);
    
    List<Position> getAllPos();
    
    
    boolean deletePosById(String pids);
    
    int updatePosById(Position position);
}
