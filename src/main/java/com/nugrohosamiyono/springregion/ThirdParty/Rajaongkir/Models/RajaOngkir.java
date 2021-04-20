package com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class RajaOngkir {
    public Status status;
    public List<Query> query;

    public RajaOngkir() {
    }

    public RajaOngkir(JsonObject mapObject) {
        this.status = (new Status(mapObject.getAsJsonObject("status")));
        if (mapObject.isJsonArray()) {
            this.query = new ArrayList<>();
            JsonArray queryArray = mapObject.getAsJsonArray("query");
            Iterator<JsonElement> itreate = queryArray.iterator();
            while (itreate.hasNext()) {
                JsonObject queryJson = itreate.next().getAsJsonObject();
                this.query.add(new Query(queryJson));
            }
        }
    }
}