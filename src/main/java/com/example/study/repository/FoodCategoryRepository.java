package com.example.study.repository;

import com.example.study.domain.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {

}
