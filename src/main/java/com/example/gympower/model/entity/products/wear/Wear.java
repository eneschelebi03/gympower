package com.example.gympower.model.entity.products.wear;

import com.example.gympower.model.entity.products.Product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "wear")
public class Wear extends Product {

    private String fabric;

    @ManyToMany
    private Set<Color> availableColors;

    public Wear() {
    }

    public String getFabric() {
        return fabric;
    }

    public Wear setFabric(String fabric) {
        this.fabric = fabric;
        return this;
    }

    public Set<Color> getAvailableColors() {
        return availableColors;
    }

    public Wear setAvailableColors(Set<Color> availableColors) {
        this.availableColors = availableColors;
        return this;
    }
}
