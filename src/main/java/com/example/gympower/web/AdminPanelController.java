package com.example.gympower.web;

import com.example.gympower.model.dto.display.DisplayFinancesDTO;
import com.example.gympower.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class AdminPanelController {

    private final OrderService orderService;

    public AdminPanelController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/admin-panel/finances")
    public ResponseEntity<DisplayFinancesDTO> getFinancialInfo() {

        DisplayFinancesDTO finances = this.orderService.getRecentFinances();

        return ResponseEntity.ok(finances);
    }
}
