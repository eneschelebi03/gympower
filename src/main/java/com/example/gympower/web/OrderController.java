package com.example.gympower.web;

import com.example.gympower.model.dto.display.DisplayAddressDTO;
import com.example.gympower.model.dto.display.DisplayOrderDetailsDTO;
import com.example.gympower.model.dto.display.DisplayOrderedProductDTO;
import com.example.gympower.model.dto.logic.OrderDTO;
import com.example.gympower.model.entity.Order;
import com.example.gympower.service.AddressService;
import com.example.gympower.service.OrderService;
import com.example.gympower.service.OrderedProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class OrderController {

    private final OrderService orderService;
    private final OrderedProductService orderedProductService;
    private final AddressService addressService;

    public OrderController(OrderService orderService, OrderedProductService orderedProductService, AddressService addressService) {
        this.orderService = orderService;
        this.orderedProductService = orderedProductService;
        this.addressService = addressService;
    }

    @PostMapping("/order/new")
    public ResponseEntity<String> newOrder(@RequestParam String email,
                                           @RequestBody OrderDTO orderDTO) {

        this.orderService.createOrder(email, orderDTO);

        return ResponseEntity.ok("Order is successful!");
    }

    @GetMapping("/order/current/products")
    public ResponseEntity<DisplayOrderDetailsDTO> getCurrentOrder(@RequestParam String email) {

        Order currentOrder = this.orderService.findCurrentOrder(email);
        List<DisplayOrderedProductDTO> ordersProducts = this.orderedProductService.getOrdersProducts(currentOrder);

        DisplayAddressDTO ordersAddress = this.addressService.findOrdersAddress(currentOrder);

        DisplayOrderDetailsDTO dto = new DisplayOrderDetailsDTO()
                .setOrderItems(ordersProducts)
                .setAddress(ordersAddress);

        return ResponseEntity.ok(dto);
    }
}
