package com.nugrohosamiyono.springregion.Requests.District;

import javax.validation.constraints.NotNull;

import com.nugrohosamiyono.springregion.Validations.City.CityShouldBeExists;

public class DistrictUpdate {
    
    @NotNull
    @CityShouldBeExists
    public Integer cityid;
    
    @NotNull
    public String name;
}
