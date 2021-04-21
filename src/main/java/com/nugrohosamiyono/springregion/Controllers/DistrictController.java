package com.nugrohosamiyono.springregion.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.nugrohosamiyono.springregion.Applications.DistrictApplication;
import com.nugrohosamiyono.springregion.Exceptions.ValidationException;
import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Helpers.Response;
import com.nugrohosamiyono.springregion.Models.DistrictModel;
import com.nugrohosamiyono.springregion.Requests.QueryParams;
import com.nugrohosamiyono.springregion.Requests.District.DistrictCreate;
import com.nugrohosamiyono.springregion.Requests.District.DistrictUpdate;
import com.nugrohosamiyono.springregion.Responses.Pagination;
import com.nugrohosamiyono.springregion.Responses.District.DistrictDetail;
import com.nugrohosamiyono.springregion.Responses.District.DistrictItem;

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
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictApplication districtApplication;

    @GetMapping("")
    public Response index(QueryParams queryParams) {
        Iterable<DistrictModel> districts;

        districts = this.districtApplication.getDistrictFromAPI(queryParams);
        List<Object> response = DistrictItem.toMap(districts);
        if (!queryParams.isPagination()) {
            return Base.responseList(response);
        }

        int total = IterableUtils.size(districts);
        Pagination pagination = new Pagination(queryParams.getPage(), queryParams.getPerPage(), total);
        return Base.responsePagination(response, pagination);
    }

    @GetMapping("/{id}")
    public Response show(@PathVariable Integer id) {
        DistrictModel district = this.districtApplication.detailDistrict(id);
        DistrictDetail districtDetail = new DistrictDetail(district);
        return Base.responseData(districtDetail);
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable Integer id, @Valid @RequestBody DistrictUpdate districtUpdate, Errors errors)
            throws ValidationException {
        Base.validationCheck(errors);
        this.districtApplication.updateDistrictFromAPI(id, districtUpdate);
        return Base.responseMessage("updated of district");
    }

    @PostMapping("")
    public Response store(@Valid @RequestBody DistrictCreate districtCreate, Errors errors) throws ValidationException {
        Base.validationCheck(errors);
        this.districtApplication.createDistrictFromAPI(districtCreate);
        return Base.responseMessage("stored of district");
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Integer id) {
        this.districtApplication.deleteDistrictFromAPI(id);
        return Base.responseMessage("delete of district");
    }
}
