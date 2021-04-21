package com.nugrohosamiyono.springregion.Repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nugrohosamiyono.springregion.Models.VillageModel;
import org.springframework.data.repository.Repository;

import org.springframework.stereotype.Component;

@Component
public class VillageRepository implements Repository<VillageModel, Integer> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<VillageModel> findAllLimitOffsetByCustomQuery(String search, int offset, int limit) {
        return this.entityManager.createQuery("SELECT vm FROM village_model vm WHERE vm.name LIKE '%" + search + "%'",
                VillageModel.class).setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public Optional<VillageModel> findById(Integer id) {
        VillageModel villageModel = this.entityManager.find(VillageModel.class, id);
        if (villageModel == null) {
            return Optional.empty();
        }
        return Optional.of(villageModel);
    }

    public void save(VillageModel villageModel) {
        this.entityManager.persist(villageModel);
    }

    public void deleteById(Integer id) {
        VillageModel villageModel = this.findById(id).get();
        this.entityManager.remove(villageModel);
    }
}
