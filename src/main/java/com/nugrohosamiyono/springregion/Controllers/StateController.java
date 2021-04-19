package com.nugrohosamiyono.springregion.Controllers;

import javax.validation.Valid;

import com.nugrohosamiyono.springregion.Applications.StateApplication;
import com.nugrohosamiyono.springregion.Helpers.Response;
import com.nugrohosamiyono.springregion.Helpers.ResponseMessage;
import com.nugrohosamiyono.springregion.Helpers.ResponseValidation;
import com.nugrohosamiyono.springregion.Models.StateModel;
import com.nugrohosamiyono.springregion.Requests.State.StateCreate;
import com.nugrohosamiyono.springregion.Requests.State.StateUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateApplication stateApplication;

    @GetMapping("")
    public Iterable<StateModel> index() {
        return this.stateApplication.getStateFromAPI();
    }

    @GetMapping("/{id}")
    public StateModel show(@PathVariable Integer id) {
        return this.stateApplication.detailState(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody StateUpdate stateUpdate) {
        this.stateApplication.updateStateFromAPI(id, stateUpdate);
        return "detail of state";
    }

    @PostMapping("")
    public Response store(@Valid @RequestBody StateCreate stateCreate, Errors errors) {

        if (errors.hasErrors()) {
            List<FieldError> objecteErrors = errors.getFieldErrors();
            return (new ResponseValidation(objecteErrors));
        }

        this.stateApplication.createStateFromAPI(stateCreate);
        return (new ResponseMessage("Success create"));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        this.stateApplication.deleteStateFromAPI(id);
        return "delete of state";
    }
}
