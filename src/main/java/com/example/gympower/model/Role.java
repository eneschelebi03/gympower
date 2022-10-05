package com.example.gympower.model;

import com.example.gympower.model.enums.UserRoles;

import javax.persistence.*;

@Entity
@Table(name = "")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoles roles;

    public Role() {
    }

    public long getId() {
        return id;
    }

    public Role setId(long id) {
        this.id = id;
        return this;
    }

    public UserRoles getRoles() {
        return roles;
    }

    public Role setRoles(UserRoles roles) {
        this.roles = roles;
        return this;
    }
}
