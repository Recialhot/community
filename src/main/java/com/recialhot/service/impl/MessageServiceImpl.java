package com.recialhot.service.impl;


import com.recialhot.dao.MessageDao;
import com.recialhot.domain.Message;
import com.recialhot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    public int addMessage(Message message) {
        message.setContent(HtmlUtils.htmlEscape(message.getContent()));
        return messageDao.insertMessage(message);
    }

    public int readMessage(List<Integer> ids) {
        return messageDao.updateStatus(ids, 1);
    }

    public Message findLatestNotice(int userId, String topic) {
        return messageDao.selectLatestNotice(userId, topic);
    }

    public int findNoticeCount(int userId, String topic) {
        return messageDao.selectNoticeCount(userId, topic);
    }

    public int findNoticeUnreadCount(int userId, String topic) {
        return messageDao.selectNoticeUnreadCount(userId, topic);
    }

    public List<Message> findNotices(int userId, String topic, int offset, int limit) {
        return messageDao.selectNotices(userId, topic, offset, limit);
    }

}
