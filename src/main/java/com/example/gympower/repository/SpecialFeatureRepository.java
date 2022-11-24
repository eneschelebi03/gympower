package com.example.gympower.repository;

import com.example.gympower.model.entity.products.supplements.SpecialFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialFeatureRepository extends JpaRepository<SpecialFeature, Long> {
}
