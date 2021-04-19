package com.nugrohosamiyono.springregion.Requests.Village;

import javax.validation.constraints.NotNull;

import com.nugrohosamiyono.springregion.Validations.District.DistrictShouldbeExists;

public class VillageCreate {

    @NotNull
    @DistrictShouldbeExists
    public Integer districtid;

    @NotNull
    public String name;
}
