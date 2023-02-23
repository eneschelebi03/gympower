package com.example.gympower.model.dto.display.admin;

import java.math.BigDecimal;

public class DisplayFinancesDTO {

    private BigDecimal totalSales;

    private BigDecimal costs;

    private BigDecimal profit;

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public DisplayFinancesDTO setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
        return this;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public DisplayFinancesDTO setCosts(BigDecimal costs) {
        this.costs = costs;
        return this;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public DisplayFinancesDTO setProfit(BigDecimal profit) {
        this.profit = profit;
        return this;
    }
}
