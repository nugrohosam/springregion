package com.nugrohosamiyono.springregion.Repositories;

import com.nugrohosamiyono.springregion.Models.DistrictModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends CrudRepository<DistrictModel, Integer> {
    
}
