package com.nugrohosamiyono.springregion.Requests.City;

import javax.validation.constraints.NotNull;

import com.nugrohosamiyono.springregion.Validations.State.StateShouldBeExists;

public class CityUpdate {
    
    @NotNull
    @StateShouldBeExists
    public Integer stateid;
    
    @NotNull
    public String name;
}
