package com.example.gympower.model.products.protein;

import com.example.gympower.model.enums.SpecialFeaturesEnum;

import javax.persistence.*;

@Table(name = "specials")
@Entity
public class SpecialFeatures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private SpecialFeaturesEnum feature;

    public SpecialFeatures() {
    }

    public long getId() {
        return id;
    }

    public SpecialFeatures setId(long id) {
        this.id = id;
        return this;
    }

    public SpecialFeaturesEnum getFeature() {
        return feature;
    }

    public SpecialFeatures setFeature(SpecialFeaturesEnum feature) {
        this.feature = feature;
        return this;
    }
}
