package com.example.gympower.model.entity.products;

import com.example.gympower.model.entity.Category;
import com.example.gympower.model.entity.Picture;

import javax.persistence.*;
import java.time.LocalDate;
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

//    @Column(nullable = false)
    private LocalDate startDate;

//    @Column(nullable = false)
    private LocalDate endDate;


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

    public LocalDate getStartDate() {
        return startDate;
    }

    public ExclusiveOffer setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ExclusiveOffer setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }
}

