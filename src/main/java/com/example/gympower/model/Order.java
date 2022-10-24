package com.example.gympower.model;

import com.example.gympower.model.products.Product;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    private Set<Product> productId;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private LocalDateTime localDateTime;

    @ManyToOne
    private Status status;

    public Order() {
    }

    public long getId() {
        return id;
    }

    public Order setId(long id) {
        this.id = id;
        return this;
    }

    public Set<Product> getProductId() {
        return productId;
    }

    public Order setProductId(Set<Product> productId) {
        this.productId = productId;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Order setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }
}