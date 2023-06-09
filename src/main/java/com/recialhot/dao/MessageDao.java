package com.recialhot.dao;

import com.recialhot.domain.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageDao {
    //新增消息
    int insertMessage(Message message);
    //修改消息状态
    int updateStatus(List<Integer> ids, int status);
    //查询某个主题下的一个最新通知
    Message selectLatestNotice(int userId, String topic);
    //查询某个主题所包含的通知数量
    int selectNoticeCount(int userId, String topic);
    //查询未读的通知的数量
    int selectNoticeUnreadCount(int userId, String topic);
    //查询某个主题包含的通知列表 要分页
    List<Message> selectNotices(int userId, String topic, int offset, int limit);
}
