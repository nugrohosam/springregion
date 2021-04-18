package com.nugrohosamiyono.springregion.Responses.State;

import com.nugrohosamiyono.springregion.Models.StateModel;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StateItem {

    public Integer id;
    public String name;
    public Integer countyid;

    public StateItem(StateModel stateModel) {
        this.id = stateModel.getId();
        this.name = stateModel.getName();
        this.countyid = stateModel.getCountry().getId();
    }
}
