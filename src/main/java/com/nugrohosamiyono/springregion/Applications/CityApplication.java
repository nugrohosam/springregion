package com.nugrohosamiyono.springregion.Applications;

import java.util.Optional;

import com.nugrohosamiyono.springregion.Models.CityModel;
import com.nugrohosamiyono.springregion.Repositories.StateRepository;
import com.nugrohosamiyono.springregion.Repositories.CityRepository;
import com.nugrohosamiyono.springregion.Requests.QueryParams;
import com.nugrohosamiyono.springregion.Requests.City.CityCreate;
import com.nugrohosamiyono.springregion.Requests.City.CityUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityApplication {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private StateRepository stateRepository;

    public void createCityFromAPI(CityCreate cityCreate) {
        CityModel newCity = new CityModel();
        newCity.setState(this.stateRepository.findById(cityCreate.stateid).get());
        newCity.setName(cityCreate.name);

        this.cityRepository.save(newCity);
    }

    public void updateCityFromAPI(Integer id, CityUpdate cityUpdate) {
        Optional<CityModel> CityOpt = this.cityRepository.findById(id);

        CityModel updatCity = CityOpt.get();
        updatCity.setState(this.stateRepository.findById(cityUpdate.stateid).get());
        updatCity.setName(cityUpdate.name);
        this.cityRepository.save(updatCity);
    }

    public void deleteCityFromAPI(Integer id) {
        this.cityRepository.deleteById(id);
    }

    public Iterable<CityModel> getCityFromAPI(QueryParams queryParams) {
        int offset = (queryParams.getPage() - 1) * queryParams.getPage();
        return this.cityRepository.findAllSearchLimitOffset(queryParams.getSearch(), offset, queryParams.getPerPage());
    }

    public CityModel detailCity(Integer id) {
        Optional<CityModel> cityOpt = this.cityRepository.findById(id);
        if (cityOpt.isEmpty()) {
            return null;
        }

        return cityOpt.get();
    }
}
