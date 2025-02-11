package ru.skypro.homework.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.RegisterDTO;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public AuthServiceImpl(UserDetailsManager userDetailsManager,
                           PasswordEncoder passwordEncoder, UserRepository userRepository, UserMapper userMapper) {
        this.userDetailsManager = userDetailsManager;
        this.encoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public boolean login(String userName, String password) {
        if (!userDetailsManager.userExists(userName)) {
            return false;
        }
        UserDetails userDetails = userDetailsManager.loadUserByUsername(userName);
        return encoder.matches(password, userDetails.getPassword());
    }

    @Override
    public boolean register(RegisterDTO registerDTO) {
        if (userDetailsManager.userExists(registerDTO.getUsername())) {
            return false;
        }
        // Преобразуем RegisterDTO в сущность User (в маппере можно установить email = registerDTO.getUsername())
        User user = userMapper.toEntity(registerDTO);
        // Кодируем пароль
        user.setPassword(encoder.encode(registerDTO.getPassword()));
        // Активируем пользователя
        user.setEnabled(true);
        // Если роль не указана, устанавливаем роль USER по умолчанию
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        userRepository.save(user);
        return true;
    }
}