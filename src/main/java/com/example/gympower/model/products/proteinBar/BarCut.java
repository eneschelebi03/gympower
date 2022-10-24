package com.example.gympower.model.products.proteinBar;

import com.example.gympower.model.enums.BarCutEnum;

import javax.persistence.*;

@Table(name = "bar_cuts")
@Entity
public class BarCut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private BarCutEnum barCut;

    public long getId() {
        return id;
    }

    public BarCut setId(long id) {
        this.id = id;
        return this;
    }

    public BarCutEnum getBarCut() {
        return barCut;
    }

    public BarCut setBarCut(BarCutEnum barCut) {
        this.barCut = barCut;
        return this;
    }
}
