package com.example.gympower.servicesIntegrationTests;

import com.example.gympower.model.dto.display.AllProductsProductDTO;
import com.example.gympower.model.dto.display.CarouselProductDTO;
import com.example.gympower.model.entity.products.supplements.Flavor;
import com.example.gympower.model.entity.products.supplements.Supplement;
import com.example.gympower.model.mapper.ProductMapper;
import com.example.gympower.repository.SupplementRepository;
import com.example.gympower.service.SupplementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SupplementServiceIntegrationTest {

    @Mock
    private SupplementRepository supplementRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private SupplementService supplementService;



    @Test
    public void testGetTopSuppDTOs() {
        // Mocking data
        Supplement supplement = new Supplement();
        supplement.setId(1l);
        supplement.setFlavors(Set.of(new Flavor()));

        Supplement supplement2 = new Supplement();
        supplement.setId(2l);
        supplement.setFlavors(Set.of(new Flavor()));

        List<Supplement> mockSupplements = new ArrayList<>();
        mockSupplements.add(supplement);
        mockSupplements.add(supplement2);

        when(supplementRepository.findByRatingAfterOrderByRating(4.50)).thenReturn(mockSupplements);

        List<CarouselProductDTO> mockDTOs = Arrays.asList(
                new CarouselProductDTO().setId(1L).setRating(4.8),
                new CarouselProductDTO().setId(2L).setRating(4.6)
        );
        when(productMapper.supplementToDisplayProductDTO(mockSupplements.get(0))).thenReturn(mockDTOs.get(0));
        when(productMapper.supplementToDisplayProductDTO(mockSupplements.get(1))).thenReturn(mockDTOs.get(1));

        // Invoke the method
        List<CarouselProductDTO> result = supplementService.getTopSuppDTOs();

        // Verify the result
        assertEquals(mockDTOs, result);
    }

    @Test
    public void testGetAllSupplementDTOs() {
        List<Supplement> mockAllSupplements = Arrays.asList(new Supplement(), new Supplement());
        when(supplementRepository.findAll()).thenReturn(mockAllSupplements);
        when(productMapper.supplementToAllProductsSuppDTO(any(Supplement.class))).thenReturn(new AllProductsProductDTO());

        List<AllProductsProductDTO> result = supplementService.getAllSupplementDTOs();

        assertEquals(mockAllSupplements.size(), result.size());
        verify(supplementRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        long supplementId = 1L;
        Supplement mockSupplement = new Supplement();
        when(supplementRepository.findById(supplementId)).thenReturn(java.util.Optional.of(mockSupplement));

        Supplement result = supplementService.findById(supplementId);

        assertEquals(mockSupplement, result);
        verify(supplementRepository, times(1)).findById(supplementId);
    }
}

