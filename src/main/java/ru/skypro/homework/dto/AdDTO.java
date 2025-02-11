package ru.skypro.homework.dto;

/**
 * DTO для объявления.
 */
public class AdDTO {
    private Integer pk;
    private Integer author;
    private String title;
    private Integer price;
    private String image;

    public AdDTO() {
    }

    public Integer getPk() {
        return pk;
    }
    public void setPk(Integer pk) {
        this.pk = pk;
    }
    public Integer getAuthor() {
        return author;
    }
    public void setAuthor(Integer author) {
        this.author = author;
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
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
