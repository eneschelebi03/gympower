package com.example.gympower.model.entity;

import com.example.gympower.model.entity.products.wear.Wear;

import javax.persistence.*;

@Table(name = "cart_items")
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String color;
    private String size;
    private int count;

    @ManyToOne
    private Wear wear;


    public long getId() {
        return id;
    }

    public CartItem setId(long id) {
        this.id = id;
        return this;
    }

    public String getColor() {
        return color;
    }

    public CartItem setColor(String color) {
        this.color = color;
        return this;
    }

    public String getSize() {
        return size;
    }

    public CartItem setSize(String size) {
        this.size = size;
        return this;
    }

    public int getCount() {
        return count;
    }

    public CartItem setCount(int count) {
        this.count = count;
        return this;
    }

    public Wear getWear() {
        return wear;
    }

    public CartItem setWear(Wear wear) {
        this.wear = wear;
        return this;
    }
}
