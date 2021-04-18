package com.nugrohosamiyono.springregion.Responses.District;

import com.nugrohosamiyono.springregion.Models.DistrictModel;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DistrictItem {

    public Integer id;
    public String name;
    public Integer cityid;

    public DistrictItem(DistrictModel districtModel) {
        this.id = districtModel.getId();
        this.name = districtModel.getName();
        this.cityid = districtModel.getCity().getId();
    }
}
