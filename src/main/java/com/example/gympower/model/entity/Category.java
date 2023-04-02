package com.example.gympower.model.entity;

import com.example.gympower.model.entity.enums.ProductCategoriesEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private ProductCategoriesEnum categoryName;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public ProductCategoriesEnum getCategoryName() {
        return categoryName;
    }

    public Category setCategoryName(ProductCategoriesEnum categoryName) {
        this.categoryName = categoryName;
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