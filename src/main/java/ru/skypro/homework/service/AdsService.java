package ru.skypro.homework.service;

import ru.skypro.homework.dto.AdDTO;
import ru.skypro.homework.dto.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ExtendedAdDTO;
import ru.skypro.homework.entity.User;

import java.util.List;

public interface AdsService {
    public List<AdDTO> getAllAds();

    public ExtendedAdDTO getAdById(Long id);

    public AdDTO createAd(CreateOrUpdateAdDTO dto, User author);

    public AdDTO updateAd(Long id, CreateOrUpdateAdDTO dto, User currentUser);

    public void deleteAd(Long id, User currentUser);
}
