package com.example.gympower.service;

import com.example.gympower.model.dto.display.admin.DisplayAnalyticsDTO;
import com.example.gympower.model.entity.Analytics;
import com.example.gympower.model.mapper.AnalyticsMapper;
import com.example.gympower.repository.AnalyticsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AnalyticsService {

    private final AnalyticsRepository analyticsRepository;
    private final AnalyticsMapper analyticsMapper;

    public AnalyticsService(AnalyticsRepository analyticsRepository, AnalyticsMapper analyticsMapper) {
        this.analyticsRepository = analyticsRepository;
        this.analyticsMapper = analyticsMapper;
    }


    public DisplayAnalyticsDTO getLatestAnalytics() {

        Optional<Analytics> analytics = this.analyticsRepository
                .findByCreatedAtAfter(LocalDateTime.now().minusDays(1));

        return this.analyticsMapper.analyticsToAnalyticsDto(analytics);
    }

    public void saveAnalytics(DisplayAnalyticsDTO recentFinances) {
        Analytics analytics = this.analyticsMapper.analyticsDtoToAnalytics(recentFinances);
        this.analyticsRepository.save(analytics);
    }
}
