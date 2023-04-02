package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.display.ActiveOfferDTO;
import com.example.gympower.model.entity.Category;
import com.example.gympower.model.entity.products.ExclusiveOffer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ExclusiveOfferMapper {

    @Mapping(target = "pictureUrl", source = "exclusivePicture.url")
    @Mapping(target = "pictureTitle", source = "exclusivePicture.title")
    @Mapping(target = "category", source = "exclusiveOffer")
    public abstract ActiveOfferDTO offerToActiveOfferDto(ExclusiveOffer exclusiveOffer);

    Set<String> discountedCategories(ExclusiveOffer exclusiveOffer) {
        return exclusiveOffer.getDiscountedCategories().stream()
                .map(Category::getCategoryName)
                .map(Enum::name)
                .collect(Collectors.toSet());
    }

}
