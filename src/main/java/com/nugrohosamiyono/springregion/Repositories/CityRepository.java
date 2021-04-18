package com.nugrohosamiyono.springregion.Repositories;

import com.nugrohosamiyono.springregion.Models.CityModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<CityModel, Integer> {
    
}
