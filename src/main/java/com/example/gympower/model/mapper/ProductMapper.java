package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.display.*;
import com.example.gympower.model.dto.display.admin.DisplayAdminProductDTO;
import com.example.gympower.model.dto.logic.LogProductOrderDto;
import com.example.gympower.model.entity.CartItem;
import com.example.gympower.model.entity.Category;
import com.example.gympower.model.entity.OrderedProduct;
import com.example.gympower.model.entity.enums.ProductCategoriesEnum;
import com.example.gympower.model.entity.products.supplements.Cut;
import com.example.gympower.model.entity.products.supplements.Supplement;
import com.example.gympower.model.entity.products.wear.Color;
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


    @Mapping(target = "price", source = "orderedProduct", qualifiedByName = "displayOrderedProdPrice")
    public abstract DisplayOrderedProductDTO orderedProductToDisplayDTO(OrderedProduct orderedProduct);
    public abstract LogProductOrderDto orderedProductToLogProductDTO(OrderedProduct orderedProduct);

    @Mapping(target = "type", source = "cartItem", qualifiedByName = "orderedProductType")
    @Mapping(target = "name", source = "cartItem", qualifiedByName = "orderedProductName")
    @Mapping(target = "price", source = "cartItem", qualifiedByName = "orderedProductPrice")
    @Mapping(target = "discount", source = "cartItem", qualifiedByName = "orderedProductDiscount")
    @Mapping(target = "cost", source = "cartItem", qualifiedByName = "orderedProductCost")
    @Mapping(target = "pictureUrl", source = "cartItem", qualifiedByName = "wearCartPicture")
    @Mapping(target = "sizeOrQuantity", source = "size")
    @Mapping(target = "colorOrFlavor", source = "color")
    @Mapping(target = "count", source = "quantity")
    public abstract OrderedProduct cartItemToOrderedProduct(CartItem cartItem);

    @Mapping(target = "price", source = "supplement", qualifiedByName = "suppPrice")
    @Mapping(target = "pictureUrl", source = "supplement", qualifiedByName = "suppPictureUrl")
    public abstract AllProductsProductDTO supplementToAllProductsSuppDTO(Supplement supplement);

    @Mapping(target = "price", source = "supplement", qualifiedByName = "suppPrice")
    @Mapping(target = "pictureUrl", source = "supplement", qualifiedByName = "suppPictureUrl")
    public abstract CarouselProductDTO supplementToDisplayProductDTO(Supplement supplement);

    @Named("displayOrderedProdPrice")
    double displayOrderedProdPrice(OrderedProduct orderedProduct) {
        double price = orderedProduct.getPrice();
        int discount = orderedProduct.getDiscount();

        if (discount != 0) {
            price -= price * discount / 100;
        }

        return price;
    }


    @Named("orderedProductCost")
    double orderedProductCost(CartItem cartItem) {
        BigDecimal cost = cartItem.getWear().getAvailableColors().stream()
                .filter(c -> c.getColorName().equals(cartItem.getColor()))
                .findFirst()
                .get()
                .getCost();

        return cost.doubleValue();
    }

    @Named("orderedProductPrice")
    double orderedProductPrice(CartItem cartItem) {
        BigDecimal price = cartItem.getWear().getAvailableColors().stream()
                .filter(c -> c.getColorName().equals(cartItem.getColor()))
                .findFirst()
                .get()
                .getPrice();

        return price.doubleValue();
    }

    @Named("orderedProductDiscount")
    int orderedProductDiscount(CartItem cartItem) {
        return cartItem.getWear().getAvailableColors().stream()
                .filter(c -> c.getColorName().equals(cartItem.getColor()))
                .findFirst()
                .get()
                .getDiscount();
    }

    @Named("orderedProductType")
    String orderedProductType(CartItem cartItem) {
        if (cartItem.getWear().getCategories().stream()
                .map(c -> c.getCategoryName().name())
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


    @Mapping(target = "pictureUrl", source = "wear", qualifiedByName = "wearPicture")
    @Mapping(target = "categories", source = "wear", qualifiedByName = "wearCategories")
    @Mapping(target = "options", source = "wear", qualifiedByName = "wearColors")
    @Mapping(target = "price", source = "wear", qualifiedByName = "wearPrices")
    @Mapping(target = "cost", source = "wear", qualifiedByName = "wearCosts")
    @Mapping(target = "addedOn", source = "added")
    public abstract DisplayAdminProductDTO wearToAdminProductDTO(Wear wear);

    @Mapping(target = "price", source = "wear", qualifiedByName = "wearPrice")
    @Mapping(target = "discount", source = "wear", qualifiedByName = "wearDiscount")
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
        Color color = cartItem.getWear().getAvailableColors().stream()
                .filter(c -> c.getColorName().equals(cartItem.getColor()))
                .findFirst().get();

        double actualPrice = color.getPrice().doubleValue();

        double discount = color.getDiscount();
        if (discount != 0) {
            actualPrice -= actualPrice * discount / 100;
        }

        return actualPrice;
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
    @Named("wearDiscount")
    int wearDiscount(Wear wear) {
        return wear.getAvailableColors().stream()
                .findFirst()
                .get()
                .getDiscount();
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
                .map(Category::getCategoryName)
                .map(ProductCategoriesEnum::name)
                .collect(Collectors.toSet());
    }


    @Named("wearColors")
    List<String> wearColors(Wear wear) {
        return wear.getAvailableColors().stream()
                .map(Color::getColorName)
                .toList();
    }


    @Named("wearPrices")
    String wearCartPrices(Wear wear) {
        double min = wear.getAvailableColors().stream()
                .map(Color::getPrice)
                .map(BigDecimal::doubleValue)
                .mapToDouble(Double::doubleValue)
                .min().getAsDouble();

        double max = wear.getAvailableColors().stream()
                .map(Color::getPrice)
                .map(BigDecimal::doubleValue)
                .mapToDouble(Double::doubleValue)
                .max().getAsDouble();

        return min + " - " + max;
    }

    @Named("wearCosts")
    String wearCartCosts(Wear wear) {
        double min = wear.getAvailableColors().stream()
                .map(Color::getCost)
                .map(BigDecimal::doubleValue)
                .mapToDouble(Double::doubleValue)
                .min().getAsDouble();

        double max = wear.getAvailableColors().stream()
                .map(Color::getCost)
                .map(BigDecimal::doubleValue)
                .mapToDouble(Double::doubleValue)
                .max().getAsDouble();

        return min + " - " + max;
    }

}
