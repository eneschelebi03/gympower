package com.example.gympower.servicesIntegrationTests;

import com.example.gympower.model.dto.display.AllProductsProductDTO;
import com.example.gympower.model.dto.display.CarouselProductDTO;
import com.example.gympower.model.dto.display.WearDetailsDTO;
import com.example.gympower.model.dto.display.admin.DisplayAdminProductDTO;
import com.example.gympower.model.entity.Category;
import com.example.gympower.model.entity.products.wear.Color;
import com.example.gympower.model.entity.products.wear.Size;
import com.example.gympower.model.entity.products.wear.Wear;
import com.example.gympower.model.mapper.ProductMapper;
import com.example.gympower.repository.WearRepository;
import com.example.gympower.service.WearService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class WearServiceIntegrationTest {

    @Mock
    private WearRepository wearRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private WearService wearService;

    @Test
    public void testGetTopWearDTOs() {
        CarouselProductDTO carouselProductDTO = new CarouselProductDTO();
        List<CarouselProductDTO> mockProducts = Collections.singletonList(carouselProductDTO);
        when(wearRepository.findByRatingAfterOrderByRating(4.20)).thenReturn(Collections.singletonList(new Wear()));
        when(productMapper.wearToTopProductDTO(any(Wear.class))).thenReturn(carouselProductDTO);

        List<CarouselProductDTO> result = wearService.getTopWearDTOs();

        assertEquals(mockProducts, result);
        verify(wearRepository, times(1)).findByRatingAfterOrderByRating(4.20);
    }

    @Test
    public void testGetAllWear() {
        AllProductsProductDTO allProductsProductDTO = new AllProductsProductDTO();
        List<AllProductsProductDTO> mockProducts = Collections.singletonList(allProductsProductDTO);
        when(wearRepository.findAll()).thenReturn(Collections.singletonList(new Wear()));
        when(productMapper.wearToAllProductsProductDTO(any(Wear.class))).thenReturn(allProductsProductDTO);

        List<AllProductsProductDTO> result = wearService.getAllWear();

        assertEquals(mockProducts, result);
        verify(wearRepository, times(1)).findAll();
    }

    @Test
    public void testFindWear() {
        Wear mockWear = new Wear();
        when(wearRepository.findById(1L)).thenReturn(Optional.of(mockWear));

        Wear result = wearService.findWear(1L);

        assertEquals(mockWear, result);
        verify(wearRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindWearDetails() {
        Wear mockWear = new Wear();
        WearDetailsDTO mockWearDetailsDTO = new WearDetailsDTO();
        when(wearRepository.findById(1L)).thenReturn(Optional.of(mockWear));
        when(productMapper.wearToWearDetailsDTO(mockWear)).thenReturn(mockWearDetailsDTO);

        WearDetailsDTO result = wearService.findWearDetails(1L);

        assertEquals(mockWearDetailsDTO, result);
        verify(wearRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindRelatedProducts() {
        List<Wear> mockRelatedProducts = Collections.singletonList(new Wear());
        when(wearRepository.findCategoriesByWearId(1L)).thenReturn(Set.of(new Category()));
        when(wearRepository.findTop4ByCategoriesCategoryNameAndIdNot(any(), eq(1L))).thenReturn(mockRelatedProducts);
        when(productMapper.wearToTopProductDTO(any(Wear.class))).thenReturn(new CarouselProductDTO());

        List<CarouselProductDTO> result = wearService.findRelatedProducts(1L);

        assertEquals(mockRelatedProducts.size(), result.size());
        verify(wearRepository, times(1)).findCategoriesByWearId(1L);
        verify(wearRepository, times(1)).findTop4ByCategoriesCategoryNameAndIdNot(any(), eq(1L));
    }

    @Test
    public void testReduceQuantity() {
        Wear mockWear = new Wear();
        Color mockColor = new Color().setColorName("Red");
        Size mockSize = new Size().setName("M").setItemsProduced(1);
        mockColor.setSizes(Set.of(mockSize));
        mockWear.setAvailableColors(Set.of(mockColor));
        when(wearRepository.findById(1L)).thenReturn(Optional.of(mockWear));

        wearService.reduceQuantity(mockWear, "Red", "M", 1);

        assertEquals(0, mockSize.getItemsProduced());
        verify(wearRepository, times(1)).save(mockWear);
    }

    @Test
    public void testGetAllWearAdminTable() {
        // Mocking data
        List<Wear> mockAllWear = Arrays.asList(new Wear(), new Wear());
        when(wearRepository.findAll()).thenReturn(mockAllWear);
        when(productMapper.wearToAdminProductDTO(any(Wear.class))).thenReturn(new DisplayAdminProductDTO());

        // Invoke the method
        List<DisplayAdminProductDTO> result = wearService.getAllWearAdminTable();

        // Verify the result
        assertEquals(mockAllWear.size(), result.size());
        verify(wearRepository, times(1)).findAll();
    }

}

