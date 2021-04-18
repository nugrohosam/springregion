package com.nugrohosamiyono.springregion.Responses.State;

import com.nugrohosamiyono.springregion.Models.StateModel;
import com.nugrohosamiyono.springregion.Responses.Country.CountryItem;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StateDetail {
    public Integer id;
    public Integer countryid;
    public CountryItem country;
    public String name;

    public StateDetail(StateModel stateModel) {
        this.id = stateModel.getId();
        this.name = stateModel.getName();
        this.country = (new CountryItem(stateModel.getCountry()));
    }
}
