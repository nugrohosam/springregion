package com.nugrohosamiyono.springregion.Responses.Country;

import com.nugrohosamiyono.springregion.Models.CountryModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CountryItem {
    public Integer id;
    public String name;

    public CountryItem(CountryModel countryModel) {
        this.id = countryModel.getId();
        this.name = countryModel.getName();
    }

    public static List<Object> toMap(Iterable<CountryModel> countries) {
        List<Object> countryItems = new ArrayList<>();
        Iterator<CountryModel> countriesIterator = countries.iterator();
        while (countriesIterator.hasNext()) {
            CountryItem countryItem = new CountryItem(countriesIterator.next());
            countryItems.add(countryItem);
        }

        return countryItems;
    }
}
