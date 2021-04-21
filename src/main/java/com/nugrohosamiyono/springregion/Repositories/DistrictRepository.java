package com.nugrohosamiyono.springregion.Repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nugrohosamiyono.springregion.Models.DistrictModel;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public class DistrictRepository implements Repository<DistrictModel, Integer> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<DistrictModel> findAllLimitOffsetByCustomQuery(String search, int offset, int limit) {
        return this.entityManager
                .createQuery("SELECT cm FROM city_model cm WHERE cm.name LIKE '%" + search + "%'", DistrictModel.class)
                .setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public Optional<DistrictModel> findById(Integer id) {
        DistrictModel cityModel = this.entityManager.find(DistrictModel.class, id);
        return Optional.of(cityModel);
    }

    public void save(DistrictModel cityModel) {
        this.entityManager.persist(cityModel);
    }

    public void deleteById(Integer id) {
        DistrictModel cityModel = this.findById(id).get();
        this.entityManager.remove(cityModel);
    }
}
