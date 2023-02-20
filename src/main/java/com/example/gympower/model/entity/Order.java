package com.example.gympower.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    private List<OrderedProduct> orderedProducts = new ArrayList<>();

    @ManyToOne
    private UserEntity userEntity;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    private Status status;

    @ManyToOne
    private Address address;

    private BigDecimal totalCost;

    private BigDecimal totalIncome;

    public Order() {
    }

    public long getId() {
        return id;
    }

    public Order setId(long id) {
        this.id = id;
        return this;
    }

    public List<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public Order setOrderedProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Order setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Order setStatus(Status status) {
        this.status = status;
        return this;
    }

    public UserEntity getUser() {
        return userEntity;
    }

    public Order setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Order setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Order setAddress(Address address) {
        this.address = address;
        return this;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public Order setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public Order setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
        return this;
    }
}