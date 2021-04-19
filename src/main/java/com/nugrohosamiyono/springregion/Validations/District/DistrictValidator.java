package com.nugrohosamiyono.springregion.Validations.District;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nugrohosamiyono.springregion.Applications.DistrictApplication;

import org.springframework.beans.factory.annotation.Autowired;

public class DistrictValidator implements ConstraintValidator<DistrictShouldbeExists, Integer> {

  @Autowired
  DistrictApplication countryApplication;

  @Override
  public void initialize(DistrictShouldbeExists districtid) {
  }

  @Override
  public boolean isValid(Integer districtid, ConstraintValidatorContext context) {
    if (districtid == null) {
      return false;
    }

    return this.countryApplication.detailDistrict(districtid).getId() != null;
  }
}