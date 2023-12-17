package com.example.gympower.service;

import com.example.gympower.model.entity.products.wear.Color;
import com.example.gympower.repository.ColorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {

    private final ColorRepository colorRepository;

    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }


    public void cleanWearDiscounts() {
        this.colorRepository.findByDiscountNot(0).stream()
                .map(color -> color.setDiscount(0))
                .forEach(colorRepository::save);
    }

    public void discountRandomWear(int discountPercentage, int limit) {
        this.colorRepository.findRandomColors(limit).stream()
                .map(color -> color.setDiscount(discountPercentage))
                .forEach(colorRepository::save);
    }
}
