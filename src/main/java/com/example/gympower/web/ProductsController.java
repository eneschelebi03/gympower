package com.example.gympower.web;

import com.example.gympower.model.dto.AllProductsProductDTO;
import com.example.gympower.model.dto.CarouselProductDTO;
import com.example.gympower.model.dto.WearDetailsDTO;
import com.example.gympower.service.SupplementService;
import com.example.gympower.service.WearService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class ProductsController {

    private final SupplementService supplementService;
    private final WearService wearService;

    public ProductsController(SupplementService supplementService, WearService wearService) {
        this.supplementService = supplementService;
        this.wearService = wearService;
    }

    @GetMapping("/supplements/all")
    public ResponseEntity<List<AllProductsProductDTO>> allSupplements() {

        List<AllProductsProductDTO> allSupplementDTOs = this.supplementService.getAllSupplementDTOs();

        return ResponseEntity.ok(allSupplementDTOs);
    }

    @GetMapping("/wear/all")
    public ResponseEntity<List<AllProductsProductDTO>> allWear() {

        List<AllProductsProductDTO> allWearDTOs = this.wearService.getAllWear();

        return ResponseEntity.ok(allWearDTOs);
    }

    @GetMapping("/wear/{id}/details")
    public ResponseEntity<WearDetailsDTO> productDetails(@PathVariable("id") long id) {

        WearDetailsDTO wearDetails = this.wearService.findWearDetails(id);

        return ResponseEntity.ok(wearDetails);
    }

    @GetMapping("/wear/{id}/related")
    public ResponseEntity<List<CarouselProductDTO>> relatedProducts(@PathVariable("id") long id) {

        List<CarouselProductDTO> relatedProducts = this.wearService.findRelatedProducts(id);

        return ResponseEntity.ok(relatedProducts);
    }


}
