package com.recialhot.service;

import com.recialhot.domain.Comment;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentService {
    List<Comment> findCommentsByEntity(int entityType,int entityId,int offset,int limit);

    int findCommentCount(int entityType,int entityId);

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    int addComment(Comment comment);

    Comment findCommentById(int id);
}
