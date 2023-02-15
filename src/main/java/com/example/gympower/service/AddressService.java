package com.example.gympower.service;

import com.example.gympower.model.dto.DisplayAddressDTO;
import com.example.gympower.model.entity.Address;
import com.example.gympower.model.entity.Order;
import com.example.gympower.model.mapper.AddressMapper;
import com.example.gympower.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public Address save(Address address) {
        return this.addressRepository.save(address);
    }

    public DisplayAddressDTO findOrdersAddress(Order currentOrder) {
        Address currentAddress = currentOrder.getAddress();
        return this.addressMapper.addressToDisplayDTO(currentAddress);
    }
}
