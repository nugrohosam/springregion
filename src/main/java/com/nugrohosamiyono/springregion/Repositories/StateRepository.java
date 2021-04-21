package com.nugrohosamiyono.springregion.Repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nugrohosamiyono.springregion.Models.StateModel;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public class StateRepository implements Repository<StateModel, Integer> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<StateModel> findAllLimitOffsetByCustomQuery(String search, int offset, int limit) {
        return this.entityManager
                .createQuery("SELECT cm FROM city_model cm WHERE cm.name LIKE '%" + search + "%'", StateModel.class)
                .setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public Optional<StateModel> findById(Integer id) {
        StateModel cityModel = this.entityManager.find(StateModel.class, id);
        return Optional.of(cityModel);
    }

    public void save(StateModel cityModel) {
        this.entityManager.persist(cityModel);
    }

    public void deleteById(Integer id) {
        StateModel cityModel = this.findById(id).get();
        this.entityManager.remove(cityModel);
    }
}
