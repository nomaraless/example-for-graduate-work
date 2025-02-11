package ru.skypro.homework.dto;

/**
 * DTO для обновления информации об авторизованном пользователе.
 */
public class UpdateUserDTO {
    private String firstName;
    private String lastName;
    private String phone;

    public UpdateUserDTO() {
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}

