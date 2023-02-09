package com.example.gympower.model.dto;

import java.util.List;

public class OrderDTO {

    private List<ProductOrderDTO> productOrderDTOs;

    private AddressDTO addressDTO;

    public List<ProductOrderDTO> getProductOrderDTOs() {
        return productOrderDTOs;
    }

    public OrderDTO setProductOrderDTOs(List<ProductOrderDTO> productOrderDTOs) {
        this.productOrderDTOs = productOrderDTOs;
        return this;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public OrderDTO setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
        return this;
    }
}
