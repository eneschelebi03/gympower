package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.AddressDTO;
import com.example.gympower.model.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address addressDtoToAddress(AddressDTO addressDTO);
}
