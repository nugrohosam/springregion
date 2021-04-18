package com.nugrohosamiyono.springregion.Responses.Village;

import com.nugrohosamiyono.springregion.Models.VillageModel;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class VIllageItem {

    public Integer id;
    public String name;
    public Integer countyid;

    public VIllageItem(VillageModel villageModel) {
        this.id = villageModel.getId();
        this.name = villageModel.getName();
        this.countyid = villageModel.getDistrict().getId();
    }
}
