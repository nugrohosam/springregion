package com.nugrohosamiyono.springregion.Responses.Village;

import com.nugrohosamiyono.springregion.Models.VillageModel;
import com.nugrohosamiyono.springregion.Responses.District.DistrictItem;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class VillageDetail {
    public Integer id;
    public Integer districtid;
    public DistrictItem district;
    public String name;

    public VillageDetail(VillageModel villageModel) {
        this.id = villageModel.getId();
        this.name = villageModel.getName();
        this.district = (new DistrictItem(villageModel.getDistrict()));
    }
}
