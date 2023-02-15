package com.example.gympower.model.dto;


public class DisplayOrderedProductDTO {

    private String name;

    private String pictureUrl;

    private String sizeOrQuantity;

    private String colorOrFlavor;

    private double price;

    private int count;

    public String getName() {
        return name;
    }

    public DisplayOrderedProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public DisplayOrderedProductDTO setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public String getSizeOrQuantity() {
        return sizeOrQuantity;
    }

    public DisplayOrderedProductDTO setSizeOrQuantity(String sizeOrQuantity) {
        this.sizeOrQuantity = sizeOrQuantity;
        return this;
    }

    public String getColorOrFlavor() {
        return colorOrFlavor;
    }

    public DisplayOrderedProductDTO setColorOrFlavor(String colorOrFlavor) {
        this.colorOrFlavor = colorOrFlavor;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public DisplayOrderedProductDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getCount() {
        return count;
    }

    public DisplayOrderedProductDTO setCount(int count) {
        this.count = count;
        return this;
    }
}
