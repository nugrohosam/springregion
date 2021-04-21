package com.nugrohosamiyono.springregion.Repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nugrohosamiyono.springregion.Models.CountryModel;
import org.springframework.data.repository.Repository;

import org.springframework.stereotype.Component;

@Component
public class CountryRepository implements Repository<CountryModel, Integer> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CountryModel> findAllLimitOffsetByCustomQuery(String search, int offset, int limit) {
        return this.entityManager.createQuery("SELECT cm FROM country_model cm WHERE cm.name LIKE '%" + search + "%'",
                CountryModel.class).setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public Optional<CountryModel> findById(Integer id) {
        CountryModel countryModel = this.entityManager.find(CountryModel.class, id);
        if (countryModel == null) {
            return Optional.empty();
        }

        return Optional.of(countryModel);
    }

    public void save(CountryModel countryModel) {
        this.entityManager.persist(countryModel);
    }

    public void deleteById(Integer id) {
        CountryModel countryModel = this.findById(id).get();
        this.entityManager.remove(countryModel);
    }
}
