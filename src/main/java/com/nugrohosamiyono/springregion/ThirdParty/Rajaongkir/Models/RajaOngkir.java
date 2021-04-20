package com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Models;

import com.google.gson.JsonObject;

public class RajaOngkir {
    public Status status;
    public Query query;

    public RajaOngkir() {
    }

    public RajaOngkir(JsonObject mapObject) {
        this.status = (new Status(mapObject.getAsJsonObject("status")));
        this.query = (new Query(mapObject.getAsJsonObject("query")));
    }
}