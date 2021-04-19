package com.nugrohosamiyono.springregion.Requests.Village;

import javax.validation.constraints.NotNull;

public class VillageUpdate {
    
    @NotNull
    public Integer districtid;
    
    @NotNull
    public String name;
}
