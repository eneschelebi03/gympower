package com.example.gympower.web;

import com.example.gympower.model.dto.display.DisplayFinancesDTO;
import com.example.gympower.model.dto.display.DisplayOrderedProductDTO;
import com.example.gympower.model.dto.display.DisplayRecentOrderDTO;
import com.example.gympower.service.OrderService;
import com.example.gympower.service.OrderedProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AdminPanelController {

    private final OrderService orderService;

    public AdminPanelController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/admin-panel/recent/finances")
    public ResponseEntity<DisplayFinancesDTO> getFinancialInfo() {

        DisplayFinancesDTO finances = this.orderService.getRecentFinances();

        return ResponseEntity.ok(finances);
    }

    @GetMapping("/admin-panel/recent/orders")
    public ResponseEntity<List<DisplayRecentOrderDTO>> getRecentOrders() {

         List<DisplayRecentOrderDTO> recentOrders = this.orderService.getRecentOrders();

        return ResponseEntity.ok(recentOrders);
    }
}
