package ru.skypro.homework.service;

import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.entity.User;

import java.util.List;

public interface CommentsService {
    public List<Comment> getCommentsByAdId(Long adId);

    public Comment addComment(Comment comment);

    public Comment updateComment(Long commentId, String newText, User currentUser);

    public void deleteComment(Long commentId, User currentUser);

}
