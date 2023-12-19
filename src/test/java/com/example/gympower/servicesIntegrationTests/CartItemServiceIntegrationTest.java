package com.example.gympower.servicesIntegrationTests;

import com.example.gympower.model.entity.CartItem;
import com.example.gympower.model.entity.products.wear.Color;
import com.example.gympower.model.entity.products.wear.Size;
import com.example.gympower.model.entity.products.wear.Wear;
import com.example.gympower.repository.CartItemRepository;
import com.example.gympower.service.CartItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CartItemServiceIntegrationTest {

    @Mock
    private CartItemRepository cartItemRepository;

    @InjectMocks
    private CartItemService cartItemService;

    @Test
    public void testAddCartItem() {
        // Arrange
        CartItem cartItemToAdd = createSampleCartItem();
        CartItem savedCartItem = createSampleCartItem();
        savedCartItem.setId(1L);

        when(cartItemRepository.save(cartItemToAdd)).thenReturn(savedCartItem);

        // Act
        CartItem result = cartItemService.add(cartItemToAdd);

        // Assert
        assertEquals(savedCartItem.getId(), result.getId());

        // Verify that the repository method was called
        Mockito.verify(cartItemRepository, Mockito.times(1)).save(cartItemToAdd);
    }

    @Test
    public void testFindCartItemById() {
        // Arrange
        long cartItemId = 1L;
        CartItem expectedCartItem = createSampleCartItem();
        expectedCartItem.setId(cartItemId);

        when(cartItemRepository.findById(cartItemId)).thenReturn(Optional.of(expectedCartItem));

        // Act
        CartItem result = cartItemService.findById(cartItemId);

        // Assert
        assertEquals(expectedCartItem, result);

        // Verify that the repository method was called
        Mockito.verify(cartItemRepository, Mockito.times(1)).findById(cartItemId);
    }

    @Test
    public void testRemoveCartItem() {
        // Arrange
        CartItem cartItemToRemove = createSampleCartItem();

        // Act
        cartItemService.remove(cartItemToRemove);

        // Verify that the repository method was called
        Mockito.verify(cartItemRepository, Mockito.times(1)).delete(cartItemToRemove);
    }

    private CartItem createSampleCartItem() {
        Wear wear = new Wear();
        wear.setId(1L);
        wear.setName("Sample Wear");
        wear.setAvailableColors(createSampleColors());
        wear.setFabric("Sample Fabric");


        return new CartItem()
                .setWear(wear)
                .setQuantity(2);
    }

    private Set<Color> createSampleColors() {
        Color color = new Color()
                .setId(1L)
                .setColorName("Sample Color")
                .setColorCode("SAMPLE_COLOR_CODE")
                .setCost(new BigDecimal("10.00"))
                .setPrice(new BigDecimal("20.00"))
                .setDiscount(10)
                .setSizes(createSampleSize())
                .setAvailable(true);

        Set<Color> colors = new HashSet<>();
        colors.add(color);

        return colors;
    }

    private Set<Size> createSampleSize() {
        // Create a sample Size entity

        Set<Size> sizes = new HashSet<>();

        Size size = new Size()
                .setId(1L)
                .setName("Sample Size")
                .setItemsProduced(100)
                .setActive(true);

        sizes.add(size);

        return sizes;

    }
}

