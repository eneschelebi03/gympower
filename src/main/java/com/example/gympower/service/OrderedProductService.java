package com.example.gympower.service;

import com.example.gympower.model.dto.display.DisplayOrderedProductDTO;
import com.example.gympower.model.entity.Order;
import com.example.gympower.model.entity.OrderedProduct;
import com.example.gympower.model.mapper.ProductMapper;
import com.example.gympower.repository.OrderedProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedProductService {

    private final OrderedProductRepository orderedProductRepository;
    private final ProductMapper productMapper;


    public OrderedProductService(OrderedProductRepository orderedProductRepository, ProductMapper productMapper) {
        this.orderedProductRepository = orderedProductRepository;
        this.productMapper = productMapper;
    }

    public OrderedProduct save(OrderedProduct orderedProduct) {
        return this.orderedProductRepository.save(orderedProduct);
    }

    public List<DisplayOrderedProductDTO> getOrdersProducts(Order order) {
        return order.getOrderedProducts().stream()
                .map(this.productMapper::orderedProductToDisplayDTO)
                .toList();
    }
}
