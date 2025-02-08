package ru.skypro.homework.dto;

import lombok.Data;

/**
 * DTO для создания или обновления объявления.
 */
@Data
public class CreateOrUpdateAdDTO {
    private String title;
    private Integer price;
    private String description;
}