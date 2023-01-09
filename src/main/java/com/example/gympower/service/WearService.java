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

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public WearDetailsDTO findWearDetails(long id) {
        Wear wear = this.wearRepository.findById(id).get();

        return this.productMapper.wearToWearDetailsDTO(wear);
    }

    public List<CarouselProductDTO> findRelatedProducts(long id) {
        List<Category> wantedCategories = this.wearRepository.findCategoriesByWearId(id);
        ProductCategoriesEnum wantedCategory = wantedCategories.stream()
                .parallel()
                .findAny()
                .map(Category::getCategory)
                .get();

            return this.wearRepository.findTop4ByCategoriesCategory(wantedCategory).stream()
                    .map(this.productMapper::wearToTopProductDTO)
                    .collect(Collectors.toList());

    }
}
