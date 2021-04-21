package com.nugrohosamiyono.springregion.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name = "village_model") // This tells Hibernate to make a table out of this class
@Table(name = "village_model")
public class VillageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne(targetEntity = DistrictModel.class)
    @JoinColumn(name = "district_id")
    private DistrictModel district;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DistrictModel getDistrict() {
        return district;
    }

    public void setDistrict(DistrictModel district) {
        this.district = district;
    }
}
