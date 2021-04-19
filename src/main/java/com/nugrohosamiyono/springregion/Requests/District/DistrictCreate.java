package com.nugrohosamiyono.springregion.Requests.District;

import com.nugrohosamiyono.springregion.Validations.City.CityShouldbeExists;

import org.springframework.lang.NonNull;

public class DistrictCreate {
    
    @NonNull
    @CityShouldbeExists
    public Integer cityid;
    
    @NonNull
    public String name;
}
