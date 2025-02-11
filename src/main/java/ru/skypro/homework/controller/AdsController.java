package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.AdDTO;
import ru.skypro.homework.dto.AdsDTO;
import ru.skypro.homework.dto.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ExtendedAdDTO;
import ru.skypro.homework.service.AdsService;

/**
 * Контроллер для управления объявлениями.
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
@RequestMapping("/ads")
public class AdsController {

//    private final AdsService adsService;
//

    @Operation(summary = "Получение всех объявлений", responses = {
            @ApiResponse(responseCode = "200", description = "Объявления получены")
    })
    @GetMapping
    public ResponseEntity<AdsDTO> getAllAds() {
        AdsDTO ads = new AdsDTO();
        ads.setCount(0);
        ads.setResults(java.util.Collections.emptyList());
        return ResponseEntity.ok(ads);
    }

    @Operation(summary = "Добавление объявления", responses = {
            @ApiResponse(responseCode = "201", description = "Объявление создано"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PostMapping
    public ResponseEntity<AdDTO> addAd(@ModelAttribute CreateOrUpdateAdDTO ad) {
        // Скелет: возвращаем пустой объект
        return new ResponseEntity<>(new AdDTO(), HttpStatus.CREATED);
    }

    @Operation(summary = "Получение информации об объявлении", responses = {
            @ApiResponse(responseCode = "200", description = "Информация получена"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ExtendedAdDTO> getAd(@PathVariable Integer id) {
        return ResponseEntity.ok(new ExtendedAdDTO());
    }

    @Operation(summary = "Обновление объявления", responses = {
            @ApiResponse(responseCode = "200", description = "Объявление обновлено"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<AdDTO> updateAd(@PathVariable Integer id, @RequestBody CreateOrUpdateAdDTO ad) {
        return ResponseEntity.ok(new AdDTO());
    }

    @Operation(summary = "Удаление объявления", responses = {
            @ApiResponse(responseCode = "204", description = "Объявление удалено"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAd(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Получение объявлений авторизованного пользователя", responses = {
            @ApiResponse(responseCode = "200", description = "Объявления получены"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping("/me")
    public ResponseEntity<AdsDTO> getAdsMe() {
        AdsDTO ads = new AdsDTO();
        ads.setCount(0);
        ads.setResults(java.util.Collections.emptyList());
        return ResponseEntity.ok(ads);
    }

    @Operation(summary = "Обновление картинки объявления", responses = {
            @ApiResponse(responseCode = "200", description = "Картинка обновлена"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @PatchMapping("/{id}/image")
    public ResponseEntity<byte[]> updateImage(@PathVariable Integer id) {
        return ResponseEntity.ok(new byte[0]);
    }
}
