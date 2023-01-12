package com.example.gympower.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long productId;

    @ManyToOne
    private UserEntity userEntity;

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

    public long getProductId() {
        return productId;
    }

    public Order setProductId(long productId) {
        this.productId = productId;
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Order setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }
}