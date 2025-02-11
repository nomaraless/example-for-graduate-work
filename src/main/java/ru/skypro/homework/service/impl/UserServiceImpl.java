package ru.skypro.homework.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Регистрирует нового пользователя.
     */
    public User register(User user) {
        // Кодировать пароль
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Активируем пользователя
        user.setEnabled(true);
        return userRepository.save(user);
    }

    /**
     * Изменяет пароль пользователя.
     *
     * @param username        имя пользователя (email)
     * @param currentPassword текущий пароль
     * @param newPassword     новый пароль
     * @return Optional с новым паролем, если успешно, иначе пустой Optional
     */
    public void changePassword(String username, String currentPassword, String newPassword) {
        Optional<User> userOpt = userRepository.findByEmail(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(currentPassword, user.getPassword())) {
                user.setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(user);
            } else {
                throw new IllegalArgumentException("Текущий пароль неверен");
            }
        } else {
            throw new IllegalArgumentException("Пользователь не найден");
        }
    }

    /**
     * Возвращает пользователя по email.
     */
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

