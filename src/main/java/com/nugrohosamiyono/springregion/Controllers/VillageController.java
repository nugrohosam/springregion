package com.nugrohosamiyono.springregion.Controllers;

import com.nugrohosamiyono.springregion.Applications.VillageApplication;
import com.nugrohosamiyono.springregion.Models.VillageModel;
import com.nugrohosamiyono.springregion.Requests.Village.VillageCreate;
import com.nugrohosamiyono.springregion.Requests.Village.VillageUpdate;

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
@RequestMapping("/village")
public class VillageController {

    @Autowired
    private VillageApplication villageApplication;

    @GetMapping("")
    public Iterable<VillageModel> index() {
        return this.villageApplication.getVillageFromAPI();
    }

    @GetMapping("/{id}")
    public VillageModel show(@PathVariable Integer id) {
        return this.villageApplication.detailVillage(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody VillageUpdate villageUpdate) {
        this.villageApplication.updateVillageFromAPI(id, villageUpdate);
        return "detail of village";
    }

    @PostMapping("")
    public String store(@RequestBody VillageCreate villageCreate) {
        this.villageApplication.createVillageFromAPI(villageCreate);
        return "detail of village";
    }

    @DeleteMapping("")
    public String store(@PathVariable Integer id) {
        this.villageApplication.deleteVillageFromAPI(id);
        return "delete of village";
    }
}
