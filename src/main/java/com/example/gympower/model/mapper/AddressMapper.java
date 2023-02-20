package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.logic.AddressDTO;
import com.example.gympower.model.dto.display.DisplayAddressDTO;
import com.example.gympower.model.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "streetAddress", source = "address")
    Address addressDtoToAddress(AddressDTO addressDTO);

    @Mapping(target = "address", source = "streetAddress")
    DisplayAddressDTO addressToDisplayDTO(Address address);
}
