package com.nugrohosamiyono.springregion.Validations.City;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = CityValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CityShouldbeExists {
    String message() default "Cannot Find City";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}