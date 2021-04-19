package com.nugrohosamiyono.springregion.Validations.City;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nugrohosamiyono.springregion.Applications.CityApplication;

import org.springframework.beans.factory.annotation.Autowired;

public class CityValidator implements ConstraintValidator<CityShouldbeExists, Integer> {

  @Autowired
  CityApplication countryApplication;

  @Override
  public void initialize(CityShouldbeExists countryid) {
  }

  @Override
  public boolean isValid(Integer countryid, ConstraintValidatorContext context) {
    return this.countryApplication.detailCity(countryid).getId() != null;
  }
}