package com.example.gympower.model.products;

import com.example.gympower.model.products.protein.SpecialFeatures;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "protein_bars")
@Entity
public class ProteinBar extends Product {

    @ManyToOne
    private BarCut barCut;

    @ManyToOne
    private BarFlavor barFlavor;

    @ManyToMany
    private Set<SpecialFeatures> specialFeatures;

    public BarCut getBarCut() {
        return barCut;
    }

    public ProteinBar setBarCut(BarCut barCut) {
        this.barCut = barCut;
        return this;
    }

    public BarFlavor getBarFlavor() {
        return barFlavor;
    }

    public ProteinBar setBarFlavor(BarFlavor barFlavor) {
        this.barFlavor = barFlavor;
        return this;
    }

    public Set<SpecialFeatures> getSpecialFeatures() {
        return specialFeatures;
    }

    public ProteinBar setSpecialFeatures(Set<SpecialFeatures> specialFeatures) {
        this.specialFeatures = specialFeatures;
        return this;
    }
}
