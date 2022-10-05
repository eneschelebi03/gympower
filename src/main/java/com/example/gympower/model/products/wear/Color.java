package com.example.gympower.model.products.wear;

import com.example.gympower.model.enums.ColorEnum;

import javax.persistence.*;

@Table(name = "colors")
@Entity
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private ColorEnum name;

    public Color() {
    }

    public long getId() {
        return id;
    }

    public Color setId(long id) {
        this.id = id;
        return this;
    }

    public ColorEnum getName() {
        return name;
    }

    public Color setName(ColorEnum name) {
        this.name = name;
        return this;
    }
}
