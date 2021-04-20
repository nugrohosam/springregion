package com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Models;

import com.google.gson.JsonObject;

public class Status {
    public int code;
    public String description;

    public Status(JsonObject object){
        this.code = object.get("code").getAsInt();
        this.description = object.get("description").getAsString();
    }
}
