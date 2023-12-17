package com.example.gympower.model.dto.logic;

public class LogProductOrderDto {

    private long id;
    private String name;

    private String sizeOrQuantity;

    private String colorOrFlavor;

    private double price;

    private double cost;

    private int count;

    public long getId() {
        return id;
    }

    public LogProductOrderDto setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LogProductOrderDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSizeOrQuantity() {
        return sizeOrQuantity;
    }

    public LogProductOrderDto setSizeOrQuantity(String sizeOrQuantity) {
        this.sizeOrQuantity = sizeOrQuantity;
        return this;
    }

    public String getColorOrFlavor() {
        return colorOrFlavor;
    }

    public LogProductOrderDto setColorOrFlavor(String colorOrFlavor) {
        this.colorOrFlavor = colorOrFlavor;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public LogProductOrderDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getCost() {
        return cost;
    }

    public LogProductOrderDto setCost(double cost) {
        this.cost = cost;
        return this;
    }

    public int getCount() {
        return count;
    }

    public LogProductOrderDto setCount(int count) {
        this.count = count;
        return this;
    }

    @Override
    public String toString() {
        return "Product: " + id + '\'' +
                "Name: " + name + '\'' +
                "Size/Quantity: " + sizeOrQuantity + '\'' +
                "Color/Flavor: " + colorOrFlavor + '\'' +
                "Price: " + price + '\'' +
                "Cost: " + cost + '\'' +
                "Count: " + count + '\'';
    }
}
