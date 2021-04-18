package com.nugrohosamiyono.springregion.Responses.City;

import com.nugrohosamiyono.springregion.Models.CityModel;
import com.nugrohosamiyono.springregion.Responses.State.StateItem;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CityDetail {
    public Integer id;
    public Integer stateid;
    public StateItem state;
    public String name;

    public CityDetail(CityModel cityModel) {
        this.id = cityModel.getId();
        this.name = cityModel.getName();
        this.stateid = cityModel.getState().getId();
        this.state = (new StateItem(cityModel.getState()));
    }
}
