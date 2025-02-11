package ru.skypro.homework.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // email используется как уникальный логин
    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", length = 50)
    private String userName;

    @Column(length = 20)
    private String phone;

    // Роль пользователя: USER, ADMIN
    @Column(length = 20, nullable = false)
    private String role;

    // Ссылка на аватар (например, URL)
    private String image;

    // Пароль для аутентификации
    @Column(nullable = false)
    private String password;

    // Флаг активности пользователя
    @Column(nullable = false)
    private boolean enabled;

    public User() {
    }

    public User(Long id, String email, String userName, String phone, String role, String image, String password, boolean enabled) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.phone = phone;
        this.role = role;
        this.image = image;
        this.password = password;
        this.enabled = enabled;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
