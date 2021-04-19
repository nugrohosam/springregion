package com.nugrohosamiyono.springregion.Requests.State;

import javax.validation.constraints.NotNull;

public class StateUpdate {
    
    @NotNull
    public Integer countryid;
    
    @NotNull
    public String name;
}
