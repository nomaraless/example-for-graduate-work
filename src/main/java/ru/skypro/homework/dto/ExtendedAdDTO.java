package ru.skypro.homework.dto;

import lombok.Data;

/**
 * Расширенный DTO для объявления с дополнительной информацией.
 */
@Data
public class ExtendedAdDTO {
    private Integer pk;
    private String authorFirstName;
    private String authorLastName;
    private String description;
    private String email;
    private String image;
    private String phone;
    private Integer price;
    private String title;
}