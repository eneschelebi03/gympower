package com.example.gympower.model.dto;

import com.example.gympower.model.entity.products.wear.Color;
import com.example.gympower.model.entity.products.wear.Size;

import java.util.Set;

public class WearDetailsDTO {

    private long id;

    private String name;

    private Set<Color> colors;

    private Set<String> categories;

    private String description;

    public long getId() {
        return id;
    }

    public WearDetailsDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public WearDetailsDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Color> getColors() {
        return colors;
    }

    public WearDetailsDTO setColors(Set<Color> colors) {
        this.colors = colors;
        return this;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public WearDetailsDTO setCategories(Set<String> categories) {
        this.categories = categories;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public WearDetailsDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
