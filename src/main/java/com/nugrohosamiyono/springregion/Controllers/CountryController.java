package com.nugrohosamiyono.springregion.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.nugrohosamiyono.springregion.Applications.CountryApplication;
import com.nugrohosamiyono.springregion.Exceptions.ValidationException;
import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Helpers.Response;
import com.nugrohosamiyono.springregion.Models.CountryModel;
import com.nugrohosamiyono.springregion.Requests.QueryParams;
import com.nugrohosamiyono.springregion.Requests.Country.CountryCreate;
import com.nugrohosamiyono.springregion.Requests.Country.CountryUpdate;
import com.nugrohosamiyono.springregion.Responses.Pagination;
import com.nugrohosamiyono.springregion.Responses.Country.CountryDetail;
import com.nugrohosamiyono.springregion.Responses.Country.CountryItem;

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
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryApplication countryApplication;

    @GetMapping("")
    public Response index(QueryParams queryParams) {
        Iterable<CountryModel> countries;

        countries = this.countryApplication.getCountryFromAPI(queryParams);
        List<Object> response = CountryItem.toMap(countries);
        if (!queryParams.isPagination()) {
            return Base.responseList(response);
        }

        int total = IterableUtils.size(countries);
        Pagination pagination = new Pagination(queryParams.getPage(), queryParams.getPerPage(), total);
        return Base.responsePagination(response, pagination);
    }

    @GetMapping("/{id}")
    public Response show(@PathVariable Integer id) {
        CountryModel country = this.countryApplication.detailCountry(id);
        CountryDetail countryDetail = new CountryDetail(country);
        return Base.responseData(countryDetail);
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable Integer id, @Valid @RequestBody CountryUpdate countryUpdate, Errors errors)
            throws ValidationException {
        Base.validationCheck(errors);
        this.countryApplication.updateCountryFromAPI(id, countryUpdate);
        return Base.responseMessage("success update country");
    }

    @PostMapping("")
    public Response store(@Valid @RequestBody CountryCreate countryCreate, Errors errors) throws ValidationException {
        Base.validationCheck(errors);
        this.countryApplication.createCountryFromAPI(countryCreate);
        return Base.responseMessage("success update country");
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Integer id) {
        this.countryApplication.deleteCountryFromAPI(id);
        return Base.responseMessage("delete update country");
    }
}