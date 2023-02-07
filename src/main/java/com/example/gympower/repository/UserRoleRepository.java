package com.example.gympower.repository;

import com.example.gympower.model.entity.UserRole;
import com.example.gympower.model.entity.enums.UserRolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRole(UserRolesEnum userRolesEnum);
}
