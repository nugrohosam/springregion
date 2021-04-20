package com.nugrohosamiyono.springregion.Responses.Village;

import com.nugrohosamiyono.springregion.Models.VillageModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class VillageItem {

    public Integer id;
    public String name;
    public Integer countyid;

    public VillageItem(VillageModel villageModel) {
        this.id = villageModel.getId();
        this.name = villageModel.getName();
        this.countyid = villageModel.getDistrict().getId();
    }

    public static List<Object> toMap(Iterable<VillageModel> villages) {
        List<Object> stateItems = new ArrayList<>();
        Iterator<VillageModel> villagesIterator = villages.iterator();
        while (villagesIterator.hasNext()) {
            VillageItem stateItem = new VillageItem(villagesIterator.next());
            stateItems.add(stateItem);
        }

        return stateItems;
    }
}
