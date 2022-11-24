package com.example.gympower.repository;

import com.example.gympower.model.entity.products.supplements.Cut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CutRepository extends JpaRepository<Cut, Long> {
}
