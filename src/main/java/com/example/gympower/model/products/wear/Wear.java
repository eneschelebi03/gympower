package com.example.gympower.model.products.wear;

import com.example.gympower.model.products.Product;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "wear")
public class Wear extends Product {

    private int size;

    @OneToMany
    private Set<Fabric> fabrics;

    @OneToMany
    private Set<Color> colors;

    public Wear() {
    }

    public int getSize() {
        return size;
    }

    public Wear setSize(int size) {
        this.size = size;
        return this;
    }

    public Set<Fabric> getFabrics() {
        return fabrics;
    }

    public Wear setFabrics(Set<Fabric> fabrics) {
        this.fabrics = fabrics;
        return this;
    }

    public Set<Color> getColors() {
        return colors;
    }

    public Wear setColors(Set<Color> colors) {
        this.colors = colors;
        return this;
    }
}
