package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.display.DisplayRecentOrderDTO;
import com.example.gympower.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "orderItems", source = "orderedProducts")
    @Mapping(target = "orderedAt", source = "createdAt")
    @Mapping(target = "orderId", source = "id")
    @Mapping(target = "userId", source = "user.id")
    DisplayRecentOrderDTO orderToRecentOrderDTO(Order order);
}
