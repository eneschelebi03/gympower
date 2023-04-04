package com.example.gympower.model.entity.products.supplements;

import com.example.gympower.model.entity.products.Product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "supplements")
public class Supplement extends Product {

    @ManyToMany
    private Set<Flavor> flavors;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<SpecialFeature> specialFeatures;

    public Set<SpecialFeature> getSpecialFeatures() {
        return specialFeatures;
    }

    public Supplement setSpecialFeatures(Set<SpecialFeature> specialFeatures) {
        this.specialFeatures = specialFeatures;
        return this;
    }

    public Set<Flavor> getFlavors() {
        return flavors;
    }

    public Supplement setFlavors(Set<Flavor> flavors) {
        this.flavors = flavors;
        return this;
    }
}




