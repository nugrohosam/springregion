package com.nugrohosamiyono.springregion.Requests.City;

import javax.validation.constraints.NotNull;

import com.nugrohosamiyono.springregion.Validations.State.StateShouldbeExists;

public class CityUpdate {
    
    @NotNull
    @StateShouldbeExists
    public Integer stateid;
    
    @NotNull
    public String name;
}
