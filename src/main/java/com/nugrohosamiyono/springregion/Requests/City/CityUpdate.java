package com.nugrohosamiyono.springregion.Requests.City;

import javax.validation.constraints.NotNull;

public class CityUpdate {
    
    @NotNull
    public Integer stateid;
    
    @NotNull
    public String name;
}
