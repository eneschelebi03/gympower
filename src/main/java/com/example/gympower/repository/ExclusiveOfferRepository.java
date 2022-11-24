package com.example.gympower.repository;

import com.example.gympower.model.entity.products.ExclusiveOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExclusiveOfferRepository extends JpaRepository<ExclusiveOffer, Long> {

    List<ExclusiveOffer> findAllByIsActive (boolean isActive);

}
