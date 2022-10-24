package com.example.gympower.model.products.protein;

import com.example.gympower.model.products.Product;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

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




