package com.example.gympower.model.entity.products.supplements;

import com.example.gympower.model.entity.Picture;
import com.example.gympower.model.entity.enums.FlavorEnum;

import javax.persistence.*;
import java.util.Set;

@Table(name = "flavors")
@Entity
public class Flavor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FlavorEnum flavor;


    @ManyToMany
    private Set<Picture> pictures;

    @ManyToMany
    private Set<Cut> cuts;

    private boolean isAvailable;

    public long getId() {
        return id;
    }

    public Flavor setId(long id) {
        this.id = id;
        return this;
    }

    public FlavorEnum getFlavor() {
        return flavor;
    }

    public Flavor setFlavor(FlavorEnum flavor) {
        this.flavor = flavor;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public Flavor setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public Set<Cut> getCuts() {
        return cuts;
    }

    public Flavor setCuts(Set<Cut> cuts) {
        this.cuts = cuts;
        return this;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Flavor setAvailable(boolean available) {
        isAvailable = available;
        return this;
    }
}
