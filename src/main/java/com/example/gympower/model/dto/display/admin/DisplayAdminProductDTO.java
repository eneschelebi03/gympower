package com.example.gympower.model.dto.display.admin;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class DisplayAdminProductDTO {
    private String pictureUrl;

    private String name;

    private Set<String> categories;

    private List<String> options;

    private String price;

    private String cost;

    private double rating;

    private LocalDateTime addedOn;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public DisplayAdminProductDTO setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public DisplayAdminProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public DisplayAdminProductDTO setCategories(Set<String> categories) {
        this.categories = categories;
        return this;
    }

    public List<String> getOptions() {
        return options;
    }

    public DisplayAdminProductDTO setOptions(List<String> options) {
        this.options = options;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public DisplayAdminProductDTO setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getCost() {
        return cost;
    }

    public DisplayAdminProductDTO setCost(String cost) {
        this.cost = cost;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public DisplayAdminProductDTO setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public DisplayAdminProductDTO setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
        return this;
    }
}
