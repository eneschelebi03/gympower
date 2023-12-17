package com.example.gympower.config;

import com.example.gympower.interceptor.RequestLoggingInterceptor;
import com.example.gympower.interceptor.TransactionProcessingInterceptor;
import com.example.gympower.model.mapper.ProductMapper;
import com.example.gympower.service.OrderService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private final OrderService orderService;
    private final ProductMapper productMapper;

    public InterceptorConfig(OrderService orderService, ProductMapper productMapper) {
        this.orderService = orderService;
        this.productMapper = productMapper;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestLoggingInterceptor())
                .addPathPatterns("/**");

        registry.addInterceptor(new TransactionProcessingInterceptor(orderService, productMapper))
                .addPathPatterns("/order/new/**");
    }
}
