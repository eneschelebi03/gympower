package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.display.DisplayUserDTO;
import com.example.gympower.model.dto.display.admin.DisplayUserTableDTO;
import com.example.gympower.model.dto.logic.RegisterDTO;
import com.example.gympower.model.entity.Address;
import com.example.gympower.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract UserEntity registerDTOToUser(RegisterDTO registerDTO);

    @Mapping(target = "orders", source = "user", qualifiedByName = "userOrders")
    @Mapping(target = "address.address", source = "address.streetAddress")
    public abstract DisplayUserDTO userToDetailsDTO(UserEntity user);

    @Mapping(target = "name", source = "user", qualifiedByName = "userName")
    @Mapping(target = "orders", source = "user", qualifiedByName = "userOrders")
    @Mapping(target = "address", source = "user", qualifiedByName = "userAddress")
    @Mapping(target = "country", source = "user", qualifiedByName = "userCountry")
    public abstract DisplayUserTableDTO userToUserTableDTO(UserEntity user);

    @Named("userOrders")
    int userOrders(UserEntity user) {
        return user.getOrders().size();
    }

    @Named("userAddress")
    String userAddress(UserEntity user) {
        Address address = user.getAddress();

        if (address == null) {
            return null;
        }

        return String.format("%s, %s, %s",
                address.getPostCode(),
                address.getPostCode(),
                address.getStreetAddress());
    }

    @Named("userCountry")
    String userCountry(UserEntity user) {
        Address address = user.getAddress();

        if (address == null) {
            return null;
        }

        return address.getCountry();
    }

    @Named("userName")
    String userName(UserEntity user) {;
        return user.getFirstName() + " " + user.getLastName();
    }
}
