package com.example.gympower.model;

import com.example.gympower.model.enums.ProductCategory;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private ProductCategory name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public ProductCategory getName() {
        return name;
    }

    public Category setName(ProductCategory name) {
        this.name = name;
        return this;
    }

    public Category setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}