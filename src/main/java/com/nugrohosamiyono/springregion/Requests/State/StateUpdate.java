package com.nugrohosamiyono.springregion.Requests.State;

import javax.validation.constraints.NotNull;

import com.nugrohosamiyono.springregion.Validations.Country.CountryShouldbeExists;

public class StateUpdate {
    
    @NotNull
    @CountryShouldbeExists
    public Integer countryid;
    
    @NotNull
    public String name;
}
