package com.nugrohosamiyono.springregion.Repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Models.CityModel;
import org.springframework.data.repository.Repository;

import org.springframework.stereotype.Component;

@Component
public class CityRepository implements Repository<CityModel, Integer> {

    @PersistenceContext
    private EntityManager entityManager;

    // Where in subquery select
    // SELECT cm FROM city_model cm INNER JOIN cm.state sm WHERE cm.name LIKE '%" +
    // search
    // + "%' AND sm.id IN ( SELECT ssm.id FROM cm.state ssm WHERE ssm.name like '%"
    // + search
    // + "%' )

    // Join
    // INNER JOIN cm.state sm

    public List<CityModel> findAllSearchLimitOffset(String search, int offset, int limit) {
        return this.entityManager
                .createQuery("SELECT cm FROM city_model cm WHERE cm.name LIKE '%" + search + "%'", CityModel.class)
                .setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public List<CityModel> findAllWhereInState(List<Object> stateIds) {
        String whereIn = Base.queryWhereIn(stateIds);

        return this.entityManager
                .createQuery("SELECT cm FROM city_model cm WHERE cm.state_id IN " + whereIn, CityModel.class)
                .getResultList();
    }

    public List<CityModel> findAllWhereInId(List<Object> id) {
        String whereIn = Base.queryWhereIn(id);

        return this.entityManager.createQuery("SELECT cm FROM city_model cm WHERE cm.id IN " + whereIn, CityModel.class)
                .getResultList();
    }

    public Optional<CityModel> findById(Integer id) {
        CityModel cityModel = this.entityManager.find(CityModel.class, id);
        if (cityModel == null) {
            return Optional.empty();
        }
        return Optional.of(cityModel);
    }

    public void save(CityModel cityModel) {
        this.entityManager.persist(cityModel);
    }

    public void deleteById(Integer id) {
        CityModel cityModel = this.findById(id).get();
        this.entityManager.remove(cityModel);
    }
}
