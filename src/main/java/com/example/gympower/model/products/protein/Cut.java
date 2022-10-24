package com.example.gympower.model.products.protein;

import com.example.gympower.model.enums.CutEnum;

import javax.persistence.*;

@Table(name = "cut")
@Entity
public class Cut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CutEnum weight;

    public Cut() {
    }

    public long getId() {
        return id;
    }

    public Cut setId(long id) {
        this.id = id;
        return this;
    }

    public CutEnum getWeight() {
        return weight;
    }

    public Cut setWeight(CutEnum weight) {
        this.weight = weight;
        return this;
    }
}