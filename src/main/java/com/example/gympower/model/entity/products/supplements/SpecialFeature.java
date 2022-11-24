package com.example.gympower.model.entity.products.supplements;

import com.example.gympower.model.entity.enums.SpecialFeaturesEnum;

import javax.persistence.*;

@Table(name = "special_features")
@Entity
public class SpecialFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SpecialFeaturesEnum feature;

    public SpecialFeature() {
    }

    public long getId() {
        return id;
    }

    public SpecialFeature setId(long id) {
        this.id = id;
        return this;
    }

    public SpecialFeaturesEnum getFeature() {
        return feature;
    }

    public SpecialFeature setFeature(SpecialFeaturesEnum feature) {
        this.feature = feature;
        return this;
    }
}
