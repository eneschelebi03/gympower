package com.example.gympower.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "analytics")
@Entity
public class Analytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal costs;

    private BigDecimal totalIncome;

    private BigDecimal profit;

    private int newUsers;

    private int ordersNumber;

    private LocalDateTime createdAt;

    public long getId() {
        return id;
    }

    public Analytics setId(long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public Analytics setCosts(BigDecimal costs) {
        this.costs = costs;
        return this;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public Analytics setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
        return this;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public Analytics setProfit(BigDecimal profit) {
        this.profit = profit;
        return this;
    }

    public int getNewUsers() {
        return newUsers;
    }

    public Analytics setNewUsers(int newUsers) {
        this.newUsers = newUsers;
        return this;
    }

    public int getOrdersNumber() {
        return ordersNumber;
    }

    public Analytics setOrdersNumber(int ordersNumber) {
        this.ordersNumber = ordersNumber;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Analytics setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
