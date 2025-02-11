package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.LoginDTO;
import ru.skypro.homework.dto.RegisterDTO;
import ru.skypro.homework.service.AuthService;
import ru.skypro.homework.service.UserService;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class AuthController {

//    private final UserService userService;
//
//    public AuthController(UserService userService) {
//        this.userService = userService;
//    }

    @Operation(summary = "Регистрация пользователя", responses = {
            @ApiResponse(responseCode = "201", description = "Пользователь создан"),
            @ApiResponse(responseCode = "400", description = "Неверные входные данные")
    })
    @PostMapping("/register")
    public ResponseEntity<RegisterDTO> register(@RequestBody RegisterDTO registerDTO) {
        // Здесь должна быть логика регистрации, пока возвращаем пустой DTO
        return new ResponseEntity<>(new RegisterDTO(), HttpStatus.CREATED);
    }

    @Operation(summary = "Авторизация пользователя", responses = {
            @ApiResponse(responseCode = "200", description = "Авторизация успешна"),
            @ApiResponse(responseCode = "401", description = "Неверный логин или пароль")
    })
    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO loginDTO) {
        // Скелет: возвращаем пустой объект
        return ResponseEntity.ok(new LoginDTO());
    }
}