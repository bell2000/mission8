package com.example.study.service;

import com.example.study.repository.FoodCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    public boolean existsById(Long categoryId) {
        return foodCategoryRepository.existsById(categoryId);
    }
}
