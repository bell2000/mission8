package com.example.study.validation.annotation;

import jakarta.validation.Payload;

public @interface MissionStatusValid {

    String message() default "미션이 이미 진행중";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
