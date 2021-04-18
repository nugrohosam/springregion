package com.nugrohosamiyono.springregion.Responses.City;

import com.nugrohosamiyono.springregion.Models.CityModel;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CityItem {
    public Integer id;
    public String name;
    public Integer stateid;

    public CityItem(CityModel cityModel) {
        this.id = cityModel.getId();
        this.name = cityModel.getName();
        this.stateid = cityModel.getState().getId();
    }
}
