package com.example.gympower.model.entity.products;

import com.example.gympower.model.entity.Category;
import com.example.gympower.model.entity.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@MappedSuperclass
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String slogan;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double rating;

    @OneToMany
    private Set<Comment> comments;

    @ManyToMany
    private Set<Category> categories;

    private LocalDateTime added = LocalDateTime.now();


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

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public Product setRating(Double rating) {
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

    public Set<Category> getCategories() {
        return categories;
    }

    public Product setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public LocalDateTime getAdded() {
        return added;
    }

    public Product setAdded(LocalDateTime added) {
        this.added = added;
        return this;
    }

    public String getSlogan() {
        return slogan;
    }

    public Product setSlogan(String slogan) {
        this.slogan = slogan;
        return this;
    }
}
