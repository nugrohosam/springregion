package com.nugrohosamiyono.springregion.Applications;

import java.util.Optional;

import com.nugrohosamiyono.springregion.Models.StateModel;
import com.nugrohosamiyono.springregion.Repositories.CountryRepository;
import com.nugrohosamiyono.springregion.Repositories.StateRepository;
import com.nugrohosamiyono.springregion.Requests.QueryParams;
import com.nugrohosamiyono.springregion.Requests.State.StateCreate;
import com.nugrohosamiyono.springregion.Requests.State.StateUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateApplication {

    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CountryRepository countryRepository;

    public void createStateFromAPI(StateCreate stateCreate) throws RuntimeException {
        StateModel newState = new StateModel();
        newState.setCountry(this.countryRepository.findById(stateCreate.countryid).get());
        newState.setName(stateCreate.name);

        this.stateRepository.save(newState);
    }

    public void updateStateFromAPI(Integer id, StateUpdate stateUpdate) {
        Optional<StateModel> stateOpt = this.stateRepository.findById(id);

        StateModel updatState = stateOpt.get();
        updatState.setCountry(this.countryRepository.findById(stateUpdate.countryid).get());
        updatState.setName(stateUpdate.name);
        this.stateRepository.save(updatState);
    }

    public void deleteStateFromAPI(Integer id) {
        this.stateRepository.deleteById(id);
    }

    public Iterable<StateModel> getStateFromAPI(QueryParams queryParams) {
        int offset = (queryParams.getPage() - 1) * queryParams.getPage();
        return this.stateRepository.findAllLimitOffsetByCustomQuery(queryParams.getSearch(), offset,
                queryParams.getPerPage());
    }

    public StateModel detailState(Integer id) {
        Optional<StateModel> stateOpt = this.stateRepository.findById(id);
        if (stateOpt.isEmpty()) {
            return null;
        }

        return stateOpt.get();
    }
}
