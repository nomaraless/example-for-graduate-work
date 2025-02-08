package ru.skypro.homework.dto;

import lombok.Data;

/**
 * DTO для создания или обновления комментария.
 */
@Data
public class CreateOrUpdateCommentDTO {
    private String text;
}
