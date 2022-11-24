package com.example.gympower.model.entity.products.supplements;

import com.example.gympower.model.entity.products.Product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "supplement")
public class Supplement extends Product {

    @ManyToMany
    private Set<Flavor> flavor;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<SpecialFeature> specialFeatures;

    public Set<SpecialFeature> getSpecialFeatures() {
        return specialFeatures;
    }

    public Supplement setSpecialFeatures(Set<SpecialFeature> specialFeatures) {
        this.specialFeatures = specialFeatures;
        return this;
    }

    public Set<Flavor> getFlavor() {
        return flavor;
    }

    public Supplement setFlavor(Set<Flavor> flavor) {
        this.flavor = flavor;
        return this;
    }
}




