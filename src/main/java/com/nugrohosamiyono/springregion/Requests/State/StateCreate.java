package com.nugrohosamiyono.springregion.Requests.State;

import javax.validation.constraints.NotNull;
import com.nugrohosamiyono.springregion.Validations.Country.CountryShouldBeExists;

public class StateCreate {

    @NotNull
    @CountryShouldBeExists
    public Integer countryid;

    @NotNull
    public String name;
}
