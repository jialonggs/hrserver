package org.sang.service;

import org.sang.bean.MsgContent;
import org.sang.bean.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendMessageService {

    @Autowired
    SysMsgService sysMsgService;

    public void toSendMessage(String msg, String title, List<Role> roles){
        MsgContent msgContent = new MsgContent();
        msgContent.setTitle(title);
        msgContent.setMessage(msg);
        sysMsgService.sendToOneOrSome(msgContent, roles);
    }

    public void toSendByIds(String msg, String title, List<Long> ids){
        MsgContent msgContent = new MsgContent();
        msgContent.setTitle(title);
        msgContent.setMessage(msg);
        sysMsgService.sendByIds(msgContent, ids);
    }
}
