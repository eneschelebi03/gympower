package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.display.DisplayAddressDTO;
import com.example.gympower.model.dto.logic.AddressDTO;
import com.example.gympower.model.entity.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-31T17:49:01+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address addressDtoToAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setStreetAddress( addressDTO.getAddress() );
        address.setCountry( addressDTO.getCountry() );
        address.setCity( addressDTO.getCity() );
        address.setPostCode( addressDTO.getPostCode() );

        return address;
    }

    @Override
    public DisplayAddressDTO addressToDisplayDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        DisplayAddressDTO displayAddressDTO = new DisplayAddressDTO();

        displayAddressDTO.setAddress( address.getStreetAddress() );
        displayAddressDTO.setPostCode( address.getPostCode() );
        displayAddressDTO.setCity( address.getCity() );
        displayAddressDTO.setCountry( address.getCountry() );

        return displayAddressDTO;
    }
}
