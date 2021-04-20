package com.nugrohosamiyono.springregion.Validations.State;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nugrohosamiyono.springregion.Applications.StateApplication;

import org.springframework.beans.factory.annotation.Autowired;

@Documented
@Constraint(validatedBy = StateValidatorShouldBeExists.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StateShouldBeExists {
    String message() default "Cannot Find State";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class StateValidatorShouldBeExists implements ConstraintValidator<StateShouldBeExists, Integer> {

    @Autowired
    StateApplication countryApplication;

    @Override
    public void initialize(StateShouldBeExists stateid) {
    }

    @Override
    public boolean isValid(Integer stateid, ConstraintValidatorContext context) {
        if (stateid == null) {
            return false;
        }

        return this.countryApplication.detailState(stateid).getId() != null;
    }
}