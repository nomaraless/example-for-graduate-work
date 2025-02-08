package ru.skypro.homework.dto;

import lombok.Data;

import java.util.List;

/**
 * DTO для списка объявлений.
 */
@Data
public class AdsDTO {
    private Integer count;
    private List<AdDTO> results;
}
