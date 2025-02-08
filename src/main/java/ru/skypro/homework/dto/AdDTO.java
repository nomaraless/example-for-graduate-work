package ru.skypro.homework.dto;

import lombok.Data;

/**
 * DTO для объявления.
 */
@Data
public class AdDTO {
    private Integer pk;
    private Integer author;
    private String title;
    private Integer price;
    private String image;
}
