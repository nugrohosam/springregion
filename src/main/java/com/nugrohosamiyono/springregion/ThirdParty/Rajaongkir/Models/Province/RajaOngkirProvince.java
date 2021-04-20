package com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Models.Province;

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
}
