package com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Models.Province;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Models.RajaOngkir;

public class RajaOngkirListProvince extends RajaOngkir {
    public List<RajaOngkirProvince> listData;

    public RajaOngkirListProvince(JsonObject dataObject) {
        super(dataObject);
        this.listData = new ArrayList<>();
        JsonArray results = dataObject.getAsJsonArray("results");
        this.listData = RajaOngkirProvince.toMap(results);
    }
}
