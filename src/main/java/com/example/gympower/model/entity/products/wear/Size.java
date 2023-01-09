package com.example.gympower.model.entity.products.wear;

import javax.persistence.*;

@Table(name = "sizes")
@Entity
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int itemsProduced;

    private boolean isActive;

    public long getId() {
        return id;
    }

    public Size setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Size setName(String name) {
        this.name = name;
        return this;
    }

    public int getItemsProduced() {
        return itemsProduced;
    }

    public Size setItemsProduced(int itemsProduced) {
        this.itemsProduced = itemsProduced;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public Size setActive(boolean active) {
        isActive = active;
        return this;
    }
}
