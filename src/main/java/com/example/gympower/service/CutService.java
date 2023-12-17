package com.example.gympower.service;

import com.example.gympower.model.entity.products.supplements.Cut;
import com.example.gympower.model.entity.products.wear.Color;
import com.example.gympower.repository.CutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CutService {

    private final CutRepository cutRepository;

    public CutService(CutRepository cutRepository) {
        this.cutRepository = cutRepository;
    }

    public void cleanSuppDiscounts() {
        this.cutRepository.findByDiscountNot(0).stream()
                .map(cut -> cut.setDiscount(0))
                .forEach(cutRepository::save);
    }

    public void discountRandomSupps(int discountPercentage, int limit) {
        this.cutRepository.findRandomCuts(limit).stream()
                .map(cut -> cut.setDiscount(discountPercentage))
                .forEach(cutRepository::save);
    }
}
