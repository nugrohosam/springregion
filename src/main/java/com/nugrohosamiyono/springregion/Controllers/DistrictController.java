package com.nugrohosamiyono.springregion.Controllers;

import javax.validation.Valid;

import com.nugrohosamiyono.springregion.Applications.DistrictApplication;
import com.nugrohosamiyono.springregion.Exceptions.ValidationException;
import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Models.DistrictModel;
import com.nugrohosamiyono.springregion.Requests.District.DistrictCreate;
import com.nugrohosamiyono.springregion.Requests.District.DistrictUpdate;

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
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictApplication districtApplication;

    @GetMapping("")
    public Iterable<DistrictModel> index() {
        return this.districtApplication.getDistrictFromAPI();
    }

    @GetMapping("/{id}")
    public DistrictModel show(@PathVariable Integer id) {
        return this.districtApplication.detailDistrict(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @Valid @RequestBody DistrictUpdate districtUpdate, Errors errors)
            throws ValidationException {
        Base.validationCheck(errors);
        this.districtApplication.updateDistrictFromAPI(id, districtUpdate);
        return "detail of district";
    }

    @PostMapping("")
    public String store(@Valid @RequestBody DistrictCreate districtCreate, Errors errors) throws ValidationException {
        Base.validationCheck(errors);
        this.districtApplication.createDistrictFromAPI(districtCreate);
        return "detail of district";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        this.districtApplication.deleteDistrictFromAPI(id);
        return "delete of district";
    }
}
