package com.nugrohosamiyono.springregion.Responses.District;

import com.nugrohosamiyono.springregion.Models.DistrictModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public static List<Object> toMap(Iterable<DistrictModel> districts) {
        List<Object> districtItems = new ArrayList<>();
        Iterator<DistrictModel> districtsIterator = districts.iterator();
        while (districtsIterator.hasNext()) {
            DistrictItem districtItem = new DistrictItem(districtsIterator.next());
            districtItems.add(districtItem);
        }

        return districtItems;
    }
}
