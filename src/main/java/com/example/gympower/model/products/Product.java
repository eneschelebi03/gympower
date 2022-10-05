package com.example.gympower.model.products;

import com.example.gympower.model.Category;
import com.example.gympower.model.Comment;
import com.example.gympower.model.Picture;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@MappedSuperclass
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "product")
    private Set<Picture> pictures;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private BigDecimal cost;

    private double rating;

    @OneToMany(mappedBy = "relatedProduct")
    private Set<Comment> comments;


    @ManyToMany
    private Set<Category> category;

    public long getId() {
        return id;
    }

    public Product setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public Product setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public Product setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Product setComments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public Product setCategory(Set<Category> category) {
        this.category = category;
        return this;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public Product setCost(BigDecimal cost) {
        this.cost = cost;
        return this;
    }
}
