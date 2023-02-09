package com.example.gympower.service;

import com.example.gympower.model.dto.OrderDTO;
import com.example.gympower.model.entity.Address;
import com.example.gympower.model.entity.Order;
import com.example.gympower.model.entity.OrderedProduct;
import com.example.gympower.model.entity.UserEntity;
import com.example.gympower.model.mapper.AddressMapper;
import com.example.gympower.model.mapper.ProductMapper;
import com.example.gympower.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final WearService wearService;
    private final SupplementService suppService;
    private final ProductMapper productMapper;
    private final AddressMapper addressMapper;

    public OrderService(OrderRepository orderRepository,
                        UserService userService,
                        WearService wearService,
                        SupplementService suppService, ProductMapper productMapper, AddressMapper addressMapper) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.wearService = wearService;
        this.suppService = suppService;
        this.productMapper = productMapper;
        this.addressMapper = addressMapper;
    }

    public void createOrder(String email, OrderDTO orderDTO) {

        UserEntity user = this.userService.findByEmail(email);

        List<OrderedProduct> orderedProducts = orderDTO.getProductOrderDTOs().stream()
                .map(this.productMapper::productOrderDtoToOrderedProduct)
                .toList();

        double sum = orderedProducts.stream().map(OrderedProduct::getPrice).mapToDouble(Double::doubleValue).sum();

        Address address = this.addressMapper.addressDtoToAddress(orderDTO.getAddressDTO());

        Order newOrder = new Order()
                .setUser(user)
                .setOrderedProducts(orderedProducts)
                .setAddress(address)
                .setTotalCost(BigDecimal.valueOf(sum));
    }
}
