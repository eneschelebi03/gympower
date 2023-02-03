package com.example.gympower.model.dto;

public class CartDTO {

    private String name;
    private double price;
    private String pictureUrl;

    public String getName() {
        return name;
    }

    public CartDTO setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public CartDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public CartDTO setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }
}
