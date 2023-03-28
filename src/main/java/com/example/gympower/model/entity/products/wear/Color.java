package com.example.gympower.model.entity.products.wear;

import com.example.gympower.model.entity.Picture;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Table(name = "colors")
@Entity
public class        Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String colorName;

    @Column(nullable = false)
    private String colorCode;

    @Column(nullable = false)
    private BigDecimal cost;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToMany
    private Set<Size> sizes;

    private boolean isAvailable;

    @ManyToMany
    private Set<Picture> pictures;

    public Color() {
    }

    public long getId() {
        return id;
    }

    public Color setId(long id) {
        this.id = id;
        return this;
    }

    public String getColorName() {
        return colorName;
    }

    public Color setColorName(String colorName) {
        this.colorName = colorName;
        return this;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public Color setCost(BigDecimal cost) {
        this.cost = cost;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Color setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Color setAvailable(boolean available) {
        isAvailable = available;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public Color setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public Set<Size> getSizes() {
        return sizes;
    }

    public Color setSizes(Set<Size> sizes) {
        this.sizes = sizes;
        return this;
    }

    public String getColorCode() {
        return colorCode;
    }

    public Color setColorCode(String colorCode) {
        this.colorCode = colorCode;
        return this;
    }
}
