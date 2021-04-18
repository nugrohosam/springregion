package com.nugrohosamiyono.springregion.Applications;

import java.util.Optional;

import com.nugrohosamiyono.springregion.Models.CityModel;
import com.nugrohosamiyono.springregion.Repositories.StateRepository;
import com.nugrohosamiyono.springregion.Repositories.CityRepository;
import com.nugrohosamiyono.springregion.Requests.City.CityCreate;
import com.nugrohosamiyono.springregion.Requests.City.CityUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityApplication {

    @Autowired
    private CityRepository CityRepository;
    @Autowired
    private StateRepository stateRepository;

    public void createCityFromAPI(CityCreate CityCreate) {

        CityModel newCity = new CityModel();
        newCity.setState(this.stateRepository.findById(CityCreate.stateid).get());
        newCity.setName(CityCreate.name);

        this.CityRepository.save(newCity);
    }

    public void updateCityFromAPI(Integer id, CityUpdate CityUpdate) {
        Optional<CityModel> CityOpt = this.CityRepository.findById(id);

        CityModel updatCity = CityOpt.get();
        updatCity.setState(this.stateRepository.findById(CityUpdate.stateid).get());
        updatCity.setName(CityUpdate.name);
        this.CityRepository.save(updatCity);
    }

    public void deleteCityFromAPI(Integer id) {
        this.CityRepository.deleteById(id);
    }

    public Iterable<CityModel> getCityFromAPI() {
        return this.CityRepository.findAll();
    }

    public CityModel detailCity(Integer id) {
        return this.CityRepository.findById(id).get();
    }
}
