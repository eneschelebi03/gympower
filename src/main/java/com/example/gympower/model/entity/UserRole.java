package com.example.gympower.model.entity;

import com.example.gympower.model.entity.enums.UserRolesEnum;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRolesEnum role;



    public long getId() {
        return id;
    }

    public UserRole setId(long id) {
        this.id = id;
        return this;
    }

    public UserRolesEnum getRole() {
        return role;
    }

    public UserRole setRole(UserRolesEnum role) {
        this.role = role;
        return this;
    }
}
