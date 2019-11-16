package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.PositionDAO;
import com.scen.boot.hrms.model.Position;
import com.scen.boot.hrms.service.PositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Scen
 * @date 2019/11/16 14:33
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PositionServiceImpl implements PositionService {
    
    
    private final PositionDAO positionDAO;
    
    public PositionServiceImpl(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }
    
    @Override
    public int addPos(Position pos) {
        return 0;
    }
    
    @Override
    public List<Position> getAllPos() {
        return positionDAO.getAllPos();
    }
    
    
    @Override
    public boolean deletePosById(String pids) {
        return false;
    }
    
    @Override
    public int updatePosById(Position position) {
        return 0;
    }
    
    @Override
    public Position getPosById(String posId) {
        return positionDAO.selectByPrimaryKey(posId);
    }
}
