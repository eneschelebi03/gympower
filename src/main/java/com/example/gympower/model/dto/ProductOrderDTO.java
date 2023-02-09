package com.example.gympower.model.dto;

import java.util.List;

public class ProductOrderDTO {
    private List<String> categories;

    private long id;

    private int count;

    private double price;

    private String colorOrFlavor;

    private String sizeOrQuantity;

    public List<String> getCategories() {
        return categories;
    }

    public ProductOrderDTO setCategories(List<String> categories) {
        this.categories = categories;
        return this;
    }

    public long getId() {
        return id;
    }

    public ProductOrderDTO setId(long id) {
        this.id = id;
        return this;
    }

    public int getCount() {
        return count;
    }

    public ProductOrderDTO setCount(int count) {
        this.count = count;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ProductOrderDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getColorOrFlavor() {
        return colorOrFlavor;
    }

    public ProductOrderDTO setColorOrFlavor(String colorOrFlavor) {
        this.colorOrFlavor = colorOrFlavor;
        return this;
    }

    public String getSizeOrQuantity() {
        return sizeOrQuantity;
    }

    public ProductOrderDTO setSizeOrQuantity(String sizeOrQuantity) {
        this.sizeOrQuantity = sizeOrQuantity;
        return this;
    }
}
