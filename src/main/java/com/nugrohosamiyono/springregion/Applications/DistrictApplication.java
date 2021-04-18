package com.nugrohosamiyono.springregion.Applications;

import java.util.Optional;

import com.nugrohosamiyono.springregion.Models.DistrictModel;
import com.nugrohosamiyono.springregion.Repositories.CityRepository;
import com.nugrohosamiyono.springregion.Repositories.DistrictRepository;
import com.nugrohosamiyono.springregion.Requests.District.DistrictCreate;
import com.nugrohosamiyono.springregion.Requests.District.DistrictUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistrictApplication {

    @Autowired
    private DistrictRepository DistrictRepository;
    @Autowired
    private CityRepository cityRepository;

    public void createDistrictFromAPI(DistrictCreate districtCreate) {

        DistrictModel newDistrict = new DistrictModel();
        newDistrict.setCity(this.cityRepository.findById(districtCreate.cityid).get());
        newDistrict.setName(districtCreate.name);

        this.DistrictRepository.save(newDistrict);
    }

    public void updateDistrictFromAPI(Integer id, DistrictUpdate districtUpdate) {
        Optional<DistrictModel> DistrictOpt = this.DistrictRepository.findById(id);

        DistrictModel updatDistrict = DistrictOpt.get();
        updatDistrict.setCity(this.cityRepository.findById(districtUpdate.cityid).get());
        updatDistrict.setName(districtUpdate.name);
        this.DistrictRepository.save(updatDistrict);
    }

    public void deleteDistrictFromAPI(Integer id) {
        this.DistrictRepository.deleteById(id);
    }

    public Iterable<DistrictModel> getDistrictFromAPI() {
        return this.DistrictRepository.findAll();
    }

    public DistrictModel detailDistrict(Integer id) {
        return this.DistrictRepository.findById(id).get();
    }
}
