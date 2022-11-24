package com.example.gympower.model.entity.products.supplements;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "cuts")
@Entity
public class Cut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double quantity;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private BigDecimal cost;

    @Column(nullable = false)
    private BigDecimal price;

    private int produced;


    public long getId() {
        return id;
    }

    public Cut setId(long id) {
        this.id = id;
        return this;
    }

    public double getQuantity() {
        return quantity;
    }

    public Cut setQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public Cut setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public Cut setCost(BigDecimal cost) {
        this.cost = cost;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Cut setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getProduced() {
        return produced;
    }

    public Cut setProduced(int produced) {
        this.produced = produced;
        return this;
    }
}