package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.display.admin.DisplayAdminOrderDTO;
import com.example.gympower.model.dto.display.admin.DisplayAdminOrderedProductDTO;
import com.example.gympower.model.entity.Order;
import com.example.gympower.model.entity.OrderedProduct;
import com.example.gympower.model.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-30T23:40:17+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public DisplayAdminOrderDTO orderToRecentOrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        DisplayAdminOrderDTO displayAdminOrderDTO = new DisplayAdminOrderDTO();

        displayAdminOrderDTO.setOrderItems( orderedProductListToDisplayAdminOrderedProductDTOList( order.getOrderedProducts() ) );
        displayAdminOrderDTO.setOrderedAt( order.getCreatedAt() );
        displayAdminOrderDTO.setOrderId( order.getId() );
        displayAdminOrderDTO.setUserId( orderUserId( order ) );

        return displayAdminOrderDTO;
    }

    protected DisplayAdminOrderedProductDTO orderedProductToDisplayAdminOrderedProductDTO(OrderedProduct orderedProduct) {
        if ( orderedProduct == null ) {
            return null;
        }

        DisplayAdminOrderedProductDTO displayAdminOrderedProductDTO = new DisplayAdminOrderedProductDTO();

        displayAdminOrderedProductDTO.setPictureUrl( orderedProduct.getPictureUrl() );
        displayAdminOrderedProductDTO.setName( orderedProduct.getName() );
        displayAdminOrderedProductDTO.setType( orderedProduct.getType() );
        displayAdminOrderedProductDTO.setSizeOrQuantity( orderedProduct.getSizeOrQuantity() );
        displayAdminOrderedProductDTO.setColorOrFlavor( orderedProduct.getColorOrFlavor() );
        displayAdminOrderedProductDTO.setPrice( orderedProduct.getPrice() );
        displayAdminOrderedProductDTO.setCost( orderedProduct.getCost() );
        displayAdminOrderedProductDTO.setCount( orderedProduct.getCount() );

        return displayAdminOrderedProductDTO;
    }

    protected List<DisplayAdminOrderedProductDTO> orderedProductListToDisplayAdminOrderedProductDTOList(List<OrderedProduct> list) {
        if ( list == null ) {
            return null;
        }

        List<DisplayAdminOrderedProductDTO> list1 = new ArrayList<DisplayAdminOrderedProductDTO>( list.size() );
        for ( OrderedProduct orderedProduct : list ) {
            list1.add( orderedProductToDisplayAdminOrderedProductDTO( orderedProduct ) );
        }

        return list1;
    }

    private long orderUserId(Order order) {
        if ( order == null ) {
            return 0L;
        }
        UserEntity user = order.getUser();
        if ( user == null ) {
            return 0L;
        }
        long id = user.getId();
        return id;
    }
}
