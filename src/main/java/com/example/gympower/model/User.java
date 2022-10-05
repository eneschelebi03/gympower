package com.example.gympower.model;

import javax.persistence.*;
import javax.swing.plaf.metal.MetalIconFactory;
import java.util.Set;

@Table(name = "users")
@Entity
public class User {

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

    @OneToMany
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new java.util.LinkedHashSet<>();

    @OneToOne
    private Card card;

    @OneToOne
    private Paypal paypal;

    private Picture profilePhoto;

    public User() {
    }

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public User setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public User setOrders(Set<Order> orders) {
        this.orders = orders;
        return this;
    }

    public Card getCard() {
        return card;
    }

    public User setCard(Card card) {
        this.card = card;
        return this;
    }

    public Paypal getPaypal() {
        return paypal;
    }

    public User setPaypal(Paypal paypal) {
        this.paypal = paypal;
        return this;
    }

    public Picture getProfilePhoto() {
        return profilePhoto;
    }

    public User setProfilePhoto(Picture profilePhoto) {
        this.profilePhoto = profilePhoto;
        return this;
    }
}
