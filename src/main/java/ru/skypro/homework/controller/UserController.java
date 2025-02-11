package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.NewPasswordDTO;
import ru.skypro.homework.dto.UpdateUserDTO;
import ru.skypro.homework.dto.UserDTO;
import ru.skypro.homework.service.UserService;

/**
 * Контроллер для управления информацией об авторизованном пользователе.
 */
@RestController
@Slf4j
@CrossOrigin("http://localhost:3000")
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @Operation(summary = "Обновление пароля", responses = {
            @ApiResponse(responseCode = "200", description = "Пароль обновлен"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @PostMapping("/set_password")
    public ResponseEntity<Void> setPassword(@RequestBody NewPasswordDTO newPasswordDTO, Authentication authentication) {
        String username = authentication.getName();
        userService.changePassword(username, newPasswordDTO.getCurrentPassword(), newPasswordDTO.getNewPassword());
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Получение информации об авторизованном пользователе", responses = {
            @ApiResponse(responseCode = "200", description = "Информация получена"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping("/me")
    public ResponseEntity<UserDTO> getUser(Authentication authentication) {
        // Для скелета возвращаем пустой объект
        return ResponseEntity.ok(new UserDTO());
    }

    @Operation(summary = "Обновление информации об авторизованном пользователе", responses = {
            @ApiResponse(responseCode = "200", description = "Информация обновлена"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PatchMapping("/me")
    public ResponseEntity<UpdateUserDTO> updateUser(@RequestBody UpdateUserDTO updateUserDTO) {
        // Скелет: возвращаем переданный объект
        return ResponseEntity.ok(updateUserDTO);
    }

    @Operation(summary = "Обновление аватара пользователя", responses = {
            @ApiResponse(responseCode = "200", description = "Аватар обновлен"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PatchMapping("/me/image")
    public ResponseEntity<Void> updateUserImage() {
        return ResponseEntity.ok().build();
    }
}
