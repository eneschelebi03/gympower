package com.example.gympower.model.dto;

public class CarouselProductDTO {

    private String name;
    private String imageURL;
    private String description;

    public String getName() {
        return name;
    }

    public CarouselProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public CarouselProductDTO setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CarouselProductDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
