package com.example.gympower.interceptor;

import com.example.gympower.model.dto.logic.LogProductOrderDto;
import com.example.gympower.model.entity.Order;
import com.example.gympower.model.mapper.ProductMapper;
import com.example.gympower.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

public class TransactionProcessingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LogManager.getLogger(TransactionProcessingInterceptor.class);
    private final OrderService orderService;
    private final ProductMapper productMapper;

    public TransactionProcessingInterceptor(OrderService orderService, ProductMapper productMapper) {
        this.orderService = orderService;
        this.productMapper = productMapper;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String email = request.getParameter("email");
        Order currentOrder = this.orderService.findCurrentOrder(email);
        double totalPrice = currentOrder.getTotalIncome().doubleValue();
        List<LogProductOrderDto> list = currentOrder.getOrderedProducts().stream()
                .map(productMapper::orderedProductToLogProductDTO)
                .toList();

        // Log transaction details
        logger.info("User email: {}", email);
        logger.info("Products purchased: {}", list.stream()
                .map(LogProductOrderDto::toString)
                .toList());
        logger.info("Total cost: {}", totalPrice);
        logger.info("Status code: {}", response.getStatus());
        logger.info("Transaction timestamp: {}", System.currentTimeMillis());

    }
}
