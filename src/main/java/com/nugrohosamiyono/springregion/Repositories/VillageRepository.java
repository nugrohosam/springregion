package com.nugrohosamiyono.springregion.Repositories;

import com.nugrohosamiyono.springregion.Models.VillageModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepository extends CrudRepository<VillageModel, Integer> {
    
}
