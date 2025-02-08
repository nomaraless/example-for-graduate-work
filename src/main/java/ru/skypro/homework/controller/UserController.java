package ru.skypro.homework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.NewPasswordDTO;
import ru.skypro.homework.dto.UpdateUserDTO;
import ru.skypro.homework.dto.UserDTO;

/**
 * Контроллер для управления информацией об авторизованном пользователе.
 */
@Slf4j
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * Обновление пароля.
     *
     * @param newPasswordDTO объект с текущим и новым паролем
     * @return HTTP 200 OK
     */
    @PostMapping("/set_password")
    public ResponseEntity<Void> setPassword(@RequestBody NewPasswordDTO newPasswordDTO) {
        // Скелет: здесь должна быть логика обновления пароля
        return ResponseEntity.ok().build();
    }

    /**
     * Получение информации об авторизованном пользователе.
     *
     * @return пустой объект UserDTO
     */
    @GetMapping("/me")
    public ResponseEntity<UserDTO> getUser() {
        // Возвращаем пустой объект (скелет)
        return ResponseEntity.ok(new UserDTO());
    }

    /**
     * Обновление информации об авторизованном пользователе.
     *
     * @param updateUserDTO данные для обновления
     * @return обновленный объект UpdateUserDTO
     */
    @PatchMapping("/me")
    public ResponseEntity<UpdateUserDTO> updateUser(@RequestBody UpdateUserDTO updateUserDTO) {
        // Возвращаем переданный объект (скелет)
        return ResponseEntity.ok(updateUserDTO);
    }

    /**
     * Обновление аватара авторизованного пользователя.
     *
     * @return HTTP 200 OK
     */
    @PatchMapping("/me/image")
    public ResponseEntity<Void> updateUserImage() {
        // Скелет: логика загрузки изображения отсутствует
        return ResponseEntity.ok().build();
    }
}
