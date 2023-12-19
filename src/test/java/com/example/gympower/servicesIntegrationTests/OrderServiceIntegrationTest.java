package com.example.gympower.servicesIntegrationTests;

import com.example.gympower.model.dto.display.admin.DisplayAdminOrderDTO;
import com.example.gympower.model.dto.display.admin.DisplayAnalyticsDTO;
import com.example.gympower.model.dto.logic.AddressDTO;
import com.example.gympower.model.dto.logic.OrderDTO;
import com.example.gympower.model.dto.logic.ProductOrderDTO;
import com.example.gympower.model.entity.*;
import com.example.gympower.model.entity.products.wear.Wear;
import com.example.gympower.model.mapper.AddressMapper;
import com.example.gympower.model.mapper.OrderMapper;
import com.example.gympower.model.mapper.ProductMapper;
import com.example.gympower.repository.OrderRepository;
import com.example.gympower.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrderServiceIntegrationTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserService userService;

    @Mock
    private WearService wearService;

    @Mock
    private AddressMapper addressMapper;

    @Mock
    private CartItemService cartItemService;

    @Mock
    private OrderedProductService orderedProductService;

    @Mock
    private ProductMapper productMapper;

    @Mock
    private AddressService addressService;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testCreateOrder() {
        String userEmail = "user@example.com";
        OrderDTO orderDTO = new OrderDTO();
        AddressDTO addressDTO = new AddressDTO();

        orderDTO.setItems(List.of(new ProductOrderDTO().setId(1L)));
        orderDTO.setDetails(addressDTO);

        UserEntity user = new UserEntity();
        user.setEmail(userEmail);

        CartItem cartItem = new CartItem();
        cartItem.setId(1L);
        cartItem.setWear(new Wear());
        cartItem.setQuantity(2);
        cartItem.setColor("Blue");
        cartItem.setSize("XS");

        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem);
        user.setCartItems(cartItems);

        Address address = new Address();
        when(addressService.save(any(Address.class))).thenReturn(address);

        when(addressMapper.addressDtoToAddress(any(AddressDTO.class))).thenReturn(address);

        Order order = new Order();
        List<Order> orders = new ArrayList<>();
        orders.add(order);

        user.setOrders(orders);

        when(orderRepository.save(any(Order.class))).thenReturn(order);

        when(userService.findByEmail(userEmail)).thenReturn(user);

        when(productMapper.cartItemToOrderedProduct(any(CartItem.class))).thenReturn(new OrderedProduct());

        when(orderedProductService.save(any(OrderedProduct.class))).thenReturn(new OrderedProduct());

        doNothing().when(wearService).reduceQuantity(any(Wear.class), any(String.class), any(String.class), anyInt());

        when(orderMapper.orderToRecentOrderDTO(any(Order.class))).thenReturn(new DisplayAdminOrderDTO());

        orderService.createOrder(userEmail, orderDTO);

        verify(addressService, times(1)).save(any(Address.class));
        verify(orderRepository, times(1)).save(any(Order.class));
        verify(wearService, times(1)).reduceQuantity(any(Wear.class), any(String.class), any(String.class), anyInt());
        verify(userService, times(1)).save(any(UserEntity.class));
    }

    @Test
    public void testFindCurrentOrder() {
        String userEmail = "user@example.com";

        UserEntity user = new UserEntity();
        user.setEmail(userEmail);
        Order order = new Order();
        user.setOrders(Collections.singletonList(order));

        when(userService.findByEmail(userEmail)).thenReturn(user);

        Order resultOrder = orderService.findCurrentOrder(userEmail);

        verify(userService, times(1)).findByEmail(userEmail);

        assertEquals(order, resultOrder);
    }

    @Test
    public void testGetRecentFinances() {
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        Order recentOrder = new Order();
        recentOrder.setTotalIncome(BigDecimal.valueOf(100.0));
        recentOrder.setTotalCost(BigDecimal.valueOf(50.0));
        List<Order> recentOrders = Collections.singletonList(recentOrder);

        when(orderRepository.findByCreatedAtAfter(yesterday)).thenReturn(recentOrders);

        DisplayAnalyticsDTO result = orderService.getRecentFinances();

        verify(orderRepository, times(1)).findByCreatedAtAfter(yesterday);

        assertEquals(BigDecimal.valueOf(100.0), result.getTotalSales());
        assertEquals(BigDecimal.valueOf(50.0), result.getCosts());
        assertEquals(BigDecimal.valueOf(50.0), result.getProfit());
        assertEquals(1, result.getOrdersNumber());
    }

    @Test
    public void testGetRecentOrders() {
        Order recentOrder = new Order();
        when(orderRepository.findFirst7ByOrderByCreatedAtDesc(any())).thenReturn(Collections.singletonList(recentOrder));

        List<DisplayAdminOrderDTO> result = orderService.getRecentOrders();

        verify(orderRepository, times(1)).findFirst7ByOrderByCreatedAtDesc(any());

        assertEquals(1, result.size());
    }

    @Test
    public void testGetAllOrders() {
        Order order = new Order();
        when(orderRepository.findAll()).thenReturn(Collections.singletonList(order));

        List<DisplayAdminOrderDTO> result = orderService.getALlOrders();

        verify(orderRepository, times(1)).findAll();

        assertEquals(1, result.size());
    }
}
