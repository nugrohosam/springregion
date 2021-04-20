package com.nugrohosamiyono.springregion.Responses.District;

import com.nugrohosamiyono.springregion.Models.DistrictModel;
import com.nugrohosamiyono.springregion.Responses.City.CityItem;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DistrictDetail {
    public Integer id;
    public Integer cityid;
    public CityItem city;
    public String name;

    public DistrictDetail(DistrictModel districtModel) {
        this.id = districtModel.getId();
        this.cityid = districtModel.getCity().getId();
        this.name = districtModel.getName();
        this.city = (new CityItem(districtModel.getCity()));
    }
}
