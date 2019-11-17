package com.scen.boot.hrms.service.impl;

import com.scen.boot.hrms.dao.PositionDAO;
import com.scen.boot.hrms.model.Position;
import com.scen.boot.hrms.service.PositionService;
import com.scen.boot.hrms.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Scen
 * @date 2019/11/16 14:33
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PositionServiceImpl implements PositionService {
    
    
    private final PositionDAO positionDAO;
    private final SnowflakeIdWorker snowflakeIdWorker;
    
    public PositionServiceImpl(
            PositionDAO positionDAO,
            SnowflakeIdWorker snowflakeIdWorker
    ) {
        this.positionDAO = positionDAO;
        this.snowflakeIdWorker = snowflakeIdWorker;
    }
    
    @Override
    public int addPos(Position pos) {
        Example example = new Example(Position.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", pos.getName());
        int pcount = positionDAO.selectCountByExample(example);
        if (pcount > 0) {
            return -1;
        }
        pos.setId(snowflakeIdWorker.nextId());
        pos.setEnabled(1);
        pos.setCreateDate(new Date());
        return positionDAO.insert(pos);
    }
    
    @Override
    public List<Position> getAllPos() {
        return positionDAO.getAllPos();
    }
    
    
    @Override
    public boolean deletePosById(String pids) {
        String[] split = pids.split(",");
        Example example = new Example(Position.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", Arrays.asList(split));
        return positionDAO.deleteByExample(example) == split.length;
    }
    
    @Override
    public int updatePosById(Position position) {
        Example example = new Example(Position.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", position.getName());
        int pcount = positionDAO.selectCountByExample(example);
        if (pcount > 0) {
            return -1;
        }
        return positionDAO.updateByPrimaryKeySelective(position);
    }
    
    @Override
    public Position getPosById(String posId) {
        return positionDAO.selectByPrimaryKey(posId);
    }
}
