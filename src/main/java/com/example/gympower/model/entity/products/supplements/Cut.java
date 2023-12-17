package com.example.gympower.model.entity.products.supplements;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

    @Column
    @Min(5)
    @Max(70)
    private int discount;

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

    public int getDiscount() {
        return discount;
    }

    public Cut setDiscount(int discount) {
        this.discount = discount;
        return this;
    }
}