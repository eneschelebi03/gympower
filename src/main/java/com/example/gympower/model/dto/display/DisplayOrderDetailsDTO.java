package com.example.gympower.model.dto.display;

import java.util.List;

public class DisplayOrderDetailsDTO {
    private List<DisplayOrderedProductDTO> orderItems;

    private DisplayAddressDTO address;

    public List<DisplayOrderedProductDTO> getOrderItems() {
        return orderItems;
    }

    public DisplayOrderDetailsDTO setOrderItems(List<DisplayOrderedProductDTO> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public DisplayAddressDTO getAddress() {
        return address;
    }

    public DisplayOrderDetailsDTO setAddress(DisplayAddressDTO address) {
        this.address = address;
        return this;
    }
}
