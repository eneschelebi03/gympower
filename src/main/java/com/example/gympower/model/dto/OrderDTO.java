package com.example.gympower.model.dto;

import java.util.List;

public class OrderDTO {

    private List<ProductOrderDTO> items;

    private AddressDTO details;

    public List<ProductOrderDTO> getItems() {
        return items;
    }

    public OrderDTO setItems(List<ProductOrderDTO> items) {
        this.items = items;
        return this;
    }

    public AddressDTO getDetails() {
        return details;
    }

    public OrderDTO setDetails(AddressDTO details) {
        this.details = details;
        return this;
    }
}
