package com.recialhot.service;

import com.recialhot.domain.Message;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

public interface MessageService {


    int addMessage(Message message);

    int readMessage(List<Integer> ids);

    Message findLatestNotice(int userId, String topic);

    int findNoticeCount(int userId, String topic);

    int findNoticeUnreadCount(int userId, String topic);

    List<Message> findNotices(int userId, String topic, int offset, int limit);
}
