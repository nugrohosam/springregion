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
@RequestMapping("/state")
public class StateController {

    @GetMapping("")
    public String index() {
        return "list of state";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id) {
        return "detail of state";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody StateUpdate stateUpdate) {
        return "detail of state";
    }

    @PostMapping("")
    public String store(@RequestBody StateCreate stateCrate) {
        return "detail of state";
    }

    @DeleteMapping("")
    public String store(@PathVariable Integer id) {
        return "delete of state";
    }
}

class StateCreate {
    Integer countryid;
    String name;
}

class StateUpdate {
    Integer countryid;
    String name;
}