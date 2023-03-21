package com.recialhot.service.impl;

import com.recialhot.dao.CommentDao;
import com.recialhot.domain.Comment;
import com.recialhot.service.CommentService;
import com.recialhot.service.DiscussPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

import static com.recialhot.util.CommunityConstant.ENTITY_TYPE_POST;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Autowired
    DiscussPostService discussPostService;

    @Override
    public List<Comment> findCommentsByEntity(int entityType, int entityId, int offset, int limit) {
        return commentDao.selectCommentsByEntity(entityType,entityId,offset,limit);
    }

    @Override
    public int findCommentCount(int entityType, int entityId) {
        return commentDao.selectCountByEntity(entityType,entityId);
    }

    @Override
    public int addComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("参数不能为空!");
        }

        // 添加评论
        comment.setContent(HtmlUtils.htmlEscape(comment.getContent()));
        int rows = commentDao.insertComment(comment);

        // 更新帖子评论数量
        if (comment.getEntityType() == ENTITY_TYPE_POST) {
            int count = commentDao.selectCountByEntity(comment.getEntityType(), comment.getEntityId());
            discussPostService.updateCommentCount(comment.getEntityId(), count);
        }

        return rows;
    }

    @Override
    public Comment findCommentById(int id) {
        return commentDao.selectCommentById(id);
    }
}
