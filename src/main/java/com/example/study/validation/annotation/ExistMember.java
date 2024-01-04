package com.example.study.validation.annotation;



import com.example.study.validation.validator.MemberExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberExistsValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMember {
    String message() default "해당 사용자가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}