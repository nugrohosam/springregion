package com.nugrohosamiyono.springregion.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.nugrohosamiyono.springregion.Applications.CityApplication;
import com.nugrohosamiyono.springregion.Exceptions.ValidationException;
import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Helpers.Responses.Response;
import com.nugrohosamiyono.springregion.Helpers.Responses.ResponseMessage;
import com.nugrohosamiyono.springregion.Models.CityModel;
import com.nugrohosamiyono.springregion.Requests.QueryParams;
import com.nugrohosamiyono.springregion.Requests.City.CityCreate;
import com.nugrohosamiyono.springregion.Requests.City.CityUpdate;
import com.nugrohosamiyono.springregion.Responses.Pagination;
import com.nugrohosamiyono.springregion.Responses.City.CityDetail;
import com.nugrohosamiyono.springregion.Responses.City.CityItem;

import org.apache.commons.collections4.IterableUtils;
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
        Iterable<CityModel> cities;

        cities = this.cityApplication.getCityFromAPI(queryParams);
        List<Object> response = CityItem.toMap(cities);
        if (!queryParams.isPagination()) {
            return Base.responseList(response);
        }

        int total = IterableUtils.size(cities);
        Pagination pagination = new Pagination(queryParams.getPage(), queryParams.getPerPage(), total);
        return Base.responsePagination(response, pagination);
    }

    @GetMapping("/{id}")
    public Response show(@PathVariable Integer id) {
        CityModel city = this.cityApplication.detailCity(id);
        if (city == null) {
            return Base.responseData(null);
        }
        
        CityDetail response = new CityDetail(city);
        return Base.responseData(response);
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable Integer id, @Valid @RequestBody CityUpdate cityUpdate, Errors errors)
            throws ValidationException {
        Base.validationCheck(errors);

        this.cityApplication.updateCityFromAPI(id, cityUpdate);
        return Base.responseMessage("updated city");
    }

    @PostMapping("")
    public Response store(@Valid @RequestBody CityCreate cityCreate, Errors errors) throws ValidationException {
        Base.validationCheck(errors);

        this.cityApplication.createCityFromAPI(cityCreate);
        return Base.responseMessage("stored city");
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Integer id) {
        this.cityApplication.deleteCityFromAPI(id);
        return (new ResponseMessage("delete of city"));
    }
}