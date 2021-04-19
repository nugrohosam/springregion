package com.nugrohosamiyono.springregion.Requests.City;

import javax.validation.constraints.NotNull;

public class CityCreate {
    
    @NotNull
    public Integer stateid;
    
    @NotNull
    public String name;
}
