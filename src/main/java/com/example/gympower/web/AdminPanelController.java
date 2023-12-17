package com.example.gympower.web;

import com.example.gympower.model.dto.display.admin.DisplayAdminOrderDTO;
import com.example.gympower.model.dto.display.admin.DisplayAdminProductDTO;
import com.example.gympower.model.dto.display.admin.DisplayAnalyticsDTO;
import com.example.gympower.model.dto.display.admin.DisplayUserTableDTO;
import com.example.gympower.service.AnalyticsService;
import com.example.gympower.service.OrderService;
import com.example.gympower.service.ProductService;
import com.example.gympower.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AdminPanelController {

    private final OrderService orderService;
    private final UserService userService;
    private final ProductService productService;
    private final AnalyticsService analyticsService;

    public AdminPanelController(OrderService orderService, UserService userService, ProductService productService, AnalyticsService analyticsService) {
        this.orderService = orderService;
        this.userService = userService;
        this.productService = productService;
        this.analyticsService = analyticsService;
    }

    @GetMapping("/admin-panel/recent/finances")
    public ResponseEntity<DisplayAnalyticsDTO> getFinancialInfo() {

        DisplayAnalyticsDTO finances = this.analyticsService.getLatestAnalytics();

        return ResponseEntity.ok(finances);
    }

    @GetMapping("/admin-panel/recent/orders")
    public ResponseEntity<List<DisplayAdminOrderDTO>> getRecentOrders() {

         List<DisplayAdminOrderDTO> recentOrders = this.orderService.getRecentOrders();

        return ResponseEntity.ok(recentOrders);
    }

    @GetMapping("/admin-panel/all/customers")
    public ResponseEntity<List<DisplayUserTableDTO>> getAllUsers() {

        List<DisplayUserTableDTO> users = this.userService.getUsers();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/admin-panel/all/orders")
    public ResponseEntity<List<DisplayAdminOrderDTO>> getAllOrders() {

        List<DisplayAdminOrderDTO> recentOrders = this.orderService.getALlOrders();

        return ResponseEntity.ok(recentOrders);
    }

    @GetMapping("/admin-panel/all/products")
    public ResponseEntity<List<DisplayAdminProductDTO>> getAllProducts() {

        List<DisplayAdminProductDTO> products = this.productService.getAllProducts();

        return ResponseEntity.ok(products);
    }
}
