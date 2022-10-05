package com.example.gympower.model;

import com.example.gympower.model.products.Product;

import javax.persistence.*;

@Table(name = "pictures")
@Entity
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String url;

    @ManyToOne
    private Product product;

    public Picture() {
    }

    public long getId() {
        return id;
    }

    public Picture setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Picture setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Picture setUrl(String url) {
        this.url = url;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public Picture setProduct(Product product) {
        this.product = product;
        return this;
    }
}
