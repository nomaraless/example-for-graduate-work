package ru.skypro.homework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CommentDTO;
import ru.skypro.homework.dto.CommentsDTO;
import ru.skypro.homework.dto.CreateOrUpdateCommentDTO;

/**
 * Контроллер для управления комментариями к объявлениям.
 */
@Slf4j
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/ads/{adId}/comments")
public class CommentsController {

    /**
     * Получение комментариев объявления.
     *
     * @param adId идентификатор объявления
     * @return пустой объект CommentsDTO
     */
    @GetMapping
    public ResponseEntity<CommentsDTO> getComments(@PathVariable Integer adId) {
        CommentsDTO comments = new CommentsDTO();
        comments.setCount(0);
        comments.setResults(java.util.Collections.emptyList());
        return ResponseEntity.ok(comments);
    }

    /**
     * Добавление комментария к объявлению.
     *
     * @param adId идентификатор объявления
     * @param comment данные комментария
     * @return пустой объект CommentDTO
     */
    @PostMapping
    public ResponseEntity<CommentDTO> addComment(@PathVariable Integer adId, @RequestBody CreateOrUpdateCommentDTO comment) {
        return ResponseEntity.ok(new CommentDTO());
    }

    /**
     * Удаление комментария.
     *
     * @param adId      идентификатор объявления
     * @param commentId идентификатор комментария
     * @return HTTP 200 OK
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteComment(@PathVariable Integer adId, @PathVariable Integer commentId) {
        return ResponseEntity.ok().build();
    }

    /**
     * Обновление комментария.
     *
     * @param adId      идентификатор объявления
     * @param commentId идентификатор комментария
     * @param comment данные для обновления комментария
     * @return пустой объект CommentDTO
     */
    @PatchMapping
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Integer adId,
                                                    @PathVariable Integer commentId,
                                                    @RequestBody CreateOrUpdateCommentDTO comment) {
        return ResponseEntity.ok(new CommentDTO());
    }
}