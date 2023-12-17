package com.example.gympower.scheduler;

import com.example.gympower.model.dto.display.admin.DisplayAnalyticsDTO;
import com.example.gympower.service.ColorService;
import com.example.gympower.service.CutService;
import com.example.gympower.service.SupplementService;
import com.example.gympower.service.WearService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DiscountSchedulers {

    private final ColorService colorService;
    private final CutService cutService;

    public DiscountSchedulers(ColorService colorService, CutService cutService) {
        this.colorService = colorService;
        this.cutService = cutService;
    }

    @Scheduled(cron = "10 * * * * *")
    public void discountRandomProductsScheduler() {

        this.colorService.cleanWearDiscounts();
        this.cutService.cleanSuppDiscounts();

        Random random = new Random();

        int discountPercentage = random.nextInt(66) + 5;

        this.colorService.discountRandomWear(discountPercentage, 10);
        this.cutService.discountRandomSupps(discountPercentage, 10);
    }


}
