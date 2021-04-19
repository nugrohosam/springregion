package com.nugrohosamiyono.springregion.Validations.Country;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = CountryValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CountryShouldbeExists {
    String message() default "Cannot Find Country";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}