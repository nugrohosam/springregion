package com.nugrohosamiyono.springregion.Controllers;

import javax.validation.Valid;

import com.nugrohosamiyono.springregion.Applications.CityApplication;
import com.nugrohosamiyono.springregion.Exceptions.ValidationException;
import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Helpers.Response;
import com.nugrohosamiyono.springregion.Helpers.ResponseData;
import com.nugrohosamiyono.springregion.Helpers.ResponseMessage;
import com.nugrohosamiyono.springregion.Models.CityModel;
import com.nugrohosamiyono.springregion.Requests.QueryParams;
import com.nugrohosamiyono.springregion.Requests.City.CityCreate;
import com.nugrohosamiyono.springregion.Requests.City.CityUpdate;
import com.nugrohosamiyono.springregion.Responses.City.CityDetail;

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
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityApplication cityApplication;

    @GetMapping("")
    public Response index(QueryParams queryParams) {
        Iterable<CityModel> cities = this.cityApplication.getCityFromAPI();
        return (new ResponseData(cities));
    }

    @GetMapping("/{id}")
    public Response show(@PathVariable Integer id) {
        CityModel city = this.cityApplication.detailCity(id);

        CityDetail response = new CityDetail(city);
        return (new ResponseData(response));
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable Integer id, @Valid @RequestBody CityUpdate cityUpdate, Errors errors)
            throws ValidationException {
        Base.validationCheck(errors);

        this.cityApplication.updateCityFromAPI(id, cityUpdate);
        return (new ResponseMessage("updated city"));
    }

    @PostMapping("")
    public Response store(@Valid @RequestBody CityCreate cityCreate, Errors errors) throws ValidationException {
        Base.validationCheck(errors);

        this.cityApplication.createCityFromAPI(cityCreate);
        return (new ResponseMessage("stored city"));
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Integer id) {
        this.cityApplication.deleteCityFromAPI(id);
        return (new ResponseMessage("delete of city"));
    }
}