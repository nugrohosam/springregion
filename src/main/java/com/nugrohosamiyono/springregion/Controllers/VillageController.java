package com.nugrohosamiyono.springregion.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.nugrohosamiyono.springregion.Applications.VillageApplication;
import com.nugrohosamiyono.springregion.Exceptions.ValidationException;
import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Helpers.Response;
import com.nugrohosamiyono.springregion.Models.VillageModel;
import com.nugrohosamiyono.springregion.Requests.Village.VillageCreate;
import com.nugrohosamiyono.springregion.Requests.Village.VillageUpdate;
import com.nugrohosamiyono.springregion.Responses.Village.VillageDetail;
import com.nugrohosamiyono.springregion.Responses.Village.VillageItem;

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
@RequestMapping("/village")
public class VillageController {

    @Autowired
    private VillageApplication villageApplication;

    @GetMapping("")
    public Response index() {
        Iterable<VillageModel> villages = this.villageApplication.getVillageFromAPI();
        List<Object> villagesItems = VillageItem.toMap(villages);
        return Base.responseList(villagesItems);
    }

    @GetMapping("/{id}")
    public Response show(@PathVariable Integer id) {
        VillageModel village = this.villageApplication.detailVillage(id);
        VillageDetail villageDetail = new VillageDetail(village);
        return Base.responseData(villageDetail);
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable Integer id, @Valid @RequestBody VillageUpdate villageUpdate, Errors errors)
            throws ValidationException {
        Base.validationCheck(errors);
        this.villageApplication.updateVillageFromAPI(id, villageUpdate);
        return Base.responseMessage("updated of village");
    }

    @PostMapping("")
    public Response store(@Valid @RequestBody VillageCreate villageCreate, Errors errors) throws ValidationException {
        Base.validationCheck(errors);
        this.villageApplication.createVillageFromAPI(villageCreate);
        return Base.responseMessage("stored of village");
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Integer id) {
        this.villageApplication.deleteVillageFromAPI(id);
        return Base.responseMessage("deleted of village");
    }
}
