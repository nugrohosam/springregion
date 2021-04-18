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

    public DistrictDetail(DistrictModel stateModel) {
        this.id = stateModel.getId();
        this.cityid = stateModel.getCity().getId();
        this.name = stateModel.getName();
        this.city = (new CityItem(stateModel.getCity()));
    }
}
