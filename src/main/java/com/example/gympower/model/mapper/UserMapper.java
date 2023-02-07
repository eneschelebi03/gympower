package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.RegisterDTO;
import com.example.gympower.model.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity registerDTOToUser(RegisterDTO registerDTO);
}
