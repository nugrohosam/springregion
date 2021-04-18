package com.nugrohosamiyono.springregion.Controllers;

import com.nugrohosamiyono.springregion.Applications.CityApplication;
import com.nugrohosamiyono.springregion.Models.CityModel;
import com.nugrohosamiyono.springregion.Requests.City.CityCreate;
import com.nugrohosamiyono.springregion.Requests.City.CityUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityApplication cityApplication;

    @GetMapping("")
    public Iterable<CityModel> index() {
        return this.cityApplication.getCityFromAPI();
    }

    @GetMapping("/{id}")
    public CityModel show(@PathVariable Integer id) {
        return this.cityApplication.detailCity(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody CityUpdate cityUpdate) {
        this.cityApplication.updateCityFromAPI(id, cityUpdate);
        return "updated city";
    }

    @PostMapping("")
    public String store(@RequestBody CityCreate cityCreate) {
        this.cityApplication.createCityFromAPI(cityCreate);
        return "stored city";
    }

    @DeleteMapping("")
    public String delete(@PathVariable Integer id) {
        this.cityApplication.deleteCityFromAPI(id);
        return "delete of city";
    }
}