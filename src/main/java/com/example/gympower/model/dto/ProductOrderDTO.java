package com.example.gympower.model.dto;

public class ProductOrderDTO {
    private long id;

    private int count;

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
}
