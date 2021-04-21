package com.nugrohosamiyono.springregion.Repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nugrohosamiyono.springregion.Models.CountryModel;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public class CountryRepository implements Repository<CountryModel, Integer> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CountryModel> findAllLimitOffsetByCustomQuery(String search, int offset, int limit) {
        return this.entityManager
                .createQuery("SELECT cm FROM city_model cm WHERE cm.name LIKE '%" + search + "%'", CountryModel.class)
                .setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public Optional<CountryModel> findById(Integer id) {
        CountryModel cityModel = this.entityManager.find(CountryModel.class, id);
        return Optional.of(cityModel);
    }

    public void save(CountryModel cityModel) {
        this.entityManager.persist(cityModel);
    }

    public void deleteById(Integer id) {
        CountryModel cityModel = this.findById(id).get();
        this.entityManager.remove(cityModel);
    }
}
