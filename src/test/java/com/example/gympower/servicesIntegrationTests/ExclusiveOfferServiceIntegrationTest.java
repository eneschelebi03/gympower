package com.example.gympower.servicesIntegrationTests;

import com.example.gympower.model.dto.display.ActiveOfferDTO;
import com.example.gympower.model.entity.products.ExclusiveOffer;
import com.example.gympower.model.mapper.ExclusiveOfferMapper;
import com.example.gympower.repository.ExclusiveOfferRepository;
import com.example.gympower.service.ExclusiveOfferService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ExclusiveOfferServiceIntegrationTest {

    @Mock
    private ExclusiveOfferRepository exclusiveOfferRepository;

    @Mock
    private ExclusiveOfferMapper exclusiveOfferMapper;

    @InjectMocks
    private ExclusiveOfferService exclusiveOfferService;

    @Test
    public void testGetActiveOffers() {
        // Arrange
        ExclusiveOffer offer1 = new ExclusiveOffer().setId(1L).setActive(true);
        ExclusiveOffer offer2 = new ExclusiveOffer().setId(2L).setActive(true);

        ActiveOfferDTO activeOfferDTO1 = new ActiveOfferDTO();
        ActiveOfferDTO activeOfferDTO2 = new ActiveOfferDTO();

        when(exclusiveOfferRepository.findAllByIsActive(true)).thenReturn(Arrays.asList(offer1, offer2));
        when(exclusiveOfferMapper.offerToActiveOfferDto(offer1)).thenReturn(activeOfferDTO1);
        when(exclusiveOfferMapper.offerToActiveOfferDto(offer2)).thenReturn(activeOfferDTO2);

        // Act
        List<ActiveOfferDTO> result = exclusiveOfferService.getActiveOffers();

        // Assert
        assertEquals(2, result.size());
        assertEquals(activeOfferDTO1, result.get(0));
        assertEquals(activeOfferDTO2, result.get(1));

        // Verify that the repository method and mapper method were called
        Mockito.verify(exclusiveOfferRepository, Mockito.times(1)).findAllByIsActive(true);
        Mockito.verify(exclusiveOfferMapper, Mockito.times(1)).offerToActiveOfferDto(offer1);
        Mockito.verify(exclusiveOfferMapper, Mockito.times(1)).offerToActiveOfferDto(offer2);
    }

    @Test
    public void testGetActiveOffersNoActiveOffers() {
        // Arrange
        when(exclusiveOfferRepository.findAllByIsActive(true)).thenReturn(Collections.emptyList());

        // Act
        List<ActiveOfferDTO> result = exclusiveOfferService.getActiveOffers();

        // Assert
        assertEquals(0, result.size());

        // Verify that the repository method and mapper method were called
        Mockito.verify(exclusiveOfferRepository, Mockito.times(1)).findAllByIsActive(true);
        Mockito.verify(exclusiveOfferMapper, Mockito.never()).offerToActiveOfferDto(Mockito.any());
    }
}

