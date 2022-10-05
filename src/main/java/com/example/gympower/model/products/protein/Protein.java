package com.example.gympower.model.products.protein;

import com.example.gympower.model.products.Product;

import javax.persistence.*;
import java.util.Set;

@Table(name = "proteins")
@Entity
public class Protein extends Product {

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Cut> cuts;

    @OneToOne
    private Flavor flavor;

    @OneToMany
    private Set<SpecialFeatures> specialFeatures;

    public Protein() {
    }

    public Set<Cut> getCuts() {
        return cuts;
    }

    public Protein setCuts(Set<Cut> cuts) {
        this.cuts = cuts;
        return this;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public Protein setFlavor(Flavor flavor) {
        this.flavor = flavor;
        return this;
    }

    public Set<SpecialFeatures> getSpecialFeatures() {
        return specialFeatures;
    }

    public Protein setSpecialFeatures(Set<SpecialFeatures> specialFeatures) {
        this.specialFeatures = specialFeatures;
        return this;
    }
}




