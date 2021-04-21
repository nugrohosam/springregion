package com.nugrohosamiyono.springregion.Repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nugrohosamiyono.springregion.Models.VillageModel;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public class VillageRepository implements Repository<VillageModel, Integer> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<VillageModel> findAllLimitOffsetByCustomQuery(String search, int offset, int limit) {
        return this.entityManager
                .createQuery("SELECT cm FROM city_model cm WHERE cm.name LIKE '%" + search + "%'", VillageModel.class)
                .setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public Optional<VillageModel> findById(Integer id) {
        VillageModel cityModel = this.entityManager.find(VillageModel.class, id);
        return Optional.of(cityModel);
    }

    public void save(VillageModel cityModel) {
        this.entityManager.persist(cityModel);
    }

    public void deleteById(Integer id) {
        VillageModel cityModel = this.findById(id).get();
        this.entityManager.remove(cityModel);
    }
}
