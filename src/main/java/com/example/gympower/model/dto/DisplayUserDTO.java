package com.example.gympower.model.dto;

public class DisplayUserDTO {

    private String username;

    private String email;

    private int orders;

    private DisplayAddressDTO address;

    public String getUsername() {
        return username;
    }

    public DisplayUserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public DisplayUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getOrders() {
        return orders;
    }

    public DisplayUserDTO setOrders(int orders) {
        this.orders = orders;
        return this;
    }

    public DisplayAddressDTO getAddress() {
        return address;
    }

    public DisplayUserDTO setAddress(DisplayAddressDTO address) {
        this.address = address;
        return this;
    }
}
