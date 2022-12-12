package com.example.gympower.model.dto;

public class TopSuppDTO {

    private long id;

    private String name;

    private double rating;

    private double price;

    private String pictureUrl;


    public long getId() {
        return id;
    }

    public TopSuppDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TopSuppDTO setName(String name) {
        this.name = name;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public TopSuppDTO setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public TopSuppDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public TopSuppDTO setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }
}
