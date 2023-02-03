package com.example.gympower.model.entity;

import com.example.gympower.model.entity.products.Product;
import com.example.gympower.model.entity.products.supplements.Supplement;
import com.example.gympower.model.entity.products.wear.Wear;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table(name = "users")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String username;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String phoneNumber;

    @OneToOne
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRole> userRoles;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    @ManyToMany
    private List<Wear> cartWear;

    @ManyToMany
    private List<Supplement> cartSupp;

    @ManyToOne
    private Picture profilePhoto;

    public UserEntity() {
    }

    public long getId() {
        return id;
    }

    public UserEntity setId(long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public UserEntity setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Set<UserRole> getRoles() {
        return userRoles;
    }

    public UserEntity setRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public UserEntity setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public UserEntity setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

    public Picture getProfilePhoto() {
        return profilePhoto;
    }

    public UserEntity setProfilePhoto(Picture profilePhoto) {
        this.profilePhoto = profilePhoto;
        return this;
    }

    public List<Wear> getCartWear() {
        return cartWear;
    }

    public UserEntity setCartWear(List<Wear> cartWear) {
        this.cartWear = cartWear;
        return this;
    }

    public List<Supplement> getCartSupp() {
        return cartSupp;
    }

    public UserEntity setCartSupp(List<Supplement> cartSupp) {
        this.cartSupp = cartSupp;
        return this;
    }
}
