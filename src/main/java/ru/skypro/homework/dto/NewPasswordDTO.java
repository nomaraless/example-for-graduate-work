package ru.skypro.homework.dto;

import lombok.Data;

/**
 * DTO для запроса обновления пароля.
 */
@Data
public class NewPasswordDTO {
    private String currentPassword;
    private String newPassword;
}