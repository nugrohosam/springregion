package com.nugrohosamiyono.springregion.Repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nugrohosamiyono.springregion.Helpers.Base;
import com.nugrohosamiyono.springregion.Models.VillageModel;
import org.springframework.data.repository.Repository;

import org.springframework.stereotype.Component;

@Component
public class VillageRepository implements Repository<VillageModel, Integer> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<VillageModel> findAllSearchLimitOffset(String search, int offset, int limit) {
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

    public List<VillageModel> findAllWhereInDistrict(List<Object> villageIds) {
        String whereIn = Base.queryWhereIn(villageIds);

        return this.entityManager
                .createQuery("SELECT vm FROM village_model vm WHERE vm.district_id IN " + whereIn, VillageModel.class)
                .getResultList();
    }

    public List<VillageModel> findAllWhereInId(List<Object> id) {
        String whereIn = Base.queryWhereIn(id);

        return this.entityManager
                .createQuery("SELECT vm FROM village_model vm WHERE vm.id IN " + whereIn, VillageModel.class)
                .getResultList();
    }

    public void save(VillageModel villageModel) {
        this.entityManager.persist(villageModel);
    }

    public void deleteById(Integer id) {
        VillageModel villageModel = this.findById(id).get();
        this.entityManager.remove(villageModel);
    }
}
