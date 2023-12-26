package com.example.study.validation.validator;

import com.example.study.domain.enums.MissionStatus;
import com.example.study.validation.annotation.MissionStatusValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MissionStatusValidator implements ConstraintValidator<MissionStatusValid, Long> {

    @Override
    public void initialize(MissionStatusValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        // 미션 상태가 null이면 유효
        return value == null;
    }
}

