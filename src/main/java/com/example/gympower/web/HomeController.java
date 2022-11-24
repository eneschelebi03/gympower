package com.example.gympower.web;


import com.example.gympower.model.dto.ActiveOfferDTO;
import com.example.gympower.model.dto.CarouselProductDTO;
import com.example.gympower.service.ExclusiveOfferService;
import com.example.gympower.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@CrossOrigin("*")
@RestController
public class HomeController {

    private final ExclusiveOfferService exclusiveOfferService;

    private final ProductService productService;

    public HomeController(ExclusiveOfferService exclusiveOfferService, ProductService productService) {
        this.exclusiveOfferService = exclusiveOfferService;
        this.productService = productService;
    }

    @GetMapping("/carousel")
    public ResponseEntity<List<ActiveOfferDTO>> getCarouselOffers() {

        List<ActiveOfferDTO> carouselOffers = this.exclusiveOfferService.getActiveOffers();

        return ResponseEntity.ok(carouselOffers);
    }
}
