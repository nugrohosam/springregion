package com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Serivces;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Models.RajaOngkir;
import com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Models.Province.RajaOngkirDetailProvince;
import com.nugrohosamiyono.springregion.ThirdParty.Rajaongkir.Models.Province.RajaOngkirListProvince;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProvinceService {

    @Value("${rajaogkir.api-key}")
    private String apiKey;

    @Value("${rajaogkir.url}")
    private String url;

    @Value("${rajaogkir.level}")
    private String level;

    public RajaOngkir getProvince() throws JsonParseException, IOException, InterruptedException {
        String endpoint = this.url + "/" + this.level + "/province";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint)).header("Accept", "application/json")
                .header("Key", this.apiKey).build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        JsonObject dataObject = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject dataRajaOngkirObject = dataObject.getAsJsonObject("rajaongkir");

        RajaOngkir rajaOngkir = new RajaOngkir(dataRajaOngkirObject);
        if (rajaOngkir.status.code == 200) {
            rajaOngkir = new RajaOngkirListProvince(dataRajaOngkirObject);
        }

        return rajaOngkir;
    }

    public RajaOngkir detailProvince(int id) throws JsonParseException, IOException, InterruptedException {
        String endpoint = this.url + "/" + this.level + "/province";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint)).build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        JsonObject dataObject = JsonParser.parseString(response.body()).getAsJsonObject();
        RajaOngkir rajaOngkir = new RajaOngkir(dataObject);

        if (rajaOngkir.status.code == 200) {
            rajaOngkir = new RajaOngkirDetailProvince(dataObject);
        }

        return rajaOngkir;
    }

}
