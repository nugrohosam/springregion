package com.nugrohosamiyono.springregion.Repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Models.DistrictModel;
import org.springframework.data.repository.Repository;

import org.springframework.stereotype.Component;

@Component
public class DistrictRepository implements Repository<DistrictModel, Integer> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<DistrictModel> findAllSearchLimitOffset(String search, int offset, int limit) {
        return this.entityManager.createQuery("SELECT dm FROM district_model dm WHERE dm.name LIKE '%" + search + "%'",
                DistrictModel.class).setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public Optional<DistrictModel> findById(Integer id) {
        DistrictModel districtModel = this.entityManager.find(DistrictModel.class, id);
        if (districtModel == null) {
            return Optional.empty();
        }

        return Optional.of(districtModel);
    }

    public List<DistrictModel> findAllWhereInCity(List<Object> stateIds) {
        String whereIn = Base.queryWhereIn(stateIds);

        return this.entityManager
                .createQuery("SELECT dm FROM district_model dm WHERE dm.city_id IN " + whereIn, DistrictModel.class)
                .getResultList();
    }

    public List<DistrictModel> findAllWhereInId(List<Object> id) {
        String whereIn = Base.queryWhereIn(id);

        return this.entityManager
                .createQuery("SELECT dm FROM district_model dm WHERE dm.id IN " + whereIn, DistrictModel.class)
                .getResultList();
    }

    public void save(DistrictModel districtModel) {
        this.entityManager.persist(districtModel);
    }

    public void deleteById(Integer id) {
        DistrictModel districtModel = this.findById(id).get();
        this.entityManager.remove(districtModel);
    }
}
