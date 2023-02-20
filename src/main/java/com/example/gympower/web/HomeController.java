package com.example.gympower.web;


import com.example.gympower.model.dto.display.ActiveOfferDTO;
import com.example.gympower.model.dto.display.CarouselProductDTO;
import com.example.gympower.service.ExclusiveOfferService;
import com.example.gympower.service.SupplementService;
import com.example.gympower.service.WearService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class HomeController {

    private final ExclusiveOfferService exclusiveOfferService;
    private final SupplementService supplementService;
    private final WearService wearService;

    public HomeController(ExclusiveOfferService exclusiveOfferService, SupplementService supplementService, WearService wearService) {
        this.exclusiveOfferService = exclusiveOfferService;
        this.supplementService = supplementService;
        this.wearService = wearService;
    }

    @GetMapping("/offers/carousel")
    public ResponseEntity<List<ActiveOfferDTO>> getCarouselOffers() {

        List<ActiveOfferDTO> carouselOffers = this.exclusiveOfferService.getActiveOffers();

        return ResponseEntity.ok(carouselOffers);
    }

    @GetMapping("/products/topSupps")
    public ResponseEntity<List<CarouselProductDTO>> getTopSupplements() {

        List<CarouselProductDTO> topSupplements = this.supplementService.getTopSuppDTOs();

        return ResponseEntity.ok(topSupplements);
    }

    @GetMapping("/products/topWear")
    public ResponseEntity<List<CarouselProductDTO>> getTopWear() {

        List<CarouselProductDTO> topSupplements = this.wearService.getTopWearDTOs();

        return ResponseEntity.ok(topSupplements);
    }

}
