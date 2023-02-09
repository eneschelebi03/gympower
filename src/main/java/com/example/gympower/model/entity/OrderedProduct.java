package com.example.gympower.model.entity;

import javax.persistence.*;

@Table(name = "ordered_products")
@Entity
public class OrderedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;

    private String name;

    private String sizeOrQuantity;

    private String colorOrFlavor;

    private double price;

    private int count;

    public long getId() {
        return id;
    }

    public OrderedProduct setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderedProduct setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public OrderedProduct setType(String type) {
        this.type = type;
        return this;
    }

    public String getSizeOrQuantity() {
        return sizeOrQuantity;
    }

    public OrderedProduct setSizeOrQuantity(String sizeOrQuantity) {
        this.sizeOrQuantity = sizeOrQuantity;
        return this;
    }

    public String getColorOrFlavor() {
        return colorOrFlavor;
    }

    public OrderedProduct setColorOrFlavor(String colorOrFlavor) {
        this.colorOrFlavor = colorOrFlavor;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public OrderedProduct setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getCount() {
        return count;
    }

    public OrderedProduct setCount(int count) {
        this.count = count;
        return this;
    }
}
