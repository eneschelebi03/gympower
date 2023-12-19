package com.example.gympower.servicesIntegrationTests;

import com.example.gympower.model.entity.products.supplements.Cut;
import com.example.gympower.repository.CutRepository;
import com.example.gympower.service.CutService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CutServiceIntegrationTest {

    @Mock
    private CutRepository cutRepository;

    @InjectMocks
    private CutService cutService;

    @Test
    public void testCleanSuppDiscounts() {
        // Arrange
        List<Cut> cutsWithDiscount = Arrays.asList(
                new Cut().setId(1L).setDiscount(10),
                new Cut().setId(2L).setDiscount(15),
                new Cut().setId(3L).setDiscount(20)
        );

        when(cutRepository.findByDiscountNot(0)).thenReturn(cutsWithDiscount);
        when(cutRepository.save(Mockito.any(Cut.class))).thenReturn(null); // Mocking the save method

        // Act
        cutService.cleanSuppDiscounts();

        // Verify that the repository method was called
        Mockito.verify(cutRepository, Mockito.times(cutsWithDiscount.size())).save(Mockito.any());
    }

    @Test
    public void testDiscountRandomSupps() {
        // Arrange
        int discountPercentage = 25;
        int limit = 3;
        List<Cut> randomCuts = Arrays.asList(
                new Cut().setId(4L),
                new Cut().setId(5L),
                new Cut().setId(6L)
        );

        when(cutRepository.findRandomCuts(limit)).thenReturn(randomCuts);
        when(cutRepository.save(Mockito.any(Cut.class))).thenReturn(null); // Mocking the save method

        // Act
        cutService.discountRandomSupps(discountPercentage, limit);

        // Verify that the repository method was called
        Mockito.verify(cutRepository, Mockito.times(randomCuts.size())).save(Mockito.any());
    }

    @Test
    public void testCleanSuppDiscountsNoDiscounts() {
        // Arrange
        List<Cut> cutsWithNoDiscount = Collections.emptyList();

        when(cutRepository.findByDiscountNot(0)).thenReturn(cutsWithNoDiscount);

        // Act
        cutService.cleanSuppDiscounts();

        // Verify that the repository method was not called
        Mockito.verify(cutRepository, Mockito.never()).save(Mockito.any());
    }

    @Test
    public void testDiscountRandomSuppsNoCuts() {
        // Arrange
        int discountPercentage = 25;
        int limit = 3;
        List<Cut> randomCuts = Collections.emptyList();

        when(cutRepository.findRandomCuts(limit)).thenReturn(randomCuts);

        // Act
        cutService.discountRandomSupps(discountPercentage, limit);

        // Verify that the repository method was not called
        Mockito.verify(cutRepository, Mockito.never()).save(Mockito.any());
    }
}
