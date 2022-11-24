package com.example.gympower.repository;

import com.example.gympower.model.entity.products.wear.Wear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WearRepository extends JpaRepository<Wear, Long> {
    Wear findTopByOrderByRatingDesc();
}
