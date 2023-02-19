package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.DisplayUserDTO;
import com.example.gympower.model.dto.RegisterDTO;
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

    @Named("userOrders")
    int userOrders(UserEntity user) {
        return user.getOrders().size();
    }
}
