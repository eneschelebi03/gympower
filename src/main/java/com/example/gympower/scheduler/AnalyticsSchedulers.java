package com.example.gympower.scheduler;

import com.example.gympower.model.dto.display.admin.DisplayAnalyticsDTO;
import com.example.gympower.service.AnalyticsService;
import com.example.gympower.service.OrderService;
import com.example.gympower.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsSchedulers {

    private final UserService userService;
    private final OrderService orderService;
    private final AnalyticsService analyticsService;

    public AnalyticsSchedulers(UserService userService, OrderService orderService, AnalyticsService analyticsService) {
        this.userService = userService;
        this.orderService = orderService;
        this.analyticsService = analyticsService;
    }

    @Scheduled(cron = "0 * * * * *")
    public void analyzeDailySalesScheduler() {

        int newUsers = this.userService.findNewDailyUsers();

        DisplayAnalyticsDTO recentFinances = this.orderService.getRecentFinances();
        recentFinances.setNewUsers(newUsers);

        this.analyticsService.saveAnalytics(recentFinances);
    }

}
