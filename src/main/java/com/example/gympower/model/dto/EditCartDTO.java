package com.example.gympower.model.dto;

public class EditCartDTO {

    private long wearId;

    private String color;

    private String size;

    private int quantity;

    public long getWearId() {
        return wearId;
    }

    public EditCartDTO setWearId(long wearId) {
        this.wearId = wearId;
        return this;
    }

    public String getColor() {
        return color;
    }

    public EditCartDTO setColor(String color) {
        this.color = color;
        return this;
    }

    public String getSize() {
        return size;
    }

    public EditCartDTO setSize(String size) {
        this.size = size;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public EditCartDTO setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
