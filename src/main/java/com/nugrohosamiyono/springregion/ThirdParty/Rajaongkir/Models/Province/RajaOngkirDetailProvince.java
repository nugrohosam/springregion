package com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Models.Province;

import com.google.gson.JsonObject;
import com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Models.RajaOngkir;

public class RajaOngkirDetailProvince extends RajaOngkir {
    public RajaOngkirProvince data;

    public RajaOngkirDetailProvince(JsonObject dataObject) {
        super(dataObject);
        this.data = new RajaOngkirProvince(dataObject);
    }
}
