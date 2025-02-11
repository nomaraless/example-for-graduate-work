package ru.skypro.homework.dto;

/**
 * DTO для обновления пароля.
 */
public class NewPasswordDTO {
    private String currentPassword;
    private String newPassword;

    public NewPasswordDTO() {
    }

    public String getCurrentPassword() {
        return currentPassword;
    }
    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }
    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
