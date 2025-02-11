package ru.skypro.homework.mapper;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.RegisterDTO;
import ru.skypro.homework.dto.UserDTO;
import ru.skypro.homework.entity.User;

@Service
public class UserMapper {

    public UserDTO toDto(User user) {
        if (user == null) return null;
        UserDTO dto = new UserDTO();
        dto.setId(user.getId().intValue());
        dto.setEmail(user.getEmail());
        dto.setUserName(user.getUserName());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        dto.setImage(user.getImage());
        return dto;
    }

    public User toEntity(UserDTO dto) {
        if (dto == null) return null;
        User user = new User();
        user.setId(dto.getId() != null ? dto.getId().longValue() : null);
        user.setEmail(dto.getEmail());
        user.setUserName(dto.getUserName());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
        user.setImage(dto.getImage());
        return user;
    }

    public User toEntity(RegisterDTO dto) {
        User user = new User();
        user.setUserName(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
        return user;

    }
}
