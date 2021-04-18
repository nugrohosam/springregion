package com.nugrohosamiyono.springregion.Controllers;

import com.nugrohosamiyono.springregion.Applications.DistrictApplication;
import com.nugrohosamiyono.springregion.Models.DistrictModel;
import com.nugrohosamiyono.springregion.Requests.District.DistrictCreate;
import com.nugrohosamiyono.springregion.Requests.District.DistrictUpdate;

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
    public String update(@PathVariable Integer id, @RequestBody DistrictUpdate districtUpdate) {
        this.districtApplication.updateDistrictFromAPI(id, districtUpdate);
        return "detail of district";
    }

    @PostMapping("")
    public String store(@RequestBody DistrictCreate districtCreate) {
        this.districtApplication.createDistrictFromAPI(districtCreate);
        return "detail of district";
    }

    @DeleteMapping("")
    public String delete(@PathVariable Integer id) {
        this.districtApplication.deleteDistrictFromAPI(id);
        return "delete of district";
    }
}
