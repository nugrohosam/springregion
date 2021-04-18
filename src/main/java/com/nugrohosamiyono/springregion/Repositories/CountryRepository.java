package com.nugrohosamiyono.springregion.Repositories;

import com.nugrohosamiyono.springregion.Models.CountryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<CountryModel, Integer> {
    
}
