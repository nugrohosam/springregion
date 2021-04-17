package com.nugrohosamiyono.springregion.Controllers;

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

    @GetMapping("")
    public String index() {
        return "list of village";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id) {
        return "detail of village";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id) {
        return "detail of village";
    }

    @PostMapping("")
    public String store(@RequestBody VillageCreate villageCrate) {
        return "detail of village";
    }

    @DeleteMapping("")
    public String store(@PathVariable Integer id) {
        return "delete of village";
    }
}

class VillageCreate {
    String name;
}