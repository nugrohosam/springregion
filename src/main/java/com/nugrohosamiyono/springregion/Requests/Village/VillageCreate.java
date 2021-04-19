package com.nugrohosamiyono.springregion.Requests.Village;

import javax.validation.constraints.NotNull;

public class VillageCreate {
    
    @NotNull
    public Integer districtid;
    
    @NotNull
    public String name;
}
