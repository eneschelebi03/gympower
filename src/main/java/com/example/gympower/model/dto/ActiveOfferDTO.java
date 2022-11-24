package com.example.gympower.model.dto;

import java.util.Set;

public class ActiveOfferDTO {

    private String pictureUrl;
    private String pictureTitle;
    private Set<String> category;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public ActiveOfferDTO setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public String getPictureTitle() {
        return pictureTitle;
    }

    public ActiveOfferDTO setPictureTitle(String pictureTitle) {
        this.pictureTitle = pictureTitle;
        return this;
    }

    public Set<String> getCategory() {
        return category;
    }

    public ActiveOfferDTO setCategory(Set<String> category) {
        this.category = category;
        return this;
    }
}
