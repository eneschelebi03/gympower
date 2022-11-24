package com.example.gympower.model.entity;

import com.example.gympower.model.entity.enums.UserRolesEnum;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRolesEnum role;



    public long getId() {
        return id;
    }

    public Role setId(long id) {
        this.id = id;
        return this;
    }

    public UserRolesEnum getRole() {
        return role;
    }

    public Role setRole(UserRolesEnum role) {
        this.role = role;
        return this;
    }
}
