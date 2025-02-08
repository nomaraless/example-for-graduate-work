package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.AdDTO;
import ru.skypro.homework.dto.AdsDTO;
import ru.skypro.homework.dto.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ExtendedAdDTO;

/**
 * Контроллер для управления объявлениями.
 */
@RestController
@RequestMapping("/ads")
public class AdsController {

    /**
     * Получение всех объявлений.
     *
     * @return пустой объект AdsDTO
     */
    @GetMapping
    public ResponseEntity<AdsDTO> getAllAds() {
        // Возвращаем пустой список объявлений
        AdsDTO ads = new AdsDTO();
        ads.setCount(0);
        ads.setResults(java.util.Collections.emptyList());
        return ResponseEntity.ok(ads);
    }

    /**
     * Добавление объявления.
     *
     * @param ad данные объявления
     * @return пустой объект AdDTO
     */
    @PostMapping
    public ResponseEntity<AdDTO> addAd(@ModelAttribute CreateOrUpdateAdDTO ad) {
        // Скелет: возвращаем пустой объект
        return new ResponseEntity<>(new AdDTO(), HttpStatus.CREATED);
    }

    /**
     * Получение информации об объявлении.
     *
     * @param id идентификатор объявления
     * @return пустой объект ExtendedAdDTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<ExtendedAdDTO> getAd(@PathVariable Integer id) {
        return ResponseEntity.ok(new ExtendedAdDTO());
    }

    /**
     * Обновление информации об объявлении.
     *
     * @param id идентификатор объявления
     * @param ad данные для обновления
     * @return пустой объект AdDTO
     */
    @PatchMapping("/{id}")
    public ResponseEntity<AdDTO> updateAd(@PathVariable Integer id, @RequestBody CreateOrUpdateAdDTO ad) {
        return ResponseEntity.ok(new AdDTO());
    }

    /**
     * Удаление объявления.
     *
     * @param id идентификатор объявления
     * @return HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAd(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }

    /**
     * Получение объявлений авторизованного пользователя.
     *
     * @return пустой объект AdsDTO
     */
    @GetMapping("/me")
    public ResponseEntity<AdsDTO> getAdsMe() {
        AdsDTO ads = new AdsDTO();
        ads.setCount(0);
        ads.setResults(java.util.Collections.emptyList());
        return ResponseEntity.ok(ads);
    }

    /**
     * Обновление картинки объявления.
     *
     * @param id идентификатор объявления
     * @return HTTP 200 OK
     */
    @PatchMapping("/{id}/image")
    public ResponseEntity<byte[]> updateImage(@PathVariable Integer id) {
        // Скелет: возвращаем пустой массив байтов
        return ResponseEntity.ok(new byte[0]);
    }
}
