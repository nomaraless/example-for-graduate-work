package ru.skypro.homework.mapper;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentDTO;
import ru.skypro.homework.dto.CreateOrUpdateCommentDTO;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.entity.User;

import java.time.ZoneId;

@Service
public class CommentMapper {

    public CommentDTO toDto(Comment comment) {
        if (comment == null) return null;
        CommentDTO dto = new CommentDTO();
        dto.setPk(comment.getId().intValue());
        dto.setText(comment.getText());
        dto.setAuthor(comment.getAuthor() != null ? comment.getAuthor().getId().intValue() : null);
        dto.setCreatedAt(comment.getCreatedAt() != null
                ? comment.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
                : null);
        if (comment.getAuthor() != null) {
            dto.setAuthorUsername(comment.getAuthor().getUserName());
        }
        return dto;
    }

    public Comment toEntity(CreateOrUpdateCommentDTO dto, Ad ad, User author) {
        if (dto == null) return null;
        Comment comment = new Comment();
        comment.setText(dto.getText());
        comment.setAd(ad);
        comment.setAuthor(author);
        comment.setCreatedAt(java.time.LocalDateTime.now());
        return comment;
    }
}
