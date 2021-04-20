package com.nugrohosamiyono.springregion.Validations.Country;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nugrohosamiyono.springregion.Applications.CountryApplication;

import org.springframework.beans.factory.annotation.Autowired;

@Documented
@Constraint(validatedBy = CountryValidatorShouldBeExists.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CountryShouldBeExists {
    String message() default "Cannot Find Country";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

class CountryValidatorShouldBeExists implements ConstraintValidator<CountryShouldBeExists, Integer> {

  @Autowired
  CountryApplication countryApplication;

  @Override
  public void initialize(CountryShouldBeExists countryid) {
  }

  @Override
  public boolean isValid(Integer countryid, ConstraintValidatorContext context) {
    if (countryid == null) {
      return false;
    }

    return this.countryApplication.detailCountry(countryid).getId() != null;
  }
}