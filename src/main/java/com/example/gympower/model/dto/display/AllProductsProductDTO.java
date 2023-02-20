package com.example.gympower.model.dto.display;

public class AllProductsProductDTO {
    private long id;

    private String name;

    private double rating;

    private double price;

    private String pictureUrl;

    private String description;

    public long getId() {
        return id;
    }

    public AllProductsProductDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AllProductsProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public AllProductsProductDTO setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public AllProductsProductDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public AllProductsProductDTO setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AllProductsProductDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
