package com.example.gympower.model.dto.display;

public class DisplayProductDTO {

    private long id;

    private String name;

    private double rating;

    private double price;

    private String pictureUrl;

    private String description;

    public long getId() {
        return id;
    }

    public DisplayProductDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DisplayProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public DisplayProductDTO setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public DisplayProductDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public DisplayProductDTO setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DisplayProductDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
