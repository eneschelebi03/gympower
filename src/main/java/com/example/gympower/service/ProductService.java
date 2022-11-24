package com.example.gympower.service;

import com.example.gympower.repository.SupplementRepository;
import com.example.gympower.repository.WearRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final SupplementRepository proteinRepository;
    private final WearRepository wearRepository;

    public ProductService(SupplementRepository supplementRepository, WearRepository wearRepository) {
        this.proteinRepository = supplementRepository;
        this.wearRepository = wearRepository;
    }

}
