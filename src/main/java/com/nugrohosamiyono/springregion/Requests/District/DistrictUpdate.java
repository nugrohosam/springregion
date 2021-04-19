package com.nugrohosamiyono.springregion.Requests.District;

import javax.validation.constraints.NotNull;

import com.nugrohosamiyono.springregion.Validations.City.CityShouldbeExists;

public class DistrictUpdate {
    
    @NotNull
    @CityShouldbeExists
    public Integer cityid;
    
    @NotNull
    public String name;
}
