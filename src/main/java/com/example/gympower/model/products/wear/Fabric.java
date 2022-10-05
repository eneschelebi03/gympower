package com.example.gympower.model.products.wear;

import com.example.gympower.model.enums.FabricsEnum;

import javax.persistence.*;

@Table(name = "fabrics")
@Entity
public class Fabric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer percentage;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private FabricsEnum name;

    public Fabric() {
    }

    public long getId() {
        return id;
    }

    public Fabric setId(long id) {
        this.id = id;
        return this;
    }

    public FabricsEnum getName() {
        return name;
    }

    public Fabric setName(FabricsEnum name) {
        this.name = name;
        return this;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public Fabric setPercentage(Integer percentage) {
        this.percentage = percentage;
        return this;
    }
}
