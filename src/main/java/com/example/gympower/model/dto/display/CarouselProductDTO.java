package com.example.gympower.model.dto.display;

public class CarouselProductDTO {

    private long id;

    private String name;

    private double rating;

    private double price;

    private String pictureUrl;


    public long getId() {
        return id;
    }

    public CarouselProductDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CarouselProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public CarouselProductDTO setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public CarouselProductDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public CarouselProductDTO setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }
}
