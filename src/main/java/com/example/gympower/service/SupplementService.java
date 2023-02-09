package com.example.gympower.service;

import com.example.gympower.model.dto.AllProductsProductDTO;
import com.example.gympower.model.dto.CarouselProductDTO;
import com.example.gympower.model.entity.products.supplements.Supplement;
import com.example.gympower.model.mapper.ProductMapper;
import com.example.gympower.repository.SupplementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplementService {

    private final SupplementRepository supplementRepository;

    private final ProductMapper productMapper;

    public SupplementService(SupplementRepository supplementRepository, ProductMapper productMapper) {
        this.supplementRepository = supplementRepository;
        this.productMapper = productMapper;
    }

    public Supplement findById(long id) {
       return this.supplementRepository.findById(id).get();
    }

    public List<CarouselProductDTO> getTopSuppDTOs() {
        return this.supplementRepository.findByRatingAfterOrderByRating(4.50)
                .stream()
                .map(this.productMapper::supplementToDisplayProductDTO)
                .collect(Collectors.toList());
    }

    public List<AllProductsProductDTO> getAllSupplementDTOs() {
        return this.supplementRepository.findAll().stream()
                .map(this.productMapper::supplementToAllProductsSuppDTO)
                .collect(Collectors.toList());
    }
}
