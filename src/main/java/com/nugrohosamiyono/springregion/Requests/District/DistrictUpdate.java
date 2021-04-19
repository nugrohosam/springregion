package com.nugrohosamiyono.springregion.Requests.District;

import javax.validation.constraints.NotNull;

public class DistrictUpdate {
    
    @NotNull
    public Integer cityid;
    
    @NotNull
    public String name;
}
