package com.example.gympower.model.products.proteinBar;

import com.example.gympower.model.enums.BarFlavorEnum;

import javax.persistence.*;

@Table(name = "bar_flavors")
@Entity
public class BarFlavor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private BarFlavorEnum flavor;

    public long getId() {
        return id;
    }

    public BarFlavor setId(long id) {
        this.id = id;
        return this;
    }

    public BarFlavorEnum getFlavor() {
        return flavor;
    }

    public BarFlavor setFlavor(BarFlavorEnum flavor) {
        this.flavor = flavor;
        return this;
    }
}
