package ru.skypro.homework.mapper;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.AdDTO;
import ru.skypro.homework.dto.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ExtendedAdDTO;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.User;

@Service
public class AdMapper {

    public AdDTO toDto(Ad ad) {
        if (ad == null) return null;
        AdDTO dto = new AdDTO();
        dto.setPk(ad.getId().intValue());
        dto.setTitle(ad.getTitle());
        dto.setPrice(ad.getPrice());
        dto.setImage(ad.getImage());
        dto.setAuthor(ad.getAuthor() != null ? ad.getAuthor().getId().intValue() : null);
        return dto;
    }

    public ExtendedAdDTO toExtendedDto(Ad ad) {
        if (ad == null) return null;
        ExtendedAdDTO dto = new ExtendedAdDTO();
        dto.setPk(ad.getId().intValue());
        dto.setTitle(ad.getTitle());
        dto.setPrice(ad.getPrice());
        dto.setImage(ad.getImage());
        dto.setDescription(ad.getDescription());
        if (ad.getAuthor() != null) {
            dto.setAuthorUsername(ad.getAuthor().getUserName());
            dto.setEmail(ad.getAuthor().getEmail());
            dto.setPhone(ad.getAuthor().getPhone());
        }
        return dto;
    }

    public Ad toEntity(CreateOrUpdateAdDTO dto, User author) {
        if (dto == null) return null;
        Ad ad = new Ad();
        ad.setTitle(dto.getTitle());
        ad.setDescription(dto.getDescription());
        ad.setPrice(dto.getPrice());
        ad.setAuthor(author);
        return ad;
    }
}
