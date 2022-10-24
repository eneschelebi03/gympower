package com.example.gympower.model;

import com.example.gympower.model.enums.StatusEnum;

import javax.persistence.*;

@Table(name = "statuses")
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum statusName;

    public long getId() {
        return id;
    }

    public Status setId(long id) {
        this.id = id;
        return this;
    }

    public StatusEnum getStatusName() {
        return statusName;
    }

    public Status setStatusName(StatusEnum statusName) {
        this.statusName = statusName;
        return this;
    }
}
