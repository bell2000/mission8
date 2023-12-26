package com.example.study.validation.validator;

import com.example.study.apiPayload.code.status.ErrorStatus;
import com.example.study.service.FoodCategoryService;
import com.example.study.service.RegionService;
import com.example.study.validation.annotation.ExistCategories;
import com.example.study.validation.annotation.ExistRegion;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RegionExistValidator implements ConstraintValidator<ExistRegion, Long> {

    private final RegionService regionService;

    @Override
    public void initialize(ExistRegion constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

//    @Override
    public boolean isValid(Long regionId, ConstraintValidatorContext context) {
        boolean isValid = regionService.existsById(regionId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}