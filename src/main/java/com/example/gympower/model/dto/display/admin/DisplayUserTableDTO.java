package com.example.gympower.model.dto.display.admin;

public class DisplayUserTableDTO {
    private String name;
    private String username;
    private String phone;
    private String country;
    private String address;
    private String email;
    private int orders;

    public String getName() {
        return name;
    }

    public DisplayUserTableDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public DisplayUserTableDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public DisplayUserTableDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public DisplayUserTableDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public DisplayUserTableDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public DisplayUserTableDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getOrders() {
        return orders;
    }

    public DisplayUserTableDTO setOrders(int orders) {
        this.orders = orders;
        return this;
    }
}
