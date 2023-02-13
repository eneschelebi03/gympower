package com.example.gympower.service;

import com.example.gympower.model.entity.Address;
import com.example.gympower.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address save(Address address) {
        return this.addressRepository.save(address);
    }
}
