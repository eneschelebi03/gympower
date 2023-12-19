package com.example.gympower.servicesIntegrationTests;

import com.example.gympower.model.entity.products.wear.Color;
import com.example.gympower.repository.ColorRepository;
import com.example.gympower.service.ColorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ColorServiceIntegrationTest {

    @Mock
    private ColorRepository colorRepository;

    @InjectMocks
    private ColorService colorService;

    @Test
    public void testCleanWearDiscounts() {
        // Arrange
        List<Color> colorsWithDiscount = createSampleColorsWithDiscount();
        when(colorRepository.findByDiscountNot(0)).thenReturn(colorsWithDiscount);

        // Act
        colorService.cleanWearDiscounts();

        // Verify that the repository method was called
        Mockito.verify(colorRepository, Mockito.times(colorsWithDiscount.size())).save(Mockito.any());
    }

    @Test
    public void testDiscountRandomWear() {
        // Arrange
        int discountPercentage = 20;
        int limit = 3;
        List<Color> randomColors = createSampleRandomColors();
        when(colorRepository.findRandomColors(limit)).thenReturn(randomColors);

        // Act
        colorService.discountRandomWear(discountPercentage, limit);

        // Verify that the repository method was called
        Mockito.verify(colorRepository, Mockito.times(randomColors.size())).save(Mockito.any());
    }

    private List<Color> createSampleColorsWithDiscount() {
        // Create sample colors with a discount
        Color color1 = new Color().setId(1L).setDiscount(10);
        Color color2 = new Color().setId(2L).setDiscount(15);
        Color color3 = new Color().setId(3L).setDiscount(20);

        List<Color> colors = new ArrayList<>();
        colors.add(color1);
        colors.add(color2);
        colors.add(color3);

        return colors;
    }

    private List<Color> createSampleRandomColors() {
        // Create sample random colors
        Color color1 = new Color().setId(1L);
        Color color2 = new Color().setId(2L);
        Color color3 = new Color().setId(3L);

        List<Color> colors = new ArrayList<>();
        colors.add(color1);
        colors.add(color2);
        colors.add(color3);

        return colors;
    }
}
