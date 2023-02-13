package com.example.gympower.service;

import com.example.gympower.model.entity.OrderedProduct;
import com.example.gympower.repository.OrderedProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderedProductService {

    private final OrderedProductRepository orderedProductRepository;


    public OrderedProductService(OrderedProductRepository orderedProductRepository) {
        this.orderedProductRepository = orderedProductRepository;
    }

    public OrderedProduct save(OrderedProduct orderedProduct) {
        return this.orderedProductRepository.save(orderedProduct);
    }
}
