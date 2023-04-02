package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.display.AllProductsProductDTO;
import com.example.gympower.model.dto.display.CarouselProductDTO;
import com.example.gympower.model.dto.display.DisplayCartItemDTO;
import com.example.gympower.model.dto.display.DisplayOrderedProductDTO;
import com.example.gympower.model.dto.display.WearDetailsDTO;
import com.example.gympower.model.dto.display.admin.DisplayAdminProductDTO;
import com.example.gympower.model.entity.CartItem;
import com.example.gympower.model.entity.OrderedProduct;
import com.example.gympower.model.entity.products.supplements.Supplement;
import com.example.gympower.model.entity.products.wear.Color;
import com.example.gympower.model.entity.products.wear.Wear;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-01T19:44:17+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl extends ProductMapper {

    @Override
    public DisplayOrderedProductDTO orderedProductToDisplayDTO(OrderedProduct orderedProduct) {
        if ( orderedProduct == null ) {
            return null;
        }

        DisplayOrderedProductDTO displayOrderedProductDTO = new DisplayOrderedProductDTO();

        displayOrderedProductDTO.setName( orderedProduct.getName() );
        displayOrderedProductDTO.setPictureUrl( orderedProduct.getPictureUrl() );
        displayOrderedProductDTO.setSizeOrQuantity( orderedProduct.getSizeOrQuantity() );
        displayOrderedProductDTO.setColorOrFlavor( orderedProduct.getColorOrFlavor() );
        displayOrderedProductDTO.setPrice( orderedProduct.getPrice() );
        displayOrderedProductDTO.setCount( orderedProduct.getCount() );

        return displayOrderedProductDTO;
    }

    @Override
    public OrderedProduct cartItemToOrderedProduct(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        OrderedProduct orderedProduct = new OrderedProduct();

        orderedProduct.setType( orderedProductType( cartItem ) );
        orderedProduct.setName( orderedProductName( cartItem ) );
        orderedProduct.setPrice( orderedProductPrice( cartItem ) );
        orderedProduct.setCost( orderedProductCost( cartItem ) );
        orderedProduct.setPictureUrl( wearCartPicture( cartItem ) );
        orderedProduct.setSizeOrQuantity( cartItem.getSize() );
        orderedProduct.setColorOrFlavor( cartItem.getColor() );
        orderedProduct.setCount( cartItem.getQuantity() );
        orderedProduct.setId( cartItem.getId() );

        return orderedProduct;
    }

    @Override
    public AllProductsProductDTO supplementToAllProductsSuppDTO(Supplement supplement) {
        if ( supplement == null ) {
            return null;
        }

        AllProductsProductDTO allProductsProductDTO = new AllProductsProductDTO();

        allProductsProductDTO.setPrice( suppPrice( supplement ) );
        allProductsProductDTO.setPictureUrl( suppPictureUrl( supplement ) );
        allProductsProductDTO.setId( supplement.getId() );
        allProductsProductDTO.setName( supplement.getName() );
        if ( supplement.getRating() != null ) {
            allProductsProductDTO.setRating( supplement.getRating() );
        }
        allProductsProductDTO.setDescription( supplement.getDescription() );

        return allProductsProductDTO;
    }

    @Override
    public CarouselProductDTO supplementToDisplayProductDTO(Supplement supplement) {
        if ( supplement == null ) {
            return null;
        }

        CarouselProductDTO carouselProductDTO = new CarouselProductDTO();

        carouselProductDTO.setPrice( suppPrice( supplement ) );
        carouselProductDTO.setPictureUrl( suppPictureUrl( supplement ) );
        carouselProductDTO.setId( supplement.getId() );
        carouselProductDTO.setName( supplement.getName() );
        if ( supplement.getRating() != null ) {
            carouselProductDTO.setRating( supplement.getRating() );
        }

        return carouselProductDTO;
    }

    @Override
    public DisplayAdminProductDTO wearToAdminProductDTO(Wear wear) {
        if ( wear == null ) {
            return null;
        }

        DisplayAdminProductDTO displayAdminProductDTO = new DisplayAdminProductDTO();

        displayAdminProductDTO.setPictureUrl( wearPictureUrl( wear ) );
        displayAdminProductDTO.setCategories( wearCategories( wear ) );
        displayAdminProductDTO.setOptions( wearColors( wear ) );
        displayAdminProductDTO.setPrice( wearCartPrices( wear ) );
        displayAdminProductDTO.setCost( wearCartCosts( wear ) );
        displayAdminProductDTO.setAddedOn( wear.getAdded() );
        displayAdminProductDTO.setName( wear.getName() );
        if ( wear.getRating() != null ) {
            displayAdminProductDTO.setRating( wear.getRating() );
        }

        return displayAdminProductDTO;
    }

    @Override
    public AllProductsProductDTO wearToAllProductsProductDTO(Wear wear) {
        if ( wear == null ) {
            return null;
        }

        AllProductsProductDTO allProductsProductDTO = new AllProductsProductDTO();

        allProductsProductDTO.setPrice( wearPrice( wear ) );
        allProductsProductDTO.setPictureUrl( wearPictureUrl( wear ) );
        allProductsProductDTO.setId( wear.getId() );
        allProductsProductDTO.setName( wear.getName() );
        if ( wear.getRating() != null ) {
            allProductsProductDTO.setRating( wear.getRating() );
        }
        allProductsProductDTO.setDescription( wear.getDescription() );

        return allProductsProductDTO;
    }

    @Override
    public CarouselProductDTO wearToTopProductDTO(Wear wear) {
        if ( wear == null ) {
            return null;
        }

        CarouselProductDTO carouselProductDTO = new CarouselProductDTO();

        carouselProductDTO.setPrice( wearPrice( wear ) );
        carouselProductDTO.setPictureUrl( wearPictureUrl( wear ) );
        carouselProductDTO.setId( wear.getId() );
        carouselProductDTO.setName( wear.getName() );
        if ( wear.getRating() != null ) {
            carouselProductDTO.setRating( wear.getRating() );
        }

        return carouselProductDTO;
    }

    @Override
    public WearDetailsDTO wearToWearDetailsDTO(Wear wear) {
        if ( wear == null ) {
            return null;
        }

        WearDetailsDTO wearDetailsDTO = new WearDetailsDTO();

        Set<Color> set = wear.getAvailableColors();
        if ( set != null ) {
            wearDetailsDTO.setColors( new LinkedHashSet<Color>( set ) );
        }
        wearDetailsDTO.setCategories( wearCategories( wear ) );
        wearDetailsDTO.setId( wear.getId() );
        wearDetailsDTO.setName( wear.getName() );
        wearDetailsDTO.setDescription( wear.getDescription() );

        return wearDetailsDTO;
    }

    @Override
    public DisplayCartItemDTO cartItemToCartDTO(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        DisplayCartItemDTO displayCartItemDTO = new DisplayCartItemDTO();

        displayCartItemDTO.setPrice( wearCartPrice( cartItem ) );
        displayCartItemDTO.setPictureUrl( wearCartPicture( cartItem ) );
        displayCartItemDTO.setName( wearCartName( cartItem ) );
        displayCartItemDTO.setColorCode( wearCartColorCode( cartItem ) );
        displayCartItemDTO.setId( cartItem.getId() );
        displayCartItemDTO.setColor( cartItem.getColor() );
        displayCartItemDTO.setSize( cartItem.getSize() );
        displayCartItemDTO.setQuantity( cartItem.getQuantity() );

        return displayCartItemDTO;
    }
}
