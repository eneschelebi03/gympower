package com.example.gympower.service;

import com.example.gympower.model.entity.CartItem;
import com.example.gympower.repository.CartItemRepository;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public CartItem add(CartItem cartItem) {
        return this.cartItemRepository.save(cartItem);
    }

    public CartItem findById(long id) {
        return this.cartItemRepository.findById(id).get();
    }

    public void remove(CartItem cartItem) {
        this.cartItemRepository.delete(cartItem);
    }
}
