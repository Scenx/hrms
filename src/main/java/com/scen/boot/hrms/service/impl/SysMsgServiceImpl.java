package com.scen.boot.hrms.service.impl;

import com.github.pagehelper.PageHelper;
import com.scen.boot.hrms.dao.HrDAO;
import com.scen.boot.hrms.dao.MsgcontentDAO;
import com.scen.boot.hrms.dao.SysmsgDAO;
import com.scen.boot.hrms.dto.Hr;
import com.scen.boot.hrms.dto.SysMsg;
import com.scen.boot.hrms.model.Msgcontent;
import com.scen.boot.hrms.model.Sysmsg;
import com.scen.boot.hrms.service.SysMsgService;
import com.scen.boot.hrms.utils.HrUtils;
import com.scen.boot.hrms.utils.SnowflakeIdWorker;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Scen
 * @date 2019/11/15 12:08
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysMsgServiceImpl implements SysMsgService {
    private final SysmsgDAO sysmsgDAO;
    private final HrDAO hrDAO;
    private final MsgcontentDAO msgcontentDAO;
    private final SnowflakeIdWorker snowflakeIdWorker;
    
    
    public SysMsgServiceImpl(
            SysmsgDAO sysmsgDAO,
            HrDAO hrDAO,
            MsgcontentDAO msgcontentDAO,
            SnowflakeIdWorker snowflakeIdWorker
    ) {
        this.sysmsgDAO = sysmsgDAO;
        this.hrDAO = hrDAO;
        this.msgcontentDAO = msgcontentDAO;
        this.snowflakeIdWorker = snowflakeIdWorker;
    }
    
    //只有管理员可以发送系统消息
    @Override
    @PreAuthorize("hasRole('ROLE_admin')")
    public boolean sendMsg(Msgcontent msg) {
        msg.setId(snowflakeIdWorker.nextId());
        msg.setCreateDate(new Date());
        msgcontentDAO.insert(msg);
        List<Hr> allHr = hrDAO.getAllHr(null);
        for (Hr hr : allHr) {
            Sysmsg sysmsg = new Sysmsg();
            sysmsg.setId(snowflakeIdWorker.nextId());
            sysmsg.setMid(msg.getId());
            sysmsg.setHrid(hr.getId());
            sysmsg.setState(0);
            sysmsg.setType(0);
            sysmsgDAO.insert(sysmsg);
        }
        return true;
    }
    
    @Override
    public List<SysMsg> getSysMsgByPage(Integer page, Integer size) {
        PageHelper.startPage(page, size, false);
        return sysmsgDAO.getSysMsg(HrUtils.getCurrentHr().getId());
    }
    
    @Override
    public boolean markRead(String flag) {
        if (!"-1".equals(flag)) {
            return sysmsgDAO.markRead(flag, HrUtils.getCurrentHr().getId()) == 1;
        }
        sysmsgDAO.markRead(flag, HrUtils.getCurrentHr().getId());
        return true;
    }
}
