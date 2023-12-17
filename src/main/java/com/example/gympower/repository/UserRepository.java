package com.example.gympower.repository;

import com.example.gympower.model.entity.UserEntity;
import com.example.gympower.service.AppUserDetailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByEmailOrUsername(String username, String email);

    int countAllByRegisteredAtAfter(LocalDateTime dateTime);
}
