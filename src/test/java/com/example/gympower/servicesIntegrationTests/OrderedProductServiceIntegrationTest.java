package com.example.gympower.servicesIntegrationTests;

import com.example.gympower.model.dto.display.DisplayOrderedProductDTO;
import com.example.gympower.model.entity.Order;
import com.example.gympower.model.entity.OrderedProduct;
import com.example.gympower.model.mapper.ProductMapper;
import com.example.gympower.repository.OrderedProductRepository;
import com.example.gympower.service.OrderedProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrderedProductServiceIntegrationTest {

    @Mock
    private OrderedProductRepository orderedProductRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private OrderedProductService orderedProductService;

    @Test
    public void testSave() {
        // Arrange
        OrderedProduct orderedProduct = new OrderedProduct();
        when(orderedProductRepository.save(orderedProduct)).thenReturn(orderedProduct);

        // Act
        OrderedProduct result = orderedProductService.save(orderedProduct);

        // Assert
        assertEquals(orderedProduct, result);

        // Verify that the repository method was called
        Mockito.verify(orderedProductRepository, Mockito.times(1)).save(orderedProduct);
    }

    @Test
    public void testGetOrdersProducts() {
        // Arrange
        Order order = new Order();
        OrderedProduct orderedProduct1 = new OrderedProduct();
        OrderedProduct orderedProduct2 = new OrderedProduct();

        DisplayOrderedProductDTO displayOrderedProductDTO1 = new DisplayOrderedProductDTO();
        DisplayOrderedProductDTO displayOrderedProductDTO2 = new DisplayOrderedProductDTO();

        when(productMapper.orderedProductToDisplayDTO(orderedProduct1)).thenReturn(displayOrderedProductDTO1);
        when(productMapper.orderedProductToDisplayDTO(orderedProduct2)).thenReturn(displayOrderedProductDTO2);

        order.setOrderedProducts(Arrays.asList(orderedProduct1, orderedProduct2));

        // Act
        List<DisplayOrderedProductDTO> result = orderedProductService.getOrdersProducts(order);

        // Assert
        assertEquals(2, result.size());
        assertEquals(displayOrderedProductDTO1, result.get(0));
        assertEquals(displayOrderedProductDTO2, result.get(1));

        // Verify that the mapper method was called
        Mockito.verify(productMapper, Mockito.times(1)).orderedProductToDisplayDTO(orderedProduct1);
        Mockito.verify(productMapper, Mockito.times(1)).orderedProductToDisplayDTO(orderedProduct2);
    }

    @Test
    public void testGetOrdersProductsEmptyList() {
        // Arrange
        Order order = new Order();
        order.setOrderedProducts(List.of());

        // Act
        List<DisplayOrderedProductDTO> result = orderedProductService.getOrdersProducts(order);

        // Assert
        assertEquals(0, result.size());

        // Verify that the mapper method was not called
        Mockito.verify(productMapper, Mockito.never()).orderedProductToDisplayDTO(Mockito.any());
    }
}
