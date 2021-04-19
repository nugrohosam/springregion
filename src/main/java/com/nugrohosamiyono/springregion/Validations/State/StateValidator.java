package com.nugrohosamiyono.springregion.Validations.State;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nugrohosamiyono.springregion.Applications.StateApplication;

import org.springframework.beans.factory.annotation.Autowired;

public class StateValidator implements ConstraintValidator<StateShouldbeExists, Integer> {

  @Autowired
  StateApplication countryApplication;

  @Override
  public void initialize(StateShouldbeExists stateid) {
  }

  @Override
  public boolean isValid(Integer stateid, ConstraintValidatorContext context) {
    if (stateid == null){
      return false;
    }

    return this.countryApplication.detailState(stateid).getId() != null;
  }
}