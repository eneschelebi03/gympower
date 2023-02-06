package com.example.gympower.model.dto;

public class DisplayCartItemDTO {

    private long id;
    private String name;
    private double price;
    private String pictureUrl;
    private String color;
    private String size;

    public long getId() {
        return id;
    }

    public DisplayCartItemDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DisplayCartItemDTO setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public DisplayCartItemDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public DisplayCartItemDTO setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public String getColor() {
        return color;
    }

    public DisplayCartItemDTO setColor(String color) {
        this.color = color;
        return this;
    }

    public String getSize() {
        return size;
    }

    public DisplayCartItemDTO setSize(String size) {
        this.size = size;
        return this;
    }
}
