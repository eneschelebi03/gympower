package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.*;
import com.example.gympower.model.entity.CartItem;
import com.example.gympower.model.entity.Category;
import com.example.gympower.model.entity.OrderedProduct;
import com.example.gympower.model.entity.enums.ProductCategoriesEnum;
import com.example.gympower.model.entity.products.supplements.Cut;
import com.example.gympower.model.entity.products.supplements.Supplement;
import com.example.gympower.model.entity.products.wear.Wear;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {


    @Mapping(target = "type", source = "cartItem", qualifiedByName = "orderedProductType")
    @Mapping(target = "name", source = "cartItem", qualifiedByName = "orderedProductName")
    @Mapping(target = "price", source = "cartItem", qualifiedByName = "orderedProductPrice")
    @Mapping(target = "sizeOrQuantity", source = "size")
    @Mapping(target = "colorOrFlavor", source = "color")
    public abstract OrderedProduct cartItemToOrderedProduct(CartItem cartItem);

    @Mapping(target = "price", source = "supplement", qualifiedByName = "suppPrice")
    @Mapping(target = "pictureUrl", source = "supplement", qualifiedByName = "suppPictureUrl")
    public abstract AllProductsProductDTO supplementToAllProductsSuppDTO(Supplement supplement);

    @Mapping(target = "price", source = "supplement", qualifiedByName = "suppPrice")
    @Mapping(target = "pictureUrl", source = "supplement", qualifiedByName = "suppPictureUrl")
    public abstract CarouselProductDTO supplementToDisplayProductDTO(Supplement supplement);

    @Named("orderedProductPrice")
    double orderedProductPrice(CartItem cartItem) {
        BigDecimal price = cartItem.getWear().getAvailableColors().stream()
                .filter(c -> c.getColorName().equals(cartItem.getColor()))
                .findFirst()
                .get()
                .getPrice();

        return price.doubleValue();
    }

    @Named("orderedProductType")
    String orderedProductType(CartItem cartItem) {
        if (cartItem.getWear().getCategories().stream()
                .map(c -> c.getCategory().name())
                .toList()
                .contains("WEAR")
        ) {
            return "WEAR";
        } else {
            return "SUPPLEMENT";
        }
    }

    @Named("orderedProductName")
    String orderedProductName(CartItem cartItem) {
        return cartItem.getWear().getName();
    }


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



    @Mapping(target = "colors", source = "availableColors")
    @Mapping(target = "categories", source = "wear", qualifiedByName = "wearCategories")
    public abstract WearDetailsDTO wearToWearDetailsDTO(Wear wear);


    @Mapping(target = "price", source = "cartItem", qualifiedByName = "wearCartPrice")
    @Mapping(target = "pictureUrl", source = "cartItem", qualifiedByName = "wearCartPicture")
    @Mapping(target = "name", source = "cartItem", qualifiedByName = "wearCartName")
    @Mapping(target = "colorCode", source = "cartItem", qualifiedByName = "wearCartColorCode")
    public abstract DisplayCartItemDTO cartItemToCartDTO(CartItem cartItem);

    @Named("wearCartName")
    String wearCartName(CartItem cartItem) {
        return cartItem.getWear().getName();
    }

    @Named("wearCartPrice")
    double wearCartPrice(CartItem cartItem) {
        return cartItem.getWear().getAvailableColors().stream()
                .filter(c -> c.getColorName().equals(cartItem.getColor()))
                .findFirst().get()
                .getPrice().doubleValue();
    }

    @Named("wearCartColorCode")
    String wearCartColorCode(CartItem cartItem) {
        return cartItem.getWear().getAvailableColors().stream()
                .filter(c -> c.getColorName().equals(cartItem.getColor()))
                .findFirst().get()
                .getColorCode();
    }

    @Named("wearCartPicture")
    String wearCartPicture(CartItem cartItem) {
        return cartItem.getWear().getAvailableColors().stream()
                .filter(c -> c.getColorName().equals(cartItem.getColor()))
                .findFirst().get()
                .getPictures().stream()
                .findFirst().get()
                .getUrl();
    }

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

    @Named("wearCategories")
    Set<String> wearCategories(Wear wear) {
        return wear.getCategories().stream()
                .map(Category::getCategory)
                .map(ProductCategoriesEnum::name)
                .collect(Collectors.toSet());
    }

}
