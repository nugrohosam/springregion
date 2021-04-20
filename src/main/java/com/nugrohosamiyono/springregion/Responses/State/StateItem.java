package com.nugrohosamiyono.springregion.Responses.State;

import com.nugrohosamiyono.springregion.Models.StateModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public static List<Object> toMap(Iterable<StateModel> states) {
        List<Object> stateItems = new ArrayList<>();
        Iterator<StateModel> statesIterator = states.iterator();
        while (statesIterator.hasNext()) {
            StateItem stateItem = new StateItem(statesIterator.next());
            stateItems.add(stateItem);
        }

        return stateItems;
    }
}
