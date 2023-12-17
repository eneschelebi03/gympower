package com.example.gympower.model.dto.display.admin;

import java.math.BigDecimal;

public class DisplayAnalyticsDTO {

    private BigDecimal totalSales;

    private BigDecimal costs;

    private BigDecimal profit;

    private int ordersNumber;

    private int newUsers;

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public DisplayAnalyticsDTO setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
        return this;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public DisplayAnalyticsDTO setCosts(BigDecimal costs) {
        this.costs = costs;
        return this;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public DisplayAnalyticsDTO setProfit(BigDecimal profit) {
        this.profit = profit;
        return this;
    }

    public int getOrdersNumber() {
        return ordersNumber;
    }

    public DisplayAnalyticsDTO setOrdersNumber(int ordersNumber) {
        this.ordersNumber = ordersNumber;
        return this;
    }

    public int getNewUsers() {
        return newUsers;
    }

    public DisplayAnalyticsDTO setNewUsers(int newUsers) {
        this.newUsers = newUsers;
        return this;
    }
}
