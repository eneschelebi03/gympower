package com.example.gympower.web;

import com.example.gympower.model.dto.AddressDTO;
import com.example.gympower.model.dto.OrderDTO;
import com.example.gympower.model.dto.ProductOrderDTO;
import com.example.gympower.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/new")
    public ResponseEntity<String> newOrder(@RequestParam String email,
                                           @RequestBody OrderDTO orderDTO) {

        this.orderService.createOrder(email, orderDTO);

        return ResponseEntity.ok("Order is successful!");
    }
}
