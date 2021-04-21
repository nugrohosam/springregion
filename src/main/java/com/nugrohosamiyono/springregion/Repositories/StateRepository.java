package com.nugrohosamiyono.springregion.Repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Models.StateModel;
import org.springframework.data.repository.Repository;

import org.springframework.stereotype.Component;

@Component
public class StateRepository implements Repository<StateModel, Integer> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<StateModel> findAllSearchLimitOffset(String search, int offset, int limit) {
        return this.entityManager
                .createQuery("SELECT sm FROM state_model sm WHERE sm.name LIKE '%" + search + "%'", StateModel.class)
                .setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public Optional<StateModel> findById(Integer id) {
        StateModel stateModel = this.entityManager.find(StateModel.class, id);
        if (stateModel == null) {
            return Optional.empty();
        }

        return Optional.of(stateModel);
    }

    public List<StateModel> findAllWhereInCountry(List<Object> stateIds) {
        String whereIn = Base.queryWhereIn(stateIds);

        return this.entityManager
                .createQuery("SELECT sm FROM state_model sm WHERE sm.country_id IN " + whereIn, StateModel.class)
                .getResultList();
    }

    public List<StateModel> findAllWhereInId(List<Object> id) {
        String whereIn = Base.queryWhereIn(id);

        return this.entityManager
                .createQuery("SELECT sm FROM state_model sm WHERE sm.id IN " + whereIn, StateModel.class)
                .getResultList();
    }

    public void save(StateModel stateModel) {
        this.entityManager.persist(stateModel);
    }

    public void deleteById(Integer id) {
        StateModel stateModel = this.findById(id).get();
        this.entityManager.remove(stateModel);
    }
}
