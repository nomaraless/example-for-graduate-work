package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CommentDTO;
import ru.skypro.homework.dto.CommentsDTO;
import ru.skypro.homework.dto.CreateOrUpdateCommentDTO;

/**
 * Контроллер для управления комментариями к объявлениям.
 */
@RestController
@Slf4j
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/ads/{adId}/comments")
public class CommentsController {

    @Operation(summary = "Получение комментариев объявления", responses = {
            @ApiResponse(responseCode = "200", description = "Комментарии получены"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @GetMapping
    public ResponseEntity<CommentsDTO> getComments(@PathVariable Integer adId) {
        CommentsDTO comments = new CommentsDTO();
        comments.setCount(0);
        comments.setResults(java.util.Collections.emptyList());
        return ResponseEntity.ok(comments);
    }

    @Operation(summary = "Добавление комментария к объявлению", responses = {
            @ApiResponse(responseCode = "200", description = "Комментарий добавлен"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @PostMapping
    public ResponseEntity<CommentDTO> addComment(@PathVariable Integer adId, @RequestBody CreateOrUpdateCommentDTO comment) {
        return ResponseEntity.ok(new CommentDTO());
    }

    @Operation(summary = "Удаление комментария", responses = {
            @ApiResponse(responseCode = "200", description = "Комментарий удален"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @DeleteMapping
    public ResponseEntity<Void> deleteComment(@PathVariable Integer adId, @PathVariable Integer commentId) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновление комментария", responses = {
            @ApiResponse(responseCode = "200", description = "Комментарий обновлен"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @PatchMapping
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Integer adId,
                                                    @PathVariable Integer commentId,
                                                    @RequestBody CreateOrUpdateCommentDTO comment) {
        return ResponseEntity.ok(new CommentDTO());
    }
}
