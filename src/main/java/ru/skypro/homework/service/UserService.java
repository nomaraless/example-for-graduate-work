package ru.skypro.homework.service;

import ru.skypro.homework.entity.User;

import java.util.Optional;

public interface UserService {
    User register(User user);

    void changePassword(String username, String currentPassword, String newPassword);

    Optional<User> findByEmail(String email);
}
