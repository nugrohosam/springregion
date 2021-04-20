package com.nugrohosamiyono.springregion.Requests.Village;

import javax.validation.constraints.NotNull;

import com.nugrohosamiyono.springregion.Validations.District.DistrictShouldBeExists;

public class VillageCreate {

    @NotNull
    @DistrictShouldBeExists
    public Integer districtid;

    @NotNull
    public String name;
}
