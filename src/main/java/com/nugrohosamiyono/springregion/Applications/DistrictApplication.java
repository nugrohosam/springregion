package com.nugrohosamiyono.springregion.Applications;

import java.util.Optional;

import com.nugrohosamiyono.springregion.Models.DistrictModel;
import com.nugrohosamiyono.springregion.Repositories.CityRepository;
import com.nugrohosamiyono.springregion.Repositories.DistrictRepository;
import com.nugrohosamiyono.springregion.Requests.QueryParams;
import com.nugrohosamiyono.springregion.Requests.District.DistrictCreate;
import com.nugrohosamiyono.springregion.Requests.District.DistrictUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistrictApplication {

    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private CityRepository cityRepository;

    public void createDistrictFromAPI(DistrictCreate districtCreate) {

        DistrictModel newDistrict = new DistrictModel();
        newDistrict.setCity(this.cityRepository.findById(districtCreate.cityid).get());
        newDistrict.setName(districtCreate.name);

        this.districtRepository.save(newDistrict);
    }

    public void updateDistrictFromAPI(Integer id, DistrictUpdate districtUpdate) {
        Optional<DistrictModel> DistrictOpt = this.districtRepository.findById(id);

        DistrictModel updatDistrict = DistrictOpt.get();
        updatDistrict.setCity(this.cityRepository.findById(districtUpdate.cityid).get());
        updatDistrict.setName(districtUpdate.name);
        this.districtRepository.save(updatDistrict);
    }

    public void deleteDistrictFromAPI(Integer id) {
        this.districtRepository.deleteById(id);
    }

    public Iterable<DistrictModel> getDistrictFromAPI(QueryParams queryParams) {
        int offset = (queryParams.getPage() - 1) * queryParams.getPage();
        return this.districtRepository.findAllLimitOffsetByCustomQuery(queryParams.getSearch(), offset,
                queryParams.getPerPage());
    }

    public DistrictModel detailDistrict(Integer id) {
        Optional<DistrictModel> districtOpt = this.districtRepository.findById(id);
        if (districtOpt.isEmpty()) {
            return null;
        }

        return districtOpt.get();
    }
}
