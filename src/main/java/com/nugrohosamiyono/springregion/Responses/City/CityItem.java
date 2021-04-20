package com.nugrohosamiyono.springregion.Responses.City;

import com.nugrohosamiyono.springregion.Models.CityModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public static List<Object> toMap(Iterable<CityModel> cities) {
        List<Object> cityItems = new ArrayList<>();
        Iterator<CityModel> citiesIterator = cities.iterator();
        while (citiesIterator.hasNext()) {
            CityItem cityItem = new CityItem(citiesIterator.next());
            cityItems.add(cityItem);
        }

        return cityItems;
    }
}
