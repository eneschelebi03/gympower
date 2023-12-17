package com.example.gympower.repository;

import com.example.gympower.model.entity.products.supplements.Cut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface CutRepository extends JpaRepository<Cut, Long> {
    @Query(value = "SELECT * FROM cuts ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Cut> findRandomCuts(@Param("limit") int limit);

    List<Cut> findByDiscountNot(int discount);
}
