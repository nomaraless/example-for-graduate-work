package ru.skypro.homework.dto;

/**
 * DTO для создания или обновления объявления.
 */
public class CreateOrUpdateAdDTO {
    private String title;
    private Integer price;
    private String description;

    public CreateOrUpdateAdDTO() {
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
