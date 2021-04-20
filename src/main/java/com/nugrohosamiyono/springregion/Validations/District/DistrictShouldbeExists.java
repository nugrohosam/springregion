package com.nugrohosamiyono.springregion.Validations.District;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nugrohosamiyono.springregion.Applications.DistrictApplication;

import org.springframework.beans.factory.annotation.Autowired;

@Documented
@Constraint(validatedBy = DistrictValidatorShouldBeExists.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DistrictShouldBeExists {
    String message() default "Cannot Find District";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class DistrictValidatorShouldBeExists implements ConstraintValidator<DistrictShouldBeExists, Integer> {

    @Autowired
    DistrictApplication countryApplication;

    @Override
    public void initialize(DistrictShouldBeExists districtid) {
    }

    @Override
    public boolean isValid(Integer districtid, ConstraintValidatorContext context) {
        if (districtid == null) {
            return false;
        }

        return this.countryApplication.detailDistrict(districtid).getId() != null;
    }
}