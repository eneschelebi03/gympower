package com.example.gympower.repository;

import com.example.gympower.model.entity.products.wear.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

    @Query(value = "SELECT * FROM colors ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Color> findRandomColors(@Param("limit") int limit);

    List<Color> findByDiscountNot(int discount);
}
