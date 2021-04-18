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

    public void createCityFromAPI(CityCreate cityCreate) {
        CityModel newCity = new CityModel();
        newCity.setState(this.stateRepository.findById(cityCreate.stateid).get());
        newCity.setName(cityCreate.name);

        this.CityRepository.save(newCity);
    }

    public void updateCityFromAPI(Integer id, CityUpdate cityUpdate) {
        Optional<CityModel> CityOpt = this.CityRepository.findById(id);

        CityModel updatCity = CityOpt.get();
        updatCity.setState(this.stateRepository.findById(cityUpdate.stateid).get());
        updatCity.setName(cityUpdate.name);
        this.CityRepository.save(updatCity);
    }

    public void deleteCityFromAPI(Integer id) {
        this.CityRepository.deleteById(id);
    }

    public Iterable<CityModel> getCityFromAPI() {
        return this.CityRepository.findAll();
    }

    public CityModel detailCity(Integer id) {
        Optional<CityModel> cityOpt = this.CityRepository.findById(id);
        if (cityOpt.isEmpty()){
            return (new CityModel());
        }

        return cityOpt.get();
    }
}
