package ru.skypro.homework.dto;

import lombok.Data;

/**
 * DTO для авторизации пользователя.
 */
@Data
public class LoginDTO {

    private String username;
    private String password;
}
