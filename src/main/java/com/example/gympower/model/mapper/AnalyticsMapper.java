package com.example.gympower.model.mapper;

import com.example.gympower.model.dto.display.admin.DisplayAnalyticsDTO;
import com.example.gympower.model.entity.Analytics;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AnalyticsMapper {

    Analytics analyticsDtoToAnalytics(DisplayAnalyticsDTO analyticsDTO);

    DisplayAnalyticsDTO analyticsToAnalyticsDto(Optional<Analytics> analytics);
}
