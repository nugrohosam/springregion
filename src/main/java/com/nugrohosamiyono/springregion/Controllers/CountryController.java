package com.nugrohosamiyono.springregion.Controllers;

import javax.validation.Valid;

import com.nugrohosamiyono.springregion.Applications.CountryApplication;
import com.nugrohosamiyono.springregion.Exceptions.ValidationException;
import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Models.CountryModel;
import com.nugrohosamiyono.springregion.Requests.Country.CountryCreate;
import com.nugrohosamiyono.springregion.Requests.Country.CountryUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
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
    public String update(@PathVariable Integer id, @Valid @RequestBody CountryUpdate countryUpdate, Errors errors)
            throws ValidationException {
        Base.validationCheck(errors);
        this.countryApplication.updateCountryFromAPI(id, countryUpdate);
        return "detail of country";
    }

    @PostMapping("")
    public String store(@Valid @RequestBody CountryCreate countryCreate, Errors errors) throws ValidationException {
        Base.validationCheck(errors);
        this.countryApplication.createCountryFromAPI(countryCreate);
        return "detail of country";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        this.countryApplication.deleteCountryFromAPI(id);
        return "delete of country";
    }
}