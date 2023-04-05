package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.display.DisplayAddressDTO;
import com.example.gympower.model.dto.display.DisplayUserDTO;
import com.example.gympower.model.dto.display.admin.DisplayUserTableDTO;
import com.example.gympower.model.dto.logic.RegisterDTO;
import com.example.gympower.model.entity.Address;
import com.example.gympower.model.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T03:47:09+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public UserEntity registerDTOToUser(RegisterDTO registerDTO) {
        if ( registerDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setEmail( registerDTO.getEmail() );
        userEntity.setPassword( registerDTO.getPassword() );
        userEntity.setUsername( registerDTO.getUsername() );

        return userEntity;
    }

    @Override
    public DisplayUserDTO userToDetailsDTO(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        DisplayUserDTO displayUserDTO = new DisplayUserDTO();

        displayUserDTO.setAddress( addressToDisplayAddressDTO( user.getAddress() ) );
        displayUserDTO.setOrders( userOrders( user ) );
        displayUserDTO.setFirstName( user.getFirstName() );
        displayUserDTO.setLastName( user.getLastName() );
        displayUserDTO.setUsername( user.getUsername() );
        displayUserDTO.setEmail( user.getEmail() );

        return displayUserDTO;
    }

    @Override
    public DisplayUserTableDTO userToUserTableDTO(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        DisplayUserTableDTO displayUserTableDTO = new DisplayUserTableDTO();

        displayUserTableDTO.setName( userName( user ) );
        displayUserTableDTO.setOrders( userOrders( user ) );
        displayUserTableDTO.setAddress( userAddress( user ) );
        displayUserTableDTO.setCountry( userCountry( user ) );
        displayUserTableDTO.setUsername( user.getUsername() );
        displayUserTableDTO.setEmail( user.getEmail() );

        return displayUserTableDTO;
    }

    protected DisplayAddressDTO addressToDisplayAddressDTO(Address address) {
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
