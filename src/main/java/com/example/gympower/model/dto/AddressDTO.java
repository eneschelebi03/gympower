package com.example.gympower.model.dto;

public class AddressDTO {

    private String fullName;

    private String postCode;

    private String address;

    private String city;

    private String country;

    private boolean saveAsPersonal;

    public String getFullName() {
        return fullName;
    }

    public AddressDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPostCode() {
        return postCode;
    }

    public AddressDTO setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AddressDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public AddressDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public boolean isSaveAsPersonal() {
        return saveAsPersonal;
    }

    public AddressDTO setSaveAsPersonal(boolean saveAsPersonal) {
        this.saveAsPersonal = saveAsPersonal;
        return this;
    }
}
