package com.example.gympower.model.dto.display.admin;

public class DisplayAdminOrderedProductDTO {

    private String pictureUrl;

    private String name;

    private String type;

    private String sizeOrQuantity;

    private String colorOrFlavor;

    private double price;

    private double cost;

    private int count;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public DisplayAdminOrderedProductDTO setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public DisplayAdminOrderedProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public DisplayAdminOrderedProductDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getSizeOrQuantity() {
        return sizeOrQuantity;
    }

    public DisplayAdminOrderedProductDTO setSizeOrQuantity(String sizeOrQuantity) {
        this.sizeOrQuantity = sizeOrQuantity;
        return this;
    }

    public String getColorOrFlavor() {
        return colorOrFlavor;
    }

    public DisplayAdminOrderedProductDTO setColorOrFlavor(String colorOrFlavor) {
        this.colorOrFlavor = colorOrFlavor;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public DisplayAdminOrderedProductDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getCost() {
        return cost;
    }

    public DisplayAdminOrderedProductDTO setCost(double cost) {
        this.cost = cost;
        return this;
    }

    public int getCount() {
        return count;
    }

    public DisplayAdminOrderedProductDTO setCount(int count) {
        this.count = count;
        return this;
    }
}
