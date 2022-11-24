package com.example.gympower.model.entity;

import com.example.gympower.model.entity.enums.OrderStatusEnum;

import javax.persistence.*;

@Table(name = "order_statuses")
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatusEnum statusName;

    public long getId() {
        return id;
    }

    public Status setId(long id) {
        this.id = id;
        return this;
    }

    public OrderStatusEnum getStatusName() {
        return statusName;
    }

    public Status setStatusName(OrderStatusEnum statusName) {
        this.statusName = statusName;
        return this;
    }
}
