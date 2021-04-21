package com.nugrohosamiyono.springregion.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.nugrohosamiyono.springregion.Applications.StateApplication;
import com.nugrohosamiyono.springregion.Exceptions.ValidationException;
import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Helpers.Responses.Response;
import com.nugrohosamiyono.springregion.Models.StateModel;
import com.nugrohosamiyono.springregion.Requests.QueryParams;
import com.nugrohosamiyono.springregion.Requests.State.StateCreate;
import com.nugrohosamiyono.springregion.Requests.State.StateUpdate;
import com.nugrohosamiyono.springregion.Responses.Pagination;
import com.nugrohosamiyono.springregion.Responses.State.StateDetail;
import com.nugrohosamiyono.springregion.Responses.State.StateItem;

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
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateApplication stateApplication;

    @GetMapping("")
    public Response index(QueryParams queryParams) {
        Iterable<StateModel> states;

        states = this.stateApplication.getStateFromAPI(queryParams);
        List<Object> response = StateItem.toMap(states);
        if (!queryParams.isPagination()) {
            return Base.responseList(response);
        }

        int total = IterableUtils.size(states);
        Pagination pagination = new Pagination(queryParams.getPage(), queryParams.getPerPage(), total);
        return Base.responsePagination(response, pagination);
    }

    @GetMapping("/{id}")
    public Response show(@PathVariable Integer id) {
        StateModel state = this.stateApplication.detailState(id);
        if (state == null) {
            return Base.responseData(null);
        }

        StateDetail stateDetail = new StateDetail(state);
        return Base.responseData(stateDetail);
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable Integer id, @Valid @RequestBody StateUpdate stateUpdate, Errors errors)
            throws ValidationException {
        Base.validationCheck(errors);

        this.stateApplication.updateStateFromAPI(id, stateUpdate);
        return Base.responseMessage("updated of state");
    }

    @PostMapping("")
    public Response store(@Valid @RequestBody StateCreate stateCreate, Errors errors) throws ValidationException {
        Base.validationCheck(errors);

        this.stateApplication.createStateFromAPI(stateCreate);
        return Base.responseMessage("stored state");
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Integer id) {
        this.stateApplication.deleteStateFromAPI(id);
        return Base.responseMessage("delete of state");
    }
}
