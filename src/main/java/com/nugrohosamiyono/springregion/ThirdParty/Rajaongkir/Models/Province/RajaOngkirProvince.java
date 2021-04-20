package com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Models.Province;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class RajaOngkirProvince {
    public String provinceId;
    public String province;

    public RajaOngkirProvince() {
    }

    public RajaOngkirProvince(JsonObject data) {
        this.provinceId = data.get("province_id").toString();
        this.province = data.get("province").toString();
    }

    public static List<RajaOngkirProvince> toMap(JsonArray listDataJson) {
        Iterator<JsonElement> itreate = listDataJson.iterator();
        List<RajaOngkirProvince> listData = new ArrayList<>();

        while (itreate.hasNext()) {
            JsonObject jsonProvince = itreate.next().getAsJsonObject();
            RajaOngkirProvince province = new RajaOngkirProvince(jsonProvince);
            listData.add(province);
        }

        return listData;
    }
}
