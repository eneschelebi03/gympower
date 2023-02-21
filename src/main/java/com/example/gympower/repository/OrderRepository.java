package com.example.gympower.repository;

import com.example.gympower.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCreatedAtAfter(LocalDateTime date);

    List<Order> findFirst7ByOrderByCreatedAtDesc(Pageable pageable);
}
