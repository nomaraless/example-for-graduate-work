package ru.skypro.homework.dto;

import lombok.Data;

/**
 * DTO для обновления информации об авторизованном пользователе.
 */
@Data
public class UpdateUserDTO {
    private String firstName;
    private String lastName;
    private String phone;
}

