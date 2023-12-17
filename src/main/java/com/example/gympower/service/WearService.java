package com.example.gympower.service;

import com.example.gympower.model.dto.display.AllProductsProductDTO;
import com.example.gympower.model.dto.display.CarouselProductDTO;
import com.example.gympower.model.dto.display.WearDetailsDTO;
import com.example.gympower.model.dto.display.admin.DisplayAdminProductDTO;
import com.example.gympower.model.entity.Category;
import com.example.gympower.model.entity.enums.ProductCategoriesEnum;
import com.example.gympower.model.entity.products.wear.Color;
import com.example.gympower.model.entity.products.wear.Size;
import com.example.gympower.model.entity.products.wear.Wear;
import com.example.gympower.model.mapper.ProductMapper;
import com.example.gympower.repository.ColorRepository;
import com.example.gympower.repository.WearRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WearService {

    private final ProductMapper productMapper;

    private final WearRepository wearRepository;
    private final ColorService colorService;

    public WearService(ProductMapper productMapper, WearRepository wearRepository, ColorService colorService) {
        this.productMapper = productMapper;
        this.wearRepository = wearRepository;
        this.colorService = colorService;
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
                .map(Category::getCategoryName)
                .toList();

        Random rand = new Random();

        int randomIndex = rand.nextInt(wantedCategories.size());

        ProductCategoriesEnum wantedCategory = wantedCategories.get(randomIndex);


        return this.wearRepository.findTop4ByCategoriesCategoryNameAndIdNot(wantedCategory, id).stream()
                .map(this.productMapper::wearToTopProductDTO)
                .collect(Collectors.toList());
    }

    public void reduceQuantity(Wear wear, String color, String size, int count) {
        Color wearColor = wear.getAvailableColors().stream()
                .filter(c -> c.getColorName().equals(color))
                .findFirst()
                .get();

        Size wearSize = wearColor.getSizes().stream()
                .filter(s -> s.getName().equals(size))
                .findFirst()
                .get();

        wearSize.setItemsProduced(wearSize.getItemsProduced() - count);

        this.wearRepository.save(wear);
    }

    public List<DisplayAdminProductDTO> getAllWearAdminTable() {
        return this.wearRepository.findAll().stream()
                .map(this.productMapper::wearToAdminProductDTO)
                .toList();
    }
}
