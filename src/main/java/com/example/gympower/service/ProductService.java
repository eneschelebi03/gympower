package com.example.gympower.service;

import com.example.gympower.model.dto.display.AllProductsProductDTO;
import com.example.gympower.model.dto.display.admin.DisplayAdminProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final WearService wearService;

    private final SupplementService supplementService;

    public ProductService(WearService wearService, SupplementService supplementService) {
        this.wearService = wearService;
        this.supplementService = supplementService;
    }


    public List<DisplayAdminProductDTO> getAllProducts() {
        return this.wearService.getAllWearAdminTable();
    }
}
