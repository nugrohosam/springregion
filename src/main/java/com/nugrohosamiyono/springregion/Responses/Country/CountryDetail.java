package com.nugrohosamiyono.springregion.Responses.Country;

import com.nugrohosamiyono.springregion.Models.CountryModel;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CountryDetail {
    public Integer id;
    public String name;

    public CountryDetail(CountryModel countryModel){
        this.id = countryModel.getId();
        this.name = countryModel.getName();
    }
}
