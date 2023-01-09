package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.AllProductsProductDTO;
import com.example.gympower.model.dto.CarouselProductDTO;
import com.example.gympower.model.dto.WearDetailsDTO;
import com.example.gympower.model.entity.Category;
import com.example.gympower.model.entity.enums.ProductCategoriesEnum;
import com.example.gympower.model.entity.products.supplements.Cut;
import com.example.gympower.model.entity.products.supplements.Supplement;
import com.example.gympower.model.entity.products.wear.Wear;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    @Mapping(target = "price", source = "supplement", qualifiedByName = "suppPrice")
    @Mapping(target = "pictureUrl", source = "supplement", qualifiedByName = "suppPictureUrl")
    public abstract AllProductsProductDTO supplementToAllProductsSuppDTO(Supplement supplement);

    @Mapping(target = "price", source = "supplement", qualifiedByName = "suppPrice")
    @Mapping(target = "pictureUrl", source = "supplement", qualifiedByName = "suppPictureUrl")
    public abstract CarouselProductDTO supplementToDisplayProductDTO(Supplement supplement);

    @Named("suppPrice")
    double suppPrice(Supplement supplement) {
        return supplement.getFlavors().stream()
                .findAny()
                .get()
                .getCuts()
                .stream().min(Comparator.comparing(Cut::getPrice))
                .get()
                .getPrice()
                .doubleValue();
    }

    @Named("suppPictureUrl")
    String suppPictureUrl(Supplement supplement) {
        return supplement.getFlavors().stream()
                .findAny()
                .get()
                .getPictures()
                .stream()
                .findFirst()
                .get()
                .getUrl();
    }

    @Mapping(target = "price", source = "wear", qualifiedByName = "wearPrice")
    @Mapping(target = "pictureUrl", source = "wear", qualifiedByName = "wearPicture")
    public abstract AllProductsProductDTO wearToAllProductsProductDTO(Wear wear);


    @Mapping(target = "price", source = "wear", qualifiedByName = "wearPrice")
    @Mapping(target = "pictureUrl", source = "wear", qualifiedByName = "wearPicture")
    public abstract CarouselProductDTO wearToTopProductDTO(Wear wear);

    @Named("wearPrice")
    double wearPrice(Wear wear) {
        return wear.getAvailableColors().stream()
                .findFirst()
                .get()
                .getPrice()
                .doubleValue();
    }

    @Named("wearPicture")
    String wearPictureUrl(Wear wear) {
        return wear.getAvailableColors().stream()
                .findFirst()
                .get()
                .getPictures().stream()
                .findFirst()
                .get()
                .getUrl();
    }

    @Mapping(target = "colors", source = "availableColors")
    @Mapping(target = "categories", source = "wear", qualifiedByName = "wearCategories")
    public abstract WearDetailsDTO wearToWearDetailsDTO(Wear wear);

    @Named("wearCategories")
    Set<String> wearCategories(Wear wear) {
        return wear.getCategories().stream()
                .map(Category::getCategory)
                .map(ProductCategoriesEnum::name)
                .collect(Collectors.toSet());
    }

}
