package com.example.gympower.model.entity.products.wear;

import com.example.gympower.model.entity.enums.WearSizeEnum;

import javax.persistence.*;

@Table(name = "sizes")
@Entity
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private WearSizeEnum size;

    private int itemsProduced;

    public long getId() {
        return id;
    }

    public Size setId(long id) {
        this.id = id;
        return this;
    }

    public WearSizeEnum getSize() {
        return size;
    }

    public Size setSize(WearSizeEnum size) {
        this.size = size;
        return this;
    }

    public int getItemsProduced() {
        return itemsProduced;
    }

    public Size setItemsProduced(int itemsProduced) {
        this.itemsProduced = itemsProduced;
        return this;
    }
}
