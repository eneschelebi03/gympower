package com.example.gympower.repository;

import com.example.gympower.model.entity.Analytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AnalyticsRepository extends JpaRepository<Analytics, Integer> {
    Optional<Analytics> findByCreatedAtAfter(LocalDateTime localDateTime);
}
