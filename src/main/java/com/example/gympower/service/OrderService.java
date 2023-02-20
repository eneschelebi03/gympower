package com.example.gympower.service;

import com.example.gympower.model.dto.display.DisplayFinancesDTO;
import com.example.gympower.model.dto.logic.OrderDTO;
import com.example.gympower.model.dto.logic.ProductOrderDTO;
import com.example.gympower.model.entity.*;
import com.example.gympower.model.mapper.AddressMapper;
import com.example.gympower.model.mapper.ProductMapper;
import com.example.gympower.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final WearService wearService;
    private final SupplementService suppService;
    private final ProductMapper productMapper;
    private final AddressMapper addressMapper;
    private final CartItemService cartItemService;
    private final OrderedProductService orderedProductService;
    private final AddressService addressService;

    public OrderService(OrderRepository orderRepository,
                        UserService userService,
                        WearService wearService,
                        SupplementService suppService, ProductMapper productMapper, AddressMapper addressMapper, CartItemService cartItemService, OrderedProductService orderedProductService, AddressService addressService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.wearService = wearService;
        this.suppService = suppService;
        this.productMapper = productMapper;
        this.addressMapper = addressMapper;
        this.cartItemService = cartItemService;
        this.orderedProductService = orderedProductService;
        this.addressService = addressService;
    }

    public void createOrder(String email, OrderDTO orderDTO) {

        UserEntity user = this.userService.findByEmail(email);

        for (ProductOrderDTO productOrderDTO : orderDTO.getItems()) {
            CartItem cartItem = user.getCartItems()
                    .stream()
                    .filter(c -> c.getId() == productOrderDTO.getId())
                    .findFirst()
                    .get();

            cartItem.setQuantity(productOrderDTO.getQuantity());
            this.cartItemService.add(cartItem);
        }

        List<OrderedProduct> orderedProducts = user.getCartItems()
                .stream()
                .map(this.productMapper::cartItemToOrderedProduct)
                .toList();

        double sumCost = 0.00;
        double sumPrice = 0.00;
        double tax = 1.05;
        for (OrderedProduct orderedProduct : orderedProducts) {
            orderedProduct = this.orderedProductService.save(orderedProduct);

            double totalProductPrice = orderedProduct.getPrice() * orderedProduct.getCount();
            sumPrice += totalProductPrice;

            double totalProductCost = orderedProduct.getCost() * orderedProduct.getCount();
            sumCost += totalProductCost;

        }

        Address address = this.addressMapper.addressDtoToAddress(orderDTO.getDetails());
        address = this.addressService.save(address);

        if (orderDTO.getDetails().isSaveAsPersonal()) {
            user.setAddress(address);
        }

        Order newOrder = new Order()
                .setUser(user)
                .setOrderedProducts(orderedProducts)
                .setAddress(address)
                .setTotalIncome(BigDecimal.valueOf(sumPrice * tax))
                .setTotalCost(BigDecimal.valueOf(sumCost));

        this.orderRepository.save(newOrder);


        for (CartItem cartItem : user.getCartItems()) {
            this.wearService.reduceQuantity(cartItem.getWear(), cartItem.getColor(), cartItem.getSize(), cartItem.getQuantity());
        }

        user.getCartItems().clear();
        user.getOrders().add(newOrder);

        this.userService.save(user);
    }

    public Order findCurrentOrder(String email) {
        UserEntity byEmail = this.userService.findByEmail(email);
        List<Order> userOrders = byEmail.getOrders();
        userOrders.sort(Comparator.comparing(Order::getCreatedAt).reversed());

        return userOrders.stream().findFirst().get();
    }

    public DisplayFinancesDTO getRecentFinances() {
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        List<Order> recentOrders = this.orderRepository.findByCreatedAtAfter(yesterday);

        double incomeSum = 0.00;
        double costSum = 0.00;
        for (Order order : recentOrders) {
            incomeSum += order.getTotalIncome().doubleValue();
            costSum += order.getTotalCost().doubleValue();
        }

        double profit = incomeSum - costSum;

        DisplayFinancesDTO finances = new DisplayFinancesDTO()
                .setTotalSales(BigDecimal.valueOf(incomeSum))
                .setCosts(BigDecimal.valueOf(costSum))
                .setProfit(BigDecimal.valueOf(profit));

        return finances;
    }
}
