package ru.skypro.homework.service.impl;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.service.CommentsService;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentsService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentsServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public List<Comment> getCommentsByAdId(Long adId) {
        return commentRepository.findByAdId(adId);
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long commentId, String newText, User currentUser) {
        Optional<Comment> commentOpt = commentRepository.findById(commentId);
        if (commentOpt.isEmpty()) {
            throw new RuntimeException("Комментарий не найден");
        }
        Comment comment = commentOpt.get();
        if (!comment.getAuthor().getId().equals(currentUser.getId()) &&
                !"ADMIN".equalsIgnoreCase(currentUser.getRole())) {
            throw new AccessDeniedException("Нет прав для редактирования комментария");
        }
        comment.setText(newText);
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId, User currentUser) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Комментарий не найден"));
        if (!comment.getAuthor().getId().equals(currentUser.getId()) &&
                !"ADMIN".equalsIgnoreCase(currentUser.getRole())) {
            throw new AccessDeniedException("Нет прав для удаления комментария");
        }
        commentRepository.deleteById(commentId);
    }
}
