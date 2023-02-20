package com.example.gympower.model.dto.logic;

public class ProductOrderDTO {
    private long id;

    private int quantity;

    public long getId() {
        return id;
    }

    public ProductOrderDTO setId(long id) {
        this.id = id;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductOrderDTO setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
