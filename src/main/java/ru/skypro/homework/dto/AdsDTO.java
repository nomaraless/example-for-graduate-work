package ru.skypro.homework.dto;

import java.util.List;

/**
 * DTO для списка объявлений.
 */
public class AdsDTO {
    private Integer count;
    private List<AdDTO> results;

    public AdsDTO() {
    }

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public List<AdDTO> getResults() {
        return results;
    }
    public void setResults(List<AdDTO> results) {
        this.results = results;
    }
}
