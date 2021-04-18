package com.nugrohosamiyono.springregion.Repositories;

import com.nugrohosamiyono.springregion.Models.StateModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<StateModel, Integer> {
    
}
