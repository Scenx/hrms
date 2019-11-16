package com.scen.boot.hrms.controller;

import com.scen.boot.hrms.dto.Hr;
import com.scen.boot.hrms.dto.ScenResult;
import com.scen.boot.hrms.dto.SysMsg;
import com.scen.boot.hrms.model.Msgcontent;
import com.scen.boot.hrms.service.HrService;
import com.scen.boot.hrms.service.SysMsgService;
import com.scen.boot.hrms.utils.SnowflakeIdWorker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 处理通知消息的Controller
 * 登录即可访问
 */
@RestController
@RequestMapping("/chat")
public class ChatController {
    private final HrService hrService;
    private final SysMsgService sysMsgService;
    
    private final SnowflakeIdWorker snowflakeIdWorker;
    
    public ChatController(
            HrService hrService,
            SysMsgService sysMsgService,
            SnowflakeIdWorker snowflakeIdWorker
    ) {
        this.hrService = hrService;
        this.sysMsgService = sysMsgService;
        this.snowflakeIdWorker = snowflakeIdWorker;
    }
    
    @RequestMapping(value = "/hrs", method = RequestMethod.GET)
    public List<Hr> getAllHr() {
        return hrService.getAllHrExceptAdmin();
    }

    @RequestMapping(value = "/nf", method = RequestMethod.POST)
    public ScenResult sendNf(Msgcontent msg) {
        if (sysMsgService.sendMsg(msg)) {
            return ScenResult.ok(null,"发送成功");
        }
        return ScenResult.build (500,"发送失败!");
    }

    @RequestMapping("/sysmsgs")
    public List<SysMsg> getSysMsg(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        List<SysMsg> sysMsgByPage = sysMsgService.getSysMsgByPage(page, size);
        return sysMsgByPage;
    }

    @RequestMapping(value = "/markread", method = RequestMethod.PUT)
    public ScenResult markRead(String flag) {
        if (sysMsgService.markRead(flag)) {
            if ("-1".equals(flag)) {
                return ScenResult.ok(null,"multiple");
            } else {
                return ScenResult.ok(null,"single");
            }
        } else {
            if ("-1".equals(flag)) {
                return ScenResult.build(500,"multiple");
            } else {
                return ScenResult.build(500,"single");
            }
        }
    }
}
