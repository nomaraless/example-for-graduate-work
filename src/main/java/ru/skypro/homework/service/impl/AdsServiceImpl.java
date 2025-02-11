package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.AdDTO;
import ru.skypro.homework.dto.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ExtendedAdDTO;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.AdMapper;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.service.AdsService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdsServiceImpl implements AdsService {

    private final AdRepository adRepository;
    private final AdMapper adMapper;

    public AdsServiceImpl(AdRepository adRepository, AdMapper adMapper) {
        this.adRepository = adRepository;
        this.adMapper = adMapper;
    }

    public List<AdDTO> getAllAds() {
        List<Ad> ads = adRepository.findAll();
        return ads.stream()
                .map(adMapper::toDto)
                .collect(Collectors.toList());
    }

    public ExtendedAdDTO getAdById(Long id) {
        return adRepository.findById(id)
                .map(adMapper::toExtendedDto)
                .orElse(null);
    }

    public AdDTO createAd(CreateOrUpdateAdDTO dto, User author) {
        Ad ad = adMapper.toEntity(dto, author);
        Ad saved = adRepository.save(ad);
        return adMapper.toDto(saved);
    }

    public AdDTO updateAd(Long id, CreateOrUpdateAdDTO dto, User currentUser) {
        return adRepository.findById(id)
                .map(existing -> {
                    // Проверка: если пользователь не является автором и не ADMIN, то запрещаем
                    if (!existing.getAuthor().getId().equals(currentUser.getId()) &&
                            !"ADMIN".equalsIgnoreCase(currentUser.getRole())) {
                        throw new RuntimeException("Доступ запрещен");
                    }
                    existing.setTitle(dto.getTitle());
                    existing.setDescription(dto.getDescription());
                    existing.setPrice(dto.getPrice());
                    Ad updated = adRepository.save(existing);
                    return adMapper.toDto(updated);
                })
                .orElseThrow(() -> new RuntimeException("Объявление не найдено"));
    }

    public void deleteAd(Long id, User currentUser) {
        Ad ad = adRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Объявление не найдено"));
        // Проверка прав: автор или ADMIN
        if (!ad.getAuthor().getId().equals(currentUser.getId()) &&
                !"ADMIN".equalsIgnoreCase(currentUser.getRole())) {
            throw new RuntimeException("Доступ запрещен");
        }
        adRepository.deleteById(id);
    }
}
