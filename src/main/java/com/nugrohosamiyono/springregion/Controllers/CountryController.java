package com.nugrohosamiyono.springregion.Controllers;

import com.nugrohosamiyono.springregion.Requests.Country.CountryCreate;
import com.nugrohosamiyono.springregion.Requests.Country.CountryUpdate;
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

    @GetMapping("")
    public String index() {
        return "list of country";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id) {
        return "detail of country";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody CountryUpdate countryUpdate) {
        return "detail of country";
    }

    @PostMapping("")
    public String store(@RequestBody CountryCreate countryCrate) {
        return "detail of country";
    }

    @DeleteMapping("")
    public String store(@PathVariable Integer id) {
        return "delete of country";
    }
}