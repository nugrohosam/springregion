package com.nugrohosamiyono.springregion.Controllers;

import com.nugrohosamiyono.springregion.Applications.CountryApplication;
import com.nugrohosamiyono.springregion.Models.CountryModel;
import com.nugrohosamiyono.springregion.Requests.Country.CountryCreate;
import com.nugrohosamiyono.springregion.Requests.Country.CountryUpdate;

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
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryApplication countryApplication;

    @GetMapping("")
    public Iterable<CountryModel> index() {
        return this.countryApplication.getCountryFromAPI();
    }

    @GetMapping("/{id}")
    public CountryModel show(@PathVariable Integer id) {
        return this.countryApplication.detailCountry(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody CountryUpdate countryUpdate) {
        this.countryApplication.updateCountryFromAPI(id, countryUpdate);
        return "detail of country";
    }

    @PostMapping("")
    public String store(@RequestBody CountryCreate countryCreate) {
        this.countryApplication.createCountryFromAPI(countryCreate);
        return "detail of country";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        this.countryApplication.deleteCountryFromAPI(id);
        return "delete of country";
    }
}