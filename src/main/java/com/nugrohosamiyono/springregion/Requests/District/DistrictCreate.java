package com.nugrohosamiyono.springregion.Requests.District;

import com.nugrohosamiyono.springregion.Validations.City.CityShouldBeExists;

import org.springframework.lang.NonNull;

public class DistrictCreate {
    
    @NonNull
    @CityShouldBeExists
    public Integer cityid;
    
    @NonNull
    public String name;
}
