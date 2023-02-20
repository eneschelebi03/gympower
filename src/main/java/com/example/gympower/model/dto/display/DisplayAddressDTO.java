package com.example.gympower.model.dto.display;

public class DisplayAddressDTO {

    private String postCode;

    private String address;

    private String city;

    private String country;

    public String getPostCode() {
        return postCode;
    }

    public DisplayAddressDTO setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public DisplayAddressDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public DisplayAddressDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public DisplayAddressDTO setCountry(String country) {
        this.country = country;
        return this;
    }
}
