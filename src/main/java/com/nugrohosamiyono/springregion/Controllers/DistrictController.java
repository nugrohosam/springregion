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
@RequestMapping("/district")
public class DistrictController {

    @GetMapping("")
    public String index() {
        return "list of district";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id) {
        return "detail of district";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id) {
        return "detail of district";
    }

    @PostMapping("")
    public String store(@RequestBody DistrictCreate districtCrate) {
        return "detail of district";
    }

    @DeleteMapping("")
    public String store(@PathVariable Integer id) {
        return "delete of district";
    }
}

class DistrictCreate {
    String name;
}