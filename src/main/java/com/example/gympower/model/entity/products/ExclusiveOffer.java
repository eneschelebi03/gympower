package com.example.gympower.model.entity.products;

import com.example.gympower.model.entity.Category;
import com.example.gympower.model.entity.Picture;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Table(name = "exclusives")
@Entity
public class ExclusiveOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @OneToOne
    private Picture exclusivePicture;

    private int discountPercent;

    @ManyToMany
    private Set<Category> discountedCategories;

    private boolean isActive;

    @Column(nullable = false)
    private LocalDateTime start;

    @Column(nullable = false)
    private LocalDateTime end;


    public long getId() {
        return id;
    }

    public ExclusiveOffer setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ExclusiveOffer setTitle(String title) {
        this.title = title;
        return this;
    }

    public Picture getExclusivePicture() {
        return exclusivePicture;
    }

    public ExclusiveOffer setExclusivePicture(Picture exclusivePicture) {
        this.exclusivePicture = exclusivePicture;
        return this;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public ExclusiveOffer setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
        return this;
    }

    public Set<Category> getDiscountedCategories() {
        return discountedCategories;
    }

    public ExclusiveOffer setDiscountedCategories(Set<Category> discountedCategories) {
        this.discountedCategories = discountedCategories;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public ExclusiveOffer setActive(boolean active) {
        isActive = active;
        return this;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public ExclusiveOffer setStart(LocalDateTime start) {
        this.start = start;
        return this;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public ExclusiveOffer setEnd(LocalDateTime end) {
        this.end = end;
        return this;
    }
}

