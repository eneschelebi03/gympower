package com.example.gympower.servicesIntegrationTests;


import com.example.gympower.model.dto.display.admin.DisplayAnalyticsDTO;
import com.example.gympower.model.entity.Analytics;
import com.example.gympower.model.mapper.AnalyticsMapper;
import com.example.gympower.repository.AnalyticsRepository;
import com.example.gympower.service.AnalyticsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AnalyticsServiceTest {

    @Mock
    private AnalyticsRepository analyticsRepository;

    @Mock
    private AnalyticsMapper analyticsMapper;

    @InjectMocks
    private AnalyticsService analyticsService;

    @Test
    public void testGetLatestAnalytics() {
        // Arrange
        DisplayAnalyticsDTO expectedAnalyticsDTO = new DisplayAnalyticsDTO();
        Analytics analytics = new Analytics();
        when(analyticsRepository.findByCreatedAtAfter(Mockito.any(LocalDateTime.class)))
                .thenReturn(Optional.of(analytics));
        when(analyticsMapper.analyticsToAnalyticsDto(Optional.of(analytics))).thenReturn(expectedAnalyticsDTO);

        // Act
        DisplayAnalyticsDTO result = analyticsService.getLatestAnalytics();

        // Assert
        assertEquals(expectedAnalyticsDTO, result);

        // Verify that the repository method and mapper method were called
        Mockito.verify(analyticsRepository, Mockito.times(1)).findByCreatedAtAfter(Mockito.any(LocalDateTime.class));
        Mockito.verify(analyticsMapper, Mockito.times(1)).analyticsToAnalyticsDto(Optional.of(analytics));
    }

    @Test
    public void testSaveAnalytics() {
        // Arrange
        DisplayAnalyticsDTO inputAnalyticsDTO = new DisplayAnalyticsDTO();
        Analytics analytics = new Analytics();
        when(analyticsMapper.analyticsDtoToAnalytics(inputAnalyticsDTO)).thenReturn(analytics);

        // Act
        analyticsService.saveAnalytics(inputAnalyticsDTO);

        // Verify that the repository method and mapper method were called
        Mockito.verify(analyticsMapper, Mockito.times(1)).analyticsDtoToAnalytics(inputAnalyticsDTO);
        Mockito.verify(analyticsRepository, Mockito.times(1)).save(analytics);
    }
}

