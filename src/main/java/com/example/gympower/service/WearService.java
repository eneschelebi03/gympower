package com.example.gympower.service;

import com.example.gympower.model.dto.AllProductsProductDTO;
import com.example.gympower.model.dto.CarouselProductDTO;
import com.example.gympower.model.dto.WearDetailsDTO;
import com.example.gympower.model.entity.Category;
import com.example.gympower.model.entity.enums.ProductCategoriesEnum;
import com.example.gympower.model.entity.products.wear.Wear;
import com.example.gympower.model.mapper.ProductMapper;
import com.example.gympower.repository.WearRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WearService {

    private final ProductMapper productMapper;

    private final WearRepository wearRepository;

    public WearService(ProductMapper productMapper, WearRepository wearRepository) {
        this.productMapper = productMapper;
        this.wearRepository = wearRepository;
    }


    public List<CarouselProductDTO> getTopWearDTOs() {
        return this.wearRepository.findByRatingAfterOrderByRating(4.20)
                .stream()
                .map(this.productMapper::wearToTopProductDTO)
                .collect(Collectors.toList());
    }

    public List<AllProductsProductDTO> getAllWear() {
        return this.wearRepository.findAll()
                .stream()
                .map(this.productMapper::wearToAllProductsProductDTO)
                .collect(Collectors.toList());
    }

    public Wear findWear(long id) {
        return this.wearRepository.findById(id).get();

    }

    public WearDetailsDTO findWearDetails(long id) {
        Wear wear = this.wearRepository.findById(id).get();

        return this.productMapper.wearToWearDetailsDTO(wear);
    }

    public List<CarouselProductDTO> findRelatedProducts(long id) {
        List<ProductCategoriesEnum> wantedCategories = this.wearRepository.findCategoriesByWearId(id)
                .stream()
                .map(Category::getCategory)
                .toList();

        Random rand = new Random();

        int randomIndex = rand.nextInt(wantedCategories.size());

        ProductCategoriesEnum wantedCategory = wantedCategories.get(randomIndex);



            return this.wearRepository.findTop4ByCategoriesCategoryAndIdNot(wantedCategory, id).stream()
                    .map(this.productMapper::wearToTopProductDTO)
                    .collect(Collectors.toList());

    }
}
