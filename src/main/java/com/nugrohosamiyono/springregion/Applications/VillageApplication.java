package com.nugrohosamiyono.springregion.Applications;

import java.util.Optional;

import com.nugrohosamiyono.springregion.Models.VillageModel;
import com.nugrohosamiyono.springregion.Repositories.DistrictRepository;
import com.nugrohosamiyono.springregion.Repositories.VillageRepository;
import com.nugrohosamiyono.springregion.Requests.QueryParams;
import com.nugrohosamiyono.springregion.Requests.Village.VillageCreate;
import com.nugrohosamiyono.springregion.Requests.Village.VillageUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VillageApplication {

    @Autowired
    private VillageRepository villageRepository;
    @Autowired
    private DistrictRepository disrictRepository;

    public void createVillageFromAPI(VillageCreate vilagaCreate) {

        VillageModel newVillage = new VillageModel();
        newVillage.setDistrict(this.disrictRepository.findById(vilagaCreate.districtid).get());
        newVillage.setName(vilagaCreate.name);

        this.villageRepository.save(newVillage);
    }

    public void updateVillageFromAPI(Integer id, VillageUpdate villageUpdate) {
        Optional<VillageModel> VillageOpt = this.villageRepository.findById(id);

        VillageModel updatVillage = VillageOpt.get();
        updatVillage.setDistrict(this.disrictRepository.findById(villageUpdate.districtid).get());
        updatVillage.setName(villageUpdate.name);
        this.villageRepository.save(updatVillage);
    }

    public void deleteVillageFromAPI(Integer id) {
        this.villageRepository.deleteById(id);
    }

    public Iterable<VillageModel> getVillageFromAPI(QueryParams queryParams) {
        int offset = (queryParams.getPage() - 1) * queryParams.getPage();
        return this.villageRepository.findAllLimitOffsetByCustomQuery(queryParams.getSearch(), offset,
                queryParams.getPerPage());
    }

    public VillageModel detailVillage(Integer id) {
        Optional<VillageModel> villageOpt = this.villageRepository.findById(id);
        if (villageOpt.isEmpty()) {
            return null;
        }

        return villageOpt.get();
    }
}
