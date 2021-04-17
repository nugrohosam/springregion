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
@RequestMapping("/city")
public class CityController {

    @GetMapping("")
    public String index() {
        return "list of city";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id) {
        return "detail of city";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id) {
        return "detail of city";
    }

    @PostMapping("")
    public String store(@RequestBody CityCreate cityCrate) {
        return "detail of city";
    }

    @DeleteMapping("")
    public String store(@PathVariable Integer id) {
        return "delete of city";
    }
}

class CityCreate {
    String name;
}