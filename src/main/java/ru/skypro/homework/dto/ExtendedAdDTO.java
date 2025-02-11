package ru.skypro.homework.dto;

/**
 * Расширенный DTO для объявления с дополнительной информацией.
 */
public class ExtendedAdDTO {
    private Integer pk;
    private String authorUsername;
    private String description;
    private String email;
    private String image;
    private String phone;
    private Integer price;
    private String title;

    public ExtendedAdDTO() {
    }

    public Integer getPk() {
        return pk;
    }
    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
