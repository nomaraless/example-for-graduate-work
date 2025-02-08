package ru.skypro.homework.dto;

import lombok.Data;

/**
 * DTO для комментария.
 */
@Data
public class CommentDTO {
    private Integer pk;
    private Integer author;
    private String authorImage;
    private String authorFirstName;
    private Long createdAt; // время в миллисекундах
    private String text;
}