package com.nugrohosamiyono.springregion.Validations.Country;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nugrohosamiyono.springregion.Applications.CountryApplication;

import org.springframework.beans.factory.annotation.Autowired;

public class CountryValidator implements ConstraintValidator<CountryShouldbeExists, Integer> {

  @Autowired
  CountryApplication countryApplication;

  @Override
  public void initialize(CountryShouldbeExists countryid) {
  }

  @Override
  public boolean isValid(Integer countryid, ConstraintValidatorContext context) {
    return this.countryApplication.detailCountry(countryid).getId() != null;
  }
}