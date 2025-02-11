package ru.skypro.homework.dto;

/**
 * DTO для создания или обновления комментария.
 */
public class CreateOrUpdateCommentDTO {
    private String text;

    public CreateOrUpdateCommentDTO() {
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
