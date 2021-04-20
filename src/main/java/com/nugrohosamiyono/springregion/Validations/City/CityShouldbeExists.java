package com.nugrohosamiyono.springregion.Validations.City;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.nugrohosamiyono.springregion.Applications.CityApplication;

import org.springframework.beans.factory.annotation.Autowired;

@Documented
@Constraint(validatedBy = CityValidatorShouldBeExists.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CityShouldBeExists {
    String message()

    default "Cannot Find City";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class CityValidatorShouldBeExists implements ConstraintValidator<CityShouldBeExists, Integer> {

    @Autowired
    CityApplication countryApplication;

    @Override
    public void initialize(CityShouldBeExists cityid) {
    }

    @Override
    public boolean isValid(Integer cityid, ConstraintValidatorContext context) {
        if (cityid == null) {
            return false;
        }
        return this.countryApplication.detailCity(cityid).getId() != null;
    }
}