package com.example.gympower.repository;

import com.example.gympower.model.entity.products.supplements.Supplement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface SupplementRepository extends JpaRepository<Supplement, Long> {

    Supplement findTopByOrderByRatingDesc();

    List<Supplement> findByRatingAfterOrderByRating(double rating);
}
