package com.example.gympower.model.products.protein;

import com.example.gympower.model.enums.FlavorEnum;

import javax.persistence.*;

@Table(name = "flavors")
@Entity
public class Flavor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FlavorEnum name;

    public Flavor() {
    }

    public long getId() {
        return id;
    }

    public Flavor setId(long id) {
        this.id = id;
        return this;
    }

    public FlavorEnum getName() {
        return name;
    }

    public Flavor setName(FlavorEnum name) {
        this.name = name;
        return this;
    }
}
