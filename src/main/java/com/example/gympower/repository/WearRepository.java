package com.example.gympower.repository;

import com.example.gympower.model.entity.Category;
import com.example.gympower.model.entity.enums.ProductCategoriesEnum;
import com.example.gympower.model.entity.products.wear.Wear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WearRepository extends JpaRepository<Wear, Long> {
    List<Wear> findByRatingAfterOrderByRating(double rating);

    @Query(value = "select w.categories from Wear w where w.id = :id")
    List<Category> findCategoriesByWearId(long id);

    List<Wear> findTop4ByCategoriesCategory(ProductCategoriesEnum category);
}
